package br.com.mobileGenius.model;

import java.sql.Date;

public class Venda {

    private String id;
    private User cliente;
    private Date dataVenda;
    private double total;
    private Carrinho carrinho;

    public Venda(User cliente, Date dataVenda, Carrinho carrinho) {

        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.total = carrinho.getTotal();
        this.carrinho = carrinho;

    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setData(Date date) {
    }
}
