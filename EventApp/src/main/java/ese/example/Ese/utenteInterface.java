package ese.example.Ese;

import java.util.List;

public interface utenteInterface {

	int save(Utente u);
	
	Utente findById(int id_utente);
	
	List<Utente> findAll();
	
	int deleteById(int id_utente);
	
	int deleteAll();
	
	int update(Utente u);

	Utente findByUsername(String username);
	
	int updatePassword(Utente u);
	
	List<Utente> findAllusername();
}
