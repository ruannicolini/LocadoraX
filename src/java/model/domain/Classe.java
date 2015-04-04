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
public class Classe {
    @Column(nullable = false)
    private String nome;
    @Id
    @GeneratedValue
    private long idClasse;
    @Column(nullable = false)
    private float valor;
    @Column(nullable = false)
    private int prazo;

    public Classe() {
    }

    public Classe(String nome, long idClasse, float valor, int prazo) {
        this.nome = nome;
        this.idClasse = idClasse;
        this.valor = valor;
        this.prazo = prazo;
    }

    public Classe(String nome, float valor, int prazo) {
        this.nome = nome;
        this.valor = valor;
        this.prazo = prazo;
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(long idClasse) {
        this.idClasse = idClasse;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }
    
}
