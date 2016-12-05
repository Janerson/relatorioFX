package br.com.idtech.model.entity;

import java.math.BigInteger;

/**
 * Created by Lab on 05/12/2016.
 */
public class SenhasUsuario {
    private int total;
    private String usuario;


    public SenhasUsuario() {
    }


    public String getUsuario() {
        return usuario;
    }

    public void setServico(String usuario) {
        this.usuario = usuario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total.intValue();
    }
}
