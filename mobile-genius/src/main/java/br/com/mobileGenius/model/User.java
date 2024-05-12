package br.com.mobileGenius.model;

public class User {
    private String id;
    private String username;
    private String password;
    private boolean type = false;
    private boolean loggedUser;

    // Construtores
    public User(String username, String password, boolean type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    /*
    TODO:
    Desenvolver a logica de verificao do usuario
    */
    public User(String username, String password, boolean type, boolean loggedUser) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.loggedUser = loggedUser;
    }

    public User(boolean type, boolean loggedUser) {
        this.type = type;
        this.loggedUser = loggedUser;
    }

    public User(String id, String username, String password, boolean type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    // Getters e Setteres
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isType() {
        return type;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isLoggedUser() {
        return loggedUser;
    }


}
