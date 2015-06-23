/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Ruan
 */

@Entity
public class Socio extends Cliente{
    @Column
    private String endereco;
    @Column
    private String telefone;
    @Column(nullable = false, columnDefinition = "varchar(255) default '0'")
    private String cpf;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Dependente> dependentes = new ArrayList<Dependente>();

    public Socio(String endereco, String telefone, String cpf, String nome, String dataNascimento, Boolean ativo, char sexo) {
        super(nome, dataNascimento, ativo, sexo);
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Socio() {
        super();
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

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }
    
    public void inserirDependente(Dependente dep){
		dependentes.add(dep);
    }
    
    public void removerDependente(Dependente dep){
		dependentes.remove(dep);
    }
}
