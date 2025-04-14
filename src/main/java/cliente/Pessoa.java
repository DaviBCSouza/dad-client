package cliente;

import rmi.cidade.Cidade;
import rmi.ocupacao.Cbo;
import rmi.ubs.UnidadeSaude;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String name;
    private String email;
    private String phone;
    private Cidade city;
    private Cbo ocupation;
    private UnidadeSaude ubs;

    public Pessoa() {
    }

    public Pessoa(String name, String email, String phone, Cidade city, Cbo ocupation, UnidadeSaude ubs) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.ocupation = ocupation;
        this.ubs = ubs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Cidade getCity() {
        return city;
    }

    public void setCity(Cidade city) {
        this.city = city;
    }

    public Cbo getOcupation() {
        return ocupation;
    }

    public void setOcupation(Cbo ocupation) {
        this.ocupation = ocupation;
    }

    public UnidadeSaude getUbs() {
        return ubs;
    }

    public void setUbs(UnidadeSaude ubs) {
        this.ubs = ubs;
    }

    @Override
    public String toString() {
        return "\n=========== PESSOA ===========" +
                "\nNome       : " + name +
                "\nEmail      : " + email +
                "\nTelefone   : " + phone +
                "\nCidade     : " + (city != null ? city.getNome() : "N/A") +
                "\nOcupação   : " + (ocupation != null ? ocupation.getProfissao() : "N/A") +
                "\nUBS        : " + (ubs != null ? ubs.getName() : "N/A") +
                "\n-----------------------------";
    }

}
