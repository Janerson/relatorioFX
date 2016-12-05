package br.com.idtech.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by DOM on 02/12/2016.
 */
@Entity
public class Senha {
    private int senhaId;
    private Integer senha;
    private Timestamp datahora;
    private Servicos servicoId;
    private Date data;
    private Timestamp chamada;
    private Usuarios usuarioId;
    private Timestamp avaliacao;
    private Integer nota;
    private Integer guicheId;
    private String repassada;
    private Timestamp rechamada;

    @Id
    @Column(name = "senha_id")
    public int getSenhaId() {
        return senhaId;
    }

    public void setSenhaId(int senhaId) {
        this.senhaId = senhaId;
    }

    @Basic
    @Column(name = "senha")
    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    @Basic
    @Column(name = "datahora")
    public Timestamp getDatahora() {
        return datahora;
    }

    public void setDatahora(Timestamp datahora) {
        this.datahora = datahora;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id")
    public Servicos getServicoId() {
        return servicoId;
    }

    public void setServicoId(Servicos servicoId) {
        this.servicoId = servicoId;
    }

    @Basic
    @Column(name = "data")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Basic
    @Column(name = "chamada")
    public Timestamp getChamada() {
        return chamada;
    }

    public void setChamada(Timestamp chamada) {
        this.chamada = chamada;
    }


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Basic
    @Column(name = "avaliacao")
    public Timestamp getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Timestamp avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Basic
    @Column(name = "nota")
    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Basic
    @Column(name = "guiche_id")
    public Integer getGuicheId() {
        return guicheId;
    }

    public void setGuicheId(Integer guicheId) {
        this.guicheId = guicheId;
    }

    @Basic
    @Column(name = "repassada")
    public String getRepassada() {
        return repassada;
    }

    public void setRepassada(String repassada) {
        this.repassada = repassada;
    }

    @Basic
    @Column(name = "rechamada")
    public Timestamp getRechamada() {
        return rechamada;
    }

    public void setRechamada(Timestamp rechamada) {
        this.rechamada = rechamada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Senha senha1 = (Senha) o;

        if (senhaId != senha1.senhaId) return false;
        if (senha != null ? !senha.equals(senha1.senha) : senha1.senha != null) return false;
        if (datahora != null ? !datahora.equals(senha1.datahora) : senha1.datahora != null) return false;
        if (servicoId != null ? !servicoId.equals(senha1.servicoId) : senha1.servicoId != null) return false;
        if (data != null ? !data.equals(senha1.data) : senha1.data != null) return false;
        if (chamada != null ? !chamada.equals(senha1.chamada) : senha1.chamada != null) return false;
        if (usuarioId != null ? !usuarioId.equals(senha1.usuarioId) : senha1.usuarioId != null) return false;
        if (avaliacao != null ? !avaliacao.equals(senha1.avaliacao) : senha1.avaliacao != null) return false;
        if (nota != null ? !nota.equals(senha1.nota) : senha1.nota != null) return false;
        if (guicheId != null ? !guicheId.equals(senha1.guicheId) : senha1.guicheId != null) return false;
        if (repassada != null ? !repassada.equals(senha1.repassada) : senha1.repassada != null) return false;
        if (rechamada != null ? !rechamada.equals(senha1.rechamada) : senha1.rechamada != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = senhaId;
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (datahora != null ? datahora.hashCode() : 0);
        result = 31 * result + (servicoId != null ? servicoId.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (chamada != null ? chamada.hashCode() : 0);
        result = 31 * result + (usuarioId != null ? usuarioId.hashCode() : 0);
        result = 31 * result + (avaliacao != null ? avaliacao.hashCode() : 0);
        result = 31 * result + (nota != null ? nota.hashCode() : 0);
        result = 31 * result + (guicheId != null ? guicheId.hashCode() : 0);
        result = 31 * result + (repassada != null ? repassada.hashCode() : 0);
        result = 31 * result + (rechamada != null ? rechamada.hashCode() : 0);
        return result;
    }
}
