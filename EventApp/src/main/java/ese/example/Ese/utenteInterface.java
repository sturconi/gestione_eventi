package ese.example.Ese;

import java.util.List;

public interface utenteInterface {

	int save(Utente u);
	
	Utente findById(int id);
	
	List<Utente> findAll();
	
	int deleteById(int id);
	
	int deleteAll();
	
	int update(Utente u);

	Utente findByUser(String username);
	
}
