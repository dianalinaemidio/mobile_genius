
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

        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (modelo == null || modelo.isEmpty()) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }

        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.image = image;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getMarca() {return marca;}

    public void setMarca(String marca) {this.marca = marca;}

    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}

    public double getPreco() {return preco;}

    public void setPreco(double preco) {this.preco = preco;}

    public int getQuantidade() {return quantidade;}

    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}
}