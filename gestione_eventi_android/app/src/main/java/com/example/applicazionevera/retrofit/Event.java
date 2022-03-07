package com.example.applicazionevera.retrofit;


import java.sql.Date;
import java.sql.Time;

public class Event {
        int numero_evento;
        String categoria;
        String nome_evento;
        String descrizione;
        int Valutazione;
        String luogo;
        String data;
        String ora;
        Date oraFine;
        int immagine;


            public Event(String categoria,String Enome,String Edata_evento,String ora, String EdescrizioneEvento) {
            this.nome_evento= Enome;
            this.categoria= categoria;
            this.descrizione=EdescrizioneEvento;
            this.data=Edata_evento;
            this.ora=ora;
        }




    public int getnumero_evento() {
            return this.numero_evento;
        }
        public String getCategoria() {
            return this.categoria;
        }
        public String getNome_evento() {
            return this.nome_evento;
        }
        public String getDescrizione() {
            return this.descrizione;
        }
        public int getValutazione() {
            return this.Valutazione;
        }
        public String getLuogo() {
            return this.luogo;
        }
        public String getData() {
            return this.data;
        }
        public String getOraInizio() {
            return this.ora;
        }
        public Date getOraFine() {
            return this.oraFine;
        }
        public int getImmagine() {
            return this.immagine;
        }

        public void setCategoria(String Categoria) {
            this.categoria= Categoria;
        }
        public void setnumero_Evento(int nnumero_evento) {
            this.numero_evento=numero_evento;
        }
        public void setNome_evento(String nome_evento) {
            this.nome_evento= nome_evento;
        }
        public void setDescrizione(String Descrizione) {
            this.descrizione=Descrizione;
        }
        public void setValutazione(int Valutazione) {
            this.Valutazione=Valutazione;
        }
        public void setLuogo(String luogo) {
            this.luogo=luogo;
        }
        public void setData(String data) {
            this.data=data;
        }
        public void setOraInizio(String ora) {
            this.ora=ora;
        }
        public void setOraFine(Date oraFine) {
            this.oraFine=oraFine;
        }
        public void setImmagine(int immagine) {
            this.immagine=immagine;
        }
    }
