package br.com.mobileGenius.model;

import java.sql.Date;

public class Venda {

    private String id;
    private User cliente;
    private Date dataVenda;
    private double total;
    private String formaPagamento;
    private Carrinho carrinho;

    public Venda(String id, User cliente, Date dataVenda, String formaPagamento, Carrinho carrinho) {

        this.id = id;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.total = carrinho.getTotal();
        this.formaPagamento = formaPagamento;
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

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
