package ese.example.Ese;

public class Categoria {
	String categoria;
	String immagine;

	public Categoria (String categoria, String immagine) {
		this.categoria=categoria;
		this.immagine=immagine;
	}
	public String getcategoria() {
		return this.categoria;
	}
	public String getImmagine() {
		return this.immagine;
	}
	public void setcategoria(String categoria) {
		this.categoria=categoria;
	}
	public void setImmagine(String immagine) {
		this.immagine=immagine;
	}
}
