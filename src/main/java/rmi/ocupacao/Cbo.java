package rmi.ocupacao;

import java.io.Serializable;

public class Cbo implements Serializable {
    String profissao;
    String codCbo;

    public Cbo() {
    }

    public Cbo(String profissao, String codCbo) {
        this.profissao = profissao;
        this.codCbo = codCbo;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCodCbo() {
        return this.codCbo;
    }

    public void setCodCbo(String codCbo) {
        this.codCbo = codCbo;
    }
}
