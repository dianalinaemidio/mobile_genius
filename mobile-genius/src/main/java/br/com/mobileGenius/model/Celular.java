
package br.com.mobileGenius.model;

public class Celular {

    private String marca;
    private String id;
    private double preco;
    private int quantidade;
    private String descricao;

    private String modelo;

    // Construtores
    public Celular() {
    }


    public Celular(String marca, String id, double preco, int quantidade, String descricao, String modelo) {
        this.marca = marca;
        this.id = id;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.modelo = modelo;
    }

    // Metodos
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
