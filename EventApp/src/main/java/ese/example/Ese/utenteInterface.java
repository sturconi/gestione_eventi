package ese.example.Ese;

import java.util.List;

public interface utenteInterface {

	int save(Utente u);
	
	Utente findById(int ID_utente);
	
	List<Utente> findAll();
	
	int deleteById(int ID_utente);
	
	int deleteAll();
	
	int update(Utente u);

	Utente findByUsername(String username);
	
	int updatePassword(Utente u);
	
	List<Utente> findAllusername();
}
