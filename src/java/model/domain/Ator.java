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
public class Ator {
    @Column(nullable = false)
    private String nome;
    @Id
    @GeneratedValue
    private long idAtor;

    public Ator() {
    }

    public Ator(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(long idAtor) {
        this.idAtor = idAtor;
    }
    
    
}
