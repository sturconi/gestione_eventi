package com.example.applicazionevera.retrofit;

public class EventoUtente {
    int numero_evento;
    int id_utente;

    public EventoUtente(int id_utente, int numero_evento) {
        this.id_utente=id_utente;
        this.numero_evento=numero_evento;
    }

    public int getId_utente() {
        return this.id_utente;
    }
    public void setId_utente(int id_utente) {
        this.id_utente=id_utente;
    }

    public int getnumero_evento() {
        return this.numero_evento;
    }

    public void setnumero_Evento(int numero_evento) {
        this.numero_evento=numero_evento;
    }
}
