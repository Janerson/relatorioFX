package br.com.idtech.model.entity;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigInteger;

/**
 * Created by Lab on 05/12/2016.
 */

public class SenhaServico {

    private IntegerProperty total = new SimpleIntegerProperty();
    private StringProperty servico = new SimpleStringProperty();

    public SenhaServico() {}

    public int getTotal() {
        return total.get();
    }

    public IntegerProperty totalProperty() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total.set(total.intValue());
    }

    public String getServico() {
        return servico.get();
    }

    public StringProperty servicoProperty() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico.set(servico);
    }
}
