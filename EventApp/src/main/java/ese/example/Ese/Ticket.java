package ese.example.Ese;

import java.sql.Date;

public class Ticket {

	int codice;
	String oggetto_ticket;
	String testo_ticket;
	int ID_utente;
	
	public Ticket() {
	}
	

	public Ticket(int codice, String oggetto_ticket, String testo_ticket, int iD_utente) {
		super();
		this.codice = codice;
		this.oggetto_ticket = oggetto_ticket;
		this.testo_ticket = testo_ticket;
		ID_utente = iD_utente;
	}


	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getOggetto_ticket() {
		return oggetto_ticket;
	}

	public void setOggetto_ticket(String oggetto_ticket) {
		this.oggetto_ticket = oggetto_ticket;
	}

	public String getTesto_ticket() {
		return testo_ticket;
	}

	public void setTesto_ticket(String testo_ticket) {
		this.testo_ticket = testo_ticket;
	}

	public int getID_utente() {
		return ID_utente;
	}

	public void setID_utente(int iD_utente) {
		ID_utente = iD_utente;
	}
	
	
}