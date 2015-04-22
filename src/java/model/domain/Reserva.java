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
}
