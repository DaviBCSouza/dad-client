package rmi.ubs;

import java.io.Serializable;

public class UnidadeSaude implements Serializable {
    private String cnes;
    private String name;

    public UnidadeSaude() {
    }

    public UnidadeSaude(String cnes, String name) {
        this.cnes = cnes;
        this.name = name;
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

    @Override
    public String toString() {
        return "UnidadeSaude{" +
                "cnes='" + cnes + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
