package com.example.applicazionevera.model_and_adapter;

public class EvCatData {

    int Image;
    String titolo, indirizzo, data;

    public EvCatData(int Image, String titolo, String indirizzo,  String data) {
        this.Image = Image;
        this.titolo = titolo;
        this.indirizzo = indirizzo;
        this.data = data;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
