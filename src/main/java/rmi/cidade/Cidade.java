package rmi.cidade;

import java.io.Serializable;

public class Cidade implements Serializable {
    private String ibge;
    private String nome;
    private int populacao;

    public Cidade() {
    }

    public Cidade(String ibge, String nome, int populacao) {
        this.ibge = ibge;
        this.nome = nome;
        this.populacao = populacao;
    }

    public String getIbge() {
        return this.ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return this.populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String toString() {
        return "rmi.cidade.Cidade{ibge='" + this.ibge + "', nome='" + this.nome + "', populacao=" + this.populacao + "}";
    }
}
