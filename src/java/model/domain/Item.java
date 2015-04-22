/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
    @OneToOne(fetch = FetchType.EAGER)
    private TipoItem tipo;
    @OneToOne(fetch = FetchType.EAGER)
    private Titulo titulo;

    public Item() {
    }
    
    public Item(int numSerie, String dtArquisicao, TipoItem tipo, Titulo titulo) {
        this.numSerie = numSerie;
        this.dtArquisicao = dtArquisicao;
        this.tipo = tipo;
        this.titulo = titulo;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
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
