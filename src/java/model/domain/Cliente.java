/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Ruan
 */

@Entity
public class Cliente{
    @Column(nullable = false)
    private String nome;
    @Column
    private String dataNascimento;
    @Id
    @GeneratedValue
    private long numInscricao = 0;
    @Column
    private Boolean ativo;
    @Column
    private char sexo;
    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //private Set<Locacao> locacoes;

    
    public Cliente(String nome, String dataNascimento, Boolean ativo, char sexo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
        this.sexo = sexo;
    }

    public Cliente() {
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

    public long getNumInscricao() {
        return numInscricao;
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
    
    public boolean equals(Object o){
        
        Cliente c = (Cliente)o;
        
        if ((this.getNumInscricao() == 0) || (c.getNumInscricao() == 0))
            return (this == c);
        else
            return (this.getNumInscricao() == c.getNumInscricao());
        
    }
}
