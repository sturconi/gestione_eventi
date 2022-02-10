package ese.example.Ese;

import java.util.Date;

public class Evento {
	int id_evento;
	String Categoria;
	String nome_evento;
	String Descrizione;
	int Valutazione;
	String indirizzo;
	Date data;
	Date oraInizio;
	Date oraFine;
	String immagine;
	int ID_Posto;
	
	public Evento(int id_evento, String Categoria, String nome_evento, String Descrizione, int Valutazione, String indirizzo, Date data, Date oraInizio, Date oraFine, String immagine, int ID_Posto) {
		this.id_evento= id_evento;
		this.Categoria= Categoria;
		this.nome_evento= nome_evento;
		this.Descrizione=Descrizione;
		this.Valutazione=Valutazione;
		this.indirizzo=indirizzo;
		this.data=data;
		this.oraInizio=oraInizio;
		this.oraFine=oraFine;
		this.immagine=immagine;
		this.ID_Posto=ID_Posto;
	}
	public int getId_evento() {
		return this.id_evento;
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
	public String getindirizzo() {
		return this.indirizzo;
	}
	public Date getData() {
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
	public void setId_Evento(int id_evento) {
		this.id_evento=id_evento;
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
	public void setIndirizzo(String indirizzo) {
		this.indirizzo=indirizzo;
	}
	public void setData(Date data) {
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
