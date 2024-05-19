package br.com.mobileGenius.model;

import java.util.Date;

public class User {
    private String id;
    private String username;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Date dataNascimento;
    private String endereco;
    private String email;
    private String numeroCelular;
    private String password;
    private boolean admin = false;
    private boolean loggedUser;

    // Construtores
    public User(String username, String password, boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    /*
    TODO:
    Desenvolver a logica de verificao do usuario
    */

    public User(boolean admin, boolean loggedUser) {
        this.admin = admin;
        this.loggedUser = loggedUser;
    }

    public User(String username, String password, boolean admin, boolean loggedUser) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.loggedUser = loggedUser;
    }

    public User(String id, String username, String password, boolean admin, String nome, String sobrenome, String cpf, Date dataNascimento, String endereco, String email, String numeroCelular) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.numeroCelular = numeroCelular;
    }

    public User(String id, String username, String password, boolean admin, String nome, String sobrenome, String cpf, Date dataNascimento, String endereco, String email, String numeroCelular, boolean loggedUser) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.loggedUser = loggedUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isLoggedUser() {
        return loggedUser;
    }

}
