package ese.example.Ese;

public class Utente {
	int id;
	String username;
	String password;
	
	public Utente(int id, String username, String password) {
		this.id= id;
		this.username= username;
		this.password= password;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		
		return username;
	}
	public String getPassword() {
		return password;
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
	
}
