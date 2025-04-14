package cliente;

import rmi.cidade.Cidade;
import rmi.ocupacao.Cbo;
import rmi.ubs.UnidadeSaude;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaService {
    private final List<Pessoa> pessoas = new ArrayList<>();

    public Optional<Pessoa> list(int index) {
        if (index < 0 || index >= pessoas.size()) {
            return Optional.empty();
        }
        return Optional.of(pessoas.get(index));
    }

    public boolean save(String name, String email, String phone, Cidade city, Cbo ocupation, UnidadeSaude ubs) {
        if (name == null || email == null || phone == null || city == null || ocupation == null || ubs == null) {
            System.err.println("Erro: nenhum dos campos pode ser nulo.");
            return false;
        }

        Pessoa novaPessoa = new Pessoa(name.trim(), email.trim(), phone.trim(), city, ocupation, ubs);
        pessoas.add(novaPessoa);
        return false;
    }

    public List<Pessoa> getAll() {
        return new ArrayList<>(pessoas); // retorna uma cópia defensiva
    }

    public int count() {
        return pessoas.size();
    }
}
