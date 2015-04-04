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
public class Distribuidor {
    @Column(nullable = false)
    private String razaoSocial;
    @Id
    @Column(nullable = false)
    private int cnpj;

    public Distribuidor() {
    }

    public Distribuidor(String razaoSocial, int cnpj) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
