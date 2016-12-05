package br.com.idtech.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by DOM on 02/12/2016.
 */
@Entity
public class Servicos {
    private int servicoId;
    private String descricao;
    private String sigla;
    private Integer inicio;
    private Integer fim;
    private Integer cor;

    @Id
    @Column(name = "servico_id")
    public int getServicoId() {
        return servicoId;
    }

    public void setServicoId(int servicoId) {
        this.servicoId = servicoId;
    }

    @Basic
    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Basic
    @Column(name = "sigla")
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Basic
    @Column(name = "inicio")
    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    @Basic
    @Column(name = "fim")
    public Integer getFim() {
        return fim;
    }

    public void setFim(Integer fim) {
        this.fim = fim;
    }

    @Basic
    @Column(name = "cor")
    public Integer getCor() {
        return cor;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servicos servicos = (Servicos) o;

        if (servicoId != servicos.servicoId) return false;
        if (descricao != null ? !descricao.equals(servicos.descricao) : servicos.descricao != null) return false;
        if (sigla != null ? !sigla.equals(servicos.sigla) : servicos.sigla != null) return false;
        if (inicio != null ? !inicio.equals(servicos.inicio) : servicos.inicio != null) return false;
        if (fim != null ? !fim.equals(servicos.fim) : servicos.fim != null) return false;
        if (cor != null ? !cor.equals(servicos.cor) : servicos.cor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = servicoId;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (sigla != null ? sigla.hashCode() : 0);
        result = 31 * result + (inicio != null ? inicio.hashCode() : 0);
        result = 31 * result + (fim != null ? fim.hashCode() : 0);
        result = 31 * result + (cor != null ? cor.hashCode() : 0);
        return result;
    }
}
