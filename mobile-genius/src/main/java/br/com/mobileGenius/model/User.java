package br.com.mobileGenius.model;

public class User {
    private String username;
    private String password;

    private boolean type = false;

    private boolean loggedUser;

    public User(String username, String password, boolean type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(boolean type, boolean loggedUser) {
        this.type = type;
        this.loggedUser = loggedUser;
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

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isLoggedUser() {
        return loggedUser;
    }
}
