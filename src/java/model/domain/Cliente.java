/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Ruan
 */

@Entity
public class Cliente {
    @Column(nullable = false)
    private String nome;
    private String dataNascimento;
    @Id
    @GeneratedValue
    private String numInscricao;
    private Boolean ativo;
    private char sexo;

    
    public Cliente(String nome, String dataNascimento, String numInscricao, Boolean ativo, char sexo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numInscricao = numInscricao;
        this.ativo = ativo;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumInscricao() {
        return numInscricao;
    }

    public void setNumInscricao(String numInscricao) {
        this.numInscricao = numInscricao;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    
}
