package br.com.idtech.model.entity;

import java.math.BigInteger;

/**
 * Created by Lab on 05/12/2016.
 */

public class SenhaServico {

    private int total;
    private String servico;


    public SenhaServico() {
    }



    public String getServico() {
        return servico;
    }

    public void setServico(String descricao) {
        this.servico = descricao;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total.intValue();
    }
}
