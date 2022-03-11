package ese.example.Ese;

public class Commento {
	int codice;
	String testo_commento;
	int ID_utente;
	int ID_evento;
	
	

public Commento() {
	
}

	public Commento(int codice, String testo_commento, int iD_utente, int iD_evento) {
		this.codice = codice;
		this.testo_commento = testo_commento;
		ID_utente = iD_utente;
		ID_evento = iD_evento;
	}
	
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getTesto_commento() {
		return testo_commento;
	}
	public void setTesto_commento(String testo_commento) {
		this.testo_commento = testo_commento;
	}
	public int getID_utente() {
		return ID_utente;
	}
	public void setID_utente(int iD_utente) {
		ID_utente = iD_utente;
	} 
	
	
	public int getID_evento() {
		return ID_evento;
	}


	public void setID_evento(int iD_evento) {
		ID_evento = iD_evento;
	}


	
	
}
