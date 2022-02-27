package ese.example.Ese;

import java.util.Date;

public class Evento {
	int numero_evento;
	String categoria;
	String nome_evento;
	String descrizione;
	String ora;
	int Valutazione;
	String luogo;
	String data;
	Date oraFine;
	String immagine;
	int ID_Posto;
	
	public Evento() {
	}
	
	public Evento(int numero_evento, String categoria, String nome_evento, String descrizione,String luogo, String data, String ora) {
		this.numero_evento= numero_evento;
		this.categoria= categoria;
		this.nome_evento= nome_evento;
		this.descrizione=descrizione;
		this.luogo=luogo;
		this.data=data;
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
	public String getOra() {
		return this.ora;
	}
	public Date getOraFine() {
		return this.oraFine;
	}
	public String getImmagine() {
		return this.immagine;
	}
	public int getId_posto() {
		return this.ID_Posto;
	}
	
	public void setCategoria(String categoria) {
		this.categoria= categoria;
	}
	public void setnumero_Evento(int nnumero_evento) {
		this.numero_evento=numero_evento;
	}
	public void setNome_evento(String nome_evento) {
		this.nome_evento= nome_evento;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione=descrizione;
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
	public void setOra(String ora) {
		this.ora=ora;
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
