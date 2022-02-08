package ese.example.Ese;

import java.util.List;

public interface utenteInterface {

	boolean save(Utente ut);
	
	Utente findById(int id);
	
	List<Utente> findAll();
	
	boolean deleteById(int id);
	
	boolean deleteAll();
	
	boolean update(Utente ut);
	
}
