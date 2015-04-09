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

}
