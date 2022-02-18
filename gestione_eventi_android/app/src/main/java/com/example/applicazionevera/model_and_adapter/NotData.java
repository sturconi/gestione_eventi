package com.example.applicazionevera.model_and_adapter;

public class NotData {

    int image;
    String notifica;

    public NotData(int image, String notifica) {
        this.image = image;
        this.notifica = notifica;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNotifica() {
        return notifica;
    }

    public void setNotifica(String notifica) {
        this.notifica = notifica;
    }
}
