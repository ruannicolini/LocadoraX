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
public class Locacao {
    @Id
    @GeneratedValue
    private long idLocacao;
    @Column(nullable = false)
    private String dtLocacao;
    @Column(nullable = false)
    private String dtDevolucaoPrevista;
    private String dtDevolucaoEfetiva;
    private float valorCobrado;
    private float multaCobrada;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Item item;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Pagamento> pagamentos = new HashSet<Pagamento>();
    
    public Locacao() {
    }

    public Locacao(String dtLocacao, String dtDevolucaoPrevista, String dtDevolucaoEfetiva, float valorCobrado, float multaCobrada, Cliente cliente, Item item) {
        this.dtLocacao = dtLocacao;
        this.dtDevolucaoPrevista = dtDevolucaoPrevista;
        this.dtDevolucaoEfetiva = dtDevolucaoEfetiva;
        this.valorCobrado = valorCobrado;
        this.multaCobrada = multaCobrada;
        this.cliente = cliente;
        this.item = item;
    }

    public Locacao(String dtLocacao, String dtDevolucaoPrevista, float valorCobrado, Cliente cliente, Item item) {
        this.dtLocacao = dtLocacao;
        this.dtDevolucaoPrevista = dtDevolucaoPrevista;
        this.valorCobrado = valorCobrado;
        this.cliente = cliente;
        this.item = item;
    }
    
    public long getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(long idLocacao) {
        this.idLocacao = idLocacao;
    }

    public String getDtLocacao() {
        return dtLocacao;
    }

    public void setDtLocacao(String dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    public String getDtDevolucaoPrevista() {
        return dtDevolucaoPrevista;
    }

    public void setDtDevolucaoPrevista(String dtDevolucaoPrevista) {
        this.dtDevolucaoPrevista = dtDevolucaoPrevista;
    }

    public String getDtDevolucaoEfetiva() {
        return dtDevolucaoEfetiva;
    }

    public void setDtDevolucaoEfetiva(String dtDevolucaoEfetiva) {
        this.dtDevolucaoEfetiva = dtDevolucaoEfetiva;
    }

    public float getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(float valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public float getMultaCobrada() {
        return multaCobrada;
    }

    public void setMultaCobrada(float multaCobrada) {
        this.multaCobrada = multaCobrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Set<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Set<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
    
    
}
