package br.com.mobileGenius.model;

public class User {
    private String id;
    private String username;
    private String sobrenome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String email;
    private String numeroCelular;
    private String password;
    private boolean admin = false;
    private boolean loggedUser;

    public User() {
    }

    // Construtores
    public User(String id, String username, String sobrenome, String cpf, String dataNascimento, String endereco, String email, String numeroCelular, String password, boolean admin, boolean loggedUser) {

        // Verificações para garantir que os valores passados sejam válidos
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (sobrenome == null || sobrenome.isEmpty()) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (numeroCelular == null || numeroCelular.isEmpty()) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Campo vazio! Insira algo...");
        }

        this.id = id;
        this.username = username;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.password = password;
        this.admin = admin;
        this.loggedUser = loggedUser;
    }

    public User(String username, String password) {

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Nome de usuário e senha devem ser fornecidos.");
        }

        this.username = username;
        this.password = password;
    }


    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getSobrenome() {return sobrenome;}

    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getDataNascimento() {return dataNascimento;}

    public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento;}

    public String getEndereco() {return endereco;}

    public void setEndereco(String endereco) {this.endereco = endereco;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getNumeroCelular() {return numeroCelular;}

    public void setNumeroCelular(String numeroCelular) {this.numeroCelular = numeroCelular;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public boolean isAdmin() {return admin;}

    public void setAdmin(boolean admin) {this.admin = admin;}

    public boolean isLoggedUser() {return loggedUser;}

    public void setLoggedUser(boolean loggedUser) {this.loggedUser = loggedUser;}

    public void add(User user) {
    }
}