package com.example.applicazionevera.retrofit;

public class Utente {
        public String username;
        public String cognome;
        public String nome;
        public String email;
        public String password;
        public int eta;
        public int id_utente;


        public Utente(int id_utente,String username, String cognome, String nome, String email, String password) {
            this.username = username;
            this.cognome = cognome;
            this.nome= nome;
            this.email= email;
            this.password=password;
            this.id_utente=id_utente;
        }

    public String getUsername() {
        return username;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getEta() {
        return eta;
    }

    public int getID_utente() {
        return id_utente;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setID_utente(int id_utente) {
        this.id_utente = id_utente;
    }
}
