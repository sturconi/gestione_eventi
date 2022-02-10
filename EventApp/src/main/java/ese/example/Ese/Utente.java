package ese.example.Ese;

import java.sql.Date;




public class Utente {
	int id;
	String username;
	String password;
	String nome;
	String email;
	Date datanascita;
	String cognome;
	String fotoprofilo;
	
	public Utente() {
	}
	
	public Utente(int id, String username, String password, String nome, String email, Date datanascita, String cognome, String fotoprofilo) {
		this.id= id;
		this.username= username;
		this.password= password;
		this.cognome=cognome;
		this.datanascita=datanascita;
		this.email=email;
		this.fotoprofilo=fotoprofilo;
		this.nome=nome;
	}
	public int getId() {
		return this.id;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public String getCognome() {
		return this.cognome;
	}
	public Date getDatanascita() {
		return this.datanascita;
	}
	public String getEmail() {
		return this.email;
	}
	public String getFotoprofilo() {
		return this.fotoprofilo;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	public void setDatanascita(Date datanascita) {
		this.datanascita=datanascita;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setFotoprofilo(String fotoprofilo) {
		this.fotoprofilo=fotoprofilo;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	
	
}
