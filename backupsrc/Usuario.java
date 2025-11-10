package com.senai.infoa.llsolucoes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "contato")
    private String contato;

    @Column(name = "senha")
    private String senha;

    @Column(name = "data_nascimento")
    private LocalDate data_nascimento;

    

    public Usuario(){}
    public Usuario(String nome, String email, String contato, String senha, LocalDate data_nascimento){
        this.nome = nome;
        this.email = email;
        this.contato = contato;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }

    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    
    public void setContato(String contato){
        this.contato = contato;
    }
    public String getContato(){
        return contato;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return senha;
    }

    public void setDataNascimento(LocalDate date){
        this.data_nascimento = date;
    }
    public LocalDate getDataNascimento(){
        return data_nascimento;
    }

}
