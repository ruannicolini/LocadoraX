/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Ruan
 */
@Entity
public class Item {
    @Id
    @Column(nullable = false)
    private int numSerie;
    private String dtArquisicao;
    private TipoItem tipo;

    public Item(int numSerie, String dtArquisicao) {
        this.numSerie = numSerie;
        this.dtArquisicao = dtArquisicao;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public String getDtArquisicao() {
        return dtArquisicao;
    }

    public void setDtArquisicao(String dtArquisicao) {
        this.dtArquisicao = dtArquisicao;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }
    
    
    
}
