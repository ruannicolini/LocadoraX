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
import javax.persistence.ManyToOne;

/**
 *
 * @author Ruan
 */
@Entity
public class Reserva {
    @Id
    @GeneratedValue
    private long idReserva;
    
    @Column(nullable = false)
    private String dtReserva;
    @Column(nullable = false)
    private String hrReserva;
    
    private String dtComunicado;
    private String hrComunicado;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Titulo titulo;
    
    @ManyToOne
    private TipoItem tipoItem;

    public Reserva() {
    }

    public Reserva(String dtReserva, String hrReserva, Cliente cliente, Titulo titulo, TipoItem tipoItem) {
        this.dtReserva = dtReserva;
        this.hrReserva = hrReserva;
        this.cliente = cliente;
        this.titulo = titulo;
        this.tipoItem = tipoItem;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public String getDtReserva() {
        return dtReserva;
    }

    public void setDtReserva(String dtReserva) {
        this.dtReserva = dtReserva;
    }

    public String getHrReserva() {
        return hrReserva;
    }

    public void setHrReserva(String hrReserva) {
        this.hrReserva = hrReserva;
    }

    public String getDtComunicado() {
        return dtComunicado;
    }

    public void setDtComunicado(String dtComunicado) {
        this.dtComunicado = dtComunicado;
    }

    public String getHrComunicado() {
        return hrComunicado;
    }

    public void setHrComunicado(String hrComunicado) {
        this.hrComunicado = hrComunicado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }
    
    
}
