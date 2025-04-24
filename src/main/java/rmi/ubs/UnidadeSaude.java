package rmi.ubs;

import java.io.Serializable;

public class UnidadeSaude implements Serializable {
    private String cnes;
    private String name;
    private String bairro;

    public UnidadeSaude() {
    }

    public UnidadeSaude(String cnes, String name, String bairro) {
        this.cnes = cnes;
        this.name = name;
        this.bairro = bairro;
    }

    public String getCnes() {
        return cnes;
    }

    public void setCnes(String cnes) {
        this.cnes = cnes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}

    @Override
    public String toString() {
        return "UnidadeSaude{" +
                "cnes='" + cnes + '\'' +
                ", name='" + name + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
