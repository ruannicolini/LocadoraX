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
public class Socio extends Cliente{
    private String endereco;
    private String telefone;
    @Column(nullable = false)
    private String cpf;

    public Socio(String endereco, String telefone, String cpf, String nome, String dataNascimento, String numInscricao, Boolean ativo, char sexo) {
        super(nome, dataNascimento, numInscricao, ativo, sexo);
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    
    
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
