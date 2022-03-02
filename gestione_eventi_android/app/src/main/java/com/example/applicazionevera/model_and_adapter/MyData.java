package com.example.applicazionevera.model_and_adapter;

public class MyData {

    int PostImage;
    String giorno, mese, titolo, luogo;

    public MyData(int postImage, String giorno, String mese, String titolo, String luogo) {
        PostImage = postImage;
        this.giorno=giorno;
        this.mese=mese;
        this.titolo = titolo;
        this.luogo = luogo;
    }

    public int getPostImage() {
        return PostImage;
    }

    public void setPostImage(int postImage) {
        PostImage = postImage;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getMese() {
        return mese;
    }

    public void setMese(String mese) {
        this.mese = mese;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

}
