package ese.example.Ese;

public class Luogo {
	String latitudine;
	String longitudine;
	String nomeevento;
	
	public Luogo() {
		
	}
	
	public Luogo(String latitudine, String longitudine, String nomeevento) {
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.nomeevento = nomeevento;
	}

	public String getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}

	public String getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}

	public String getNomeevento() {
		return nomeevento;
	}

	public void setNomeevento(String nomeevento) {
		this.nomeevento = nomeevento;
	}
	
	
	
}
