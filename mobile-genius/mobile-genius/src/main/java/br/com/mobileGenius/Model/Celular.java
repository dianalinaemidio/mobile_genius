
package br.com.mobileGenius.Model;

public class Celular {

    private String marca;
    private String id;

    // Construtores
    public Celular() {
    }


    public Celular(String marca, String id) {
        this.marca = marca;
        this.id = id;
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

    public void setId(String id) {
        this.id = id;
    }
}
