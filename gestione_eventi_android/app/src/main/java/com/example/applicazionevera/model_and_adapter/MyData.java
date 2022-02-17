package com.example.applicazionevera.model_and_adapter;

public class MyData {

    int PostImage;
    String commento, vmedia, titolo, luogo, data;

    public MyData(int postImage, String commento, String vmedia, String titolo, String luogo, String data) {
        PostImage = postImage;
        this.commento = commento;
        this.vmedia = vmedia;
        this.titolo = titolo;
        this.luogo = luogo;
        this.data = data;
    }

    public int getPostImage() {
        return PostImage;
    }

    public void setPostImage(int postImage) {
        PostImage = postImage;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public String getVmedia() {
        return vmedia;
    }

    public void setVmedia(String vmedia) {
        this.vmedia = vmedia;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
