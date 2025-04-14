package cliente;

import java.util.Optional;
import java.util.Scanner;

import rmi.cidade.Cidade;
import rmi.cidade.ICidadeService;
import rmi.ocupacao.Cbo;
import rmi.ocupacao.ICboService;
import rmi.ubs.IUnidadeSaudeService;
import rmi.ubs.UnidadeSaude;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ClienteRMI {
    public static void main(String[] args) {
        String host = "localhost";
        String hostCity = "localhost";
        String hostOcupation = "localhost";
        int port = 2000;
        String urlCidade = "rmi://" + hostCity + ":" + port + "/cidades";
        String urlOcupacao = "rmi://" + hostOcupation + ":" + port + "/ocupacoes";
        String urlUnidadeSaude = "rmi://" + host + ":" + port + "/unidadesSaude";

        try {
            // Registries
            Registry registry = LocateRegistry.getRegistry(host, port);
            Registry registryCity = LocateRegistry.getRegistry(hostCity, port);
            Registry registryOcupation = LocateRegistry.getRegistry(hostOcupation, port);

            // Implements
            ICidadeService cidade = (ICidadeService) registryCity.lookup(urlCidade);
            ICboService ocupacao = (ICboService) registryOcupation.lookup(urlOcupacao);
            IUnidadeSaudeService ubs = (IUnidadeSaudeService) registry.lookup(urlUnidadeSaude);
            Scanner scanner = new Scanner(System.in);

            // Lists
            List<Cidade> cidades = cidade.getCidades();
            List<Cbo> ocupacoes = ocupacao.getListCbo();
            List<UnidadeSaude> unidadesSaude = ubs.getAll();

            // Auxs
            PessoaService pessoaService = new PessoaService();
            String option;

            do {
                System.out.println("\n----------------------MENU-------------------------");
                System.out.println("1 - Cadastrar Pessoa");
                System.out.println("2 - Listar Pessoa por índice");
                System.out.println("3 - Sair");
                System.out.println("---------------------------------------------------");
                System.out.print("Escolha uma opção: ");
                option = scanner.nextLine().trim();

                switch (option) {
                    case "1":
                        System.out.print("\nDigite seu nome: ");
                        String name = scanner.nextLine();

                        System.out.print("\nDigite seu email: ");
                        String email = scanner.nextLine();

                        System.out.print("\nDigite seu telefone: ");
                        String phone = scanner.nextLine();

                        // Escolher cidade
                        System.out.println("\nCidades disponíveis:");
                        for (int i = 0; i < cidades.size(); i++) {
                            System.out.println(i + " - " + cidades.get(i).getNome());
                        }
                        System.out.print("Escolha uma cidade (índice): ");
                        int cidadeIndex = Integer.parseInt(scanner.nextLine());
                        Cidade cidadeSelecionada = cidades.get(cidadeIndex);

                        // Escolher ocupação
                        System.out.println("\nOcupações disponíveis:");
                        for (int i = 0; i < ocupacoes.size(); i++) {
                            System.out.println(i + " - " + ocupacoes.get(i).getProfissao());
                        }
                        System.out.print("Escolha uma ocupação (índice): ");
                        int ocupacaoIndex = Integer.parseInt(scanner.nextLine());
                        Cbo ocupacaoSelecionada = ocupacoes.get(ocupacaoIndex);

                        // Escolher UBS
                        System.out.println("\nUBS disponíveis:");
                        for (int i = 0; i < unidadesSaude.size(); i++) {
                            System.out.println(i + " - " + unidadesSaude.get(i).getName());
                        }
                        System.out.print("Escolha uma UBS (índice): ");
                        int ubsIndex = Integer.parseInt(scanner.nextLine());
                        UnidadeSaude ubsSelecionada = unidadesSaude.get(ubsIndex);

                        boolean saved = pessoaService.save(name, email, phone, cidadeSelecionada, ocupacaoSelecionada, ubsSelecionada);
                        System.out.println(saved ? "Pessoa cadastrada com sucesso!" : "Erro ao cadastrar pessoa.");
                        break;

                    case "2":
                        System.out.print("\nDigite o índice da pessoa: ");
                        int index = Integer.parseInt(scanner.nextLine());
                        Optional<Pessoa> pessoaOptional = pessoaService.list(index);
                        if (pessoaOptional.isPresent()) {
                            Pessoa pessoa = pessoaOptional.get();
                            System.out.println("Pessoa encontrada:");
                            System.out.println(pessoa);
                        } else {
                            System.out.println("\nPessoa não encontrada. Verifique o índice.");
                        }
                        break;

                    case "3":
                        System.out.println("\nAté a próxima! ^^");
                        break;

                    default:
                        System.out.println("\nOpção inválida. Tente novamente! :'(");
                        break;
                }

            } while (!option.equals("3"));

        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nÍndice inválido! Tente novamente.");
        } catch (NumberFormatException e) {
            System.out.println("\nEntrada inválida. Use apenas números onde for solicitado.");
        } catch (Exception e) {
            System.out.println("\nOcorreu um erro inesperado:");
            e.printStackTrace();
        }
    }
}

// PARA CONSULTAR MAIS TARDE
//            System.out.println("---- CIDADES ----");
//            List<Cidade> cidades = cidade.getCidades();
//            cidades.forEach(System.out::println);
//
//            System.out.println("---- OCUPAÇÕES ----");
//            List<Ocupacao> ocupacoes = ocupacao.getListOcupacao();
//            ocupacoes.forEach(System.out::println);
//
//            System.out.println("---- UBS ----");
//            List<UnidadeSaude> unidades = ubs.getAll();
//            unidades.forEach(System.out::println);