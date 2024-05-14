package br.com.mobileGenius.model;

import java.sql.Date;

public class Usuario {
    private String ID;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String senha;
    private Date dataNascimento;
    private String endereco;
    private String email;
    private String numeroCelular;
    private boolean administrador;
    private boolean loggedUser;

    public Usuario(String ID, String nome, String sobrenome, String cpf, String senha, Date dataNascimento, String endereco, String email, String numeroCelular, boolean loggerUser) {
        this.ID = ID;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.administrador = false;
        this.loggedUser = loggerUser;
    }

    public Usuario(String ID, String nome, String sobrenome, String cpf, String senha, Date dataNascimento, String endereco, String email, String numeroCelular,boolean loggerUser, boolean administrador) {
        this.ID = ID;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.administrador = administrador;
        this.loggedUser = loggerUser;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(boolean loggedUser) {
        this.loggedUser = loggedUser;
    }
}
