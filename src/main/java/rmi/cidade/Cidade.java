package rmi.cidade;

import java.io.Serializable;

public class Cidade implements Serializable {
    private String ibge;
    private String nome;

    public Cidade() {
    }

    public Cidade(String ibge, String nome) {
        this.ibge = ibge;
        this.nome = nome;
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

    public String toString() {
        return "Cidade{ibge='" + this.ibge + "',nome='" + this.nome + "'}";
    }
}

