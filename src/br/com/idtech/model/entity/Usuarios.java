package br.com.idtech.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by DOM on 02/12/2016.
 */
@Entity
public class Usuarios {
    private int usuarioId;
    private String user;
    private String pass;
    private Integer userTipo;
    private String nome;

    @Id
    @Column(name = "usuario_id")
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Basic
    @Column(name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "pass")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "user_tipo")
    public Integer getUserTipo() {
        return userTipo;
    }

    public void setUserTipo(Integer userTipo) {
        this.userTipo = userTipo;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuarios usuarios = (Usuarios) o;

        if (usuarioId != usuarios.usuarioId) return false;
        if (user != null ? !user.equals(usuarios.user) : usuarios.user != null) return false;
        if (pass != null ? !pass.equals(usuarios.pass) : usuarios.pass != null) return false;
        if (userTipo != null ? !userTipo.equals(usuarios.userTipo) : usuarios.userTipo != null) return false;
        if (nome != null ? !nome.equals(usuarios.nome) : usuarios.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usuarioId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (userTipo != null ? userTipo.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
