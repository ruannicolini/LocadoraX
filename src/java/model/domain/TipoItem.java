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
public class TipoItem {
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private long idTipoItem;
    @Column(nullable = false)
    private String nome;

    public TipoItem() {
    }

    public TipoItem(long idTipoItem, String nome) {
        this.idTipoItem = idTipoItem;
        this.nome = nome;
    }
    
    public TipoItem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdTipoItem() {
        return idTipoItem;
    }
    
    
}
