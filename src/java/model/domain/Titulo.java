/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ruan
 */
@Entity
public class Titulo {
    @Id
    @GeneratedValue
    private long idTitulo;
    @Column(nullable = false)
    private String nome;
    private String ano;
    private String sinopse;
    private String categoria;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Ator> atores = new HashSet<Ator>();
    @ManyToOne
    private Diretor diretor;
    @ManyToOne
    private Classe classe;

    public Titulo() {
    }

    public Titulo(String nome, String ano, String sinopse, String categoria, Diretor diretor, Classe classe) {
        this.nome = nome;
        this.ano = ano;
        this.sinopse = sinopse;
        this.categoria = categoria;
        this.diretor = diretor;
        this.classe = classe;
    }

    public long getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(long idTitulo) {
        this.idTitulo = idTitulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Set<Ator> getAtores() {
        return atores;
    }

    public void setAtores(Set<Ator> atores) {
        this.atores = atores;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    

}
