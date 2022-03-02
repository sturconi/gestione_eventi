package com.example.applicazionevera.model_and_adapter;

public class CommentData {
    int Image;
    String commento, username, nome;

    public CommentData(String commento, String username, String nome, int Image) {
        this.Image = Image;
        this.commento = commento;
        this.username = username;
        this.nome = nome;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
