package br.com.mobileGenius.Model;

public class Celular {

    protected String nomeCelular;
    protected String id;

    public Celular(String nomeCelular , String id) {

        this.nomeCelular = nomeCelular;
        this.id = id;

    }


    public Celular(String nomeCelular) {

        this.nomeCelular = nomeCelular;
    }

    public String getNomeCelular() {


        return nomeCelular;
    }

    public String getId() {

        return this.id;

    }

}
