package br.com.mobileGenius.model;


import java.util.ArrayList;

public class Carrinho {

    private String id;
    private String idCliente;
    private double total;
    private ArrayList<Celular> celulares = new ArrayList<>();

    public Carrinho(String id, String idCliente) {
        this.id = id;
        this.idCliente = idCliente;
        this.total = 0;
    }

    public Carrinho(String idCliente) {
        this.total = 0;
        this.idCliente = idCliente;
    }

    public void adicionarCelular(Celular celular) {
        this.celulares.add(celular);
        this.total += celular.getPreco();
    }

    public void removerCelular(Celular celular) {
        this.celulares.remove(celular);
        this.total -= celular.getPreco();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Celular> getCelulares() {
        return celulares;
    }

    public void setCelulares(ArrayList<Celular> celulares) {
        this.celulares = celulares;
    }

    public void limparCarrinho() {

        this.total = 0.0;
        this.celulares = new ArrayList<>();
    }


}
