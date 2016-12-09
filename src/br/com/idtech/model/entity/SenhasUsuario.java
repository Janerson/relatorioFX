package br.com.idtech.model.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigInteger;

/**
 * Created by Lab on 05/12/2016.
 */
public class SenhasUsuario {
    private IntegerProperty total = new SimpleIntegerProperty();
    private StringProperty usuario = new SimpleStringProperty();


    public SenhasUsuario() {
    }

    public int getTotal() {
        return total.getValue();
    }

    public IntegerProperty totalProperty() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total.set(total.intValue());
    }

    public String getUsuario() {
        return usuario.get();
    }

    public StringProperty usuarioProperty() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario.set(usuario);
    }
}
