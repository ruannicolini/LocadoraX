/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Column
    private String dtDevolucaoEfetiva;
    @Column
    private float valorCobrado;
    @Column
    private float multaCobrada;
    @Column
    private boolean statusPagamento;

    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Item item;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
    
    
    public Locacao() {
    }

    public Locacao(String dtLocacao, String dtDevolucaoPrevista, String dtDevolucaoEfetiva, float valorCobrado, float multaCobrada, Cliente cliente, Item item, Boolean statusPagamento) {
        this.dtLocacao = dtLocacao;
        this.dtDevolucaoPrevista = dtDevolucaoPrevista;
        this.dtDevolucaoEfetiva = dtDevolucaoEfetiva;
        this.valorCobrado = valorCobrado;
        this.multaCobrada = multaCobrada;
        this.cliente = cliente;
        this.item = item;
        this.statusPagamento = statusPagamento;
    }

    public Locacao(String dtLocacao, String dtDevolucaoPrevista, float valorCobrado, Cliente cliente, Item item, Boolean statusPagamento) {
        this.dtLocacao = dtLocacao;
        this.dtDevolucaoPrevista = dtDevolucaoPrevista;
        this.valorCobrado = valorCobrado;
        this.cliente = cliente;
        this.item = item;
        this.statusPagamento = statusPagamento;
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

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public boolean isStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
    
    
    public Date somaDias(Date data, int dias) {  
        Calendar cal = new GregorianCalendar();  

        cal.setTime(data);  

        cal.add(Calendar.DAY_OF_MONTH, dias);  

        return cal.getTime();  
}
    
}
