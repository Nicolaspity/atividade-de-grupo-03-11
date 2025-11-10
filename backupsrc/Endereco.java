package com.senai.infoa.llsolucoes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Integer endereco_id;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "localidade")
    private String localidade;

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "referencia")
    private String referencia;

    @OneToMany
    @JoinColumn(name = "usuario_id")
    private List<Usuario> usuario;

    public Endereco() {}

    public Endereco(Integer endereco_id, String logradouro, String localidade, String cep, Integer numero, String bairro, String complemento, String referencia, List<Usuario> usuario) {
        this.endereco_id = endereco_id;
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.referencia = referencia;
        this.usuario = usuario;
    }

    public Integer getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(Integer endereco_id) {
        this.endereco_id = endereco_id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setUsuario(List<Usuario> u){
        this.usuario = u;
    }
    public List<Usuario> getUsuario(){
        return usuario;
    }
}
