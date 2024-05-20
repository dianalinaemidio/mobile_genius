package br.com.mobileGenius.model;

public class Celular {

    private String id;
    private String marca;
    private String modelo;
    private double preco;
    private int quantidade;
    private String descricao;
    private String image;

    // Construtores
    public Celular() {
    }

    public Celular(String id, String marca, String modelo, double preco, int quantidade, String descricao, String image) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.image = image;
    }

    public Celular(String id, String marca, String modelo, double preco, int quantidade, String descricao) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImage() {
        return image;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
