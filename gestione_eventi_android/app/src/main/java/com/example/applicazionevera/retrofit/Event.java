package com.example.applicazionevera.retrofit;


import java.sql.Date;

public class Event {
        int numero_evento;
        String Categoria;
        String nome_evento;
        String Descrizione;
        int Valutazione;
        String luogo;
        String data;
        Date oraInizio;
        Date oraFine;
        String immagine;
        int ID_Posto;

        public Event(int numero_evento, String Enome, String Categoria, String Eluogo, String EdescrizioneEvento,String Edata_evento) {
            this.numero_evento=numero_evento;
            this.nome_evento= Enome;
            this.Categoria= Categoria;
            this.nome_evento= nome_evento;
            this.Descrizione=EdescrizioneEvento;
            this.Valutazione=Valutazione;
            this.luogo=Eluogo;
            this.data=Edata_evento;
        }
    public int getnumero_evento() {
            return this.numero_evento;
        }
        public String getCategoria() {
            return this.Categoria;
        }
        public String getNome_evento() {
            return this.nome_evento;
        }
        public String getDescrizione() {
            return this.Descrizione;
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
        public Date getOraInizio() {
            return this.oraInizio;
        }
        public Date getOraFine() {
            return this.oraFine;
        }
        public String getImmagine() {
            return this.immagine;
        }

        public void setCategoria(String Categoria) {
            this.Categoria= Categoria;
        }
        public void setnumero_Evento(int nnumero_evento) {
            this.numero_evento=numero_evento;
        }
        public void setNome_evento(String nome_evento) {
            this.nome_evento= nome_evento;
        }
        public void setDescrizione(String Descrizione) {
            this.Descrizione=Descrizione;
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
        public void setOraInizio(Date oraInizio) {
            this.oraInizio=oraInizio;
        }
        public void setOraFine(Date oraFine) {
            this.oraFine=oraFine;
        }
        public void setImmagine(String immagine) {
            this.immagine=immagine;
        }
        public void setID_Posto(int ID_Posto) {
            this.ID_Posto=ID_Posto;
        }

    }
