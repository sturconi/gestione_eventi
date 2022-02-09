package ese.example.Ese;

import java.util.List;

public interface eventoInterface {

boolean save(Evento ev);
	
	Evento findById(int id);
	
	List<Evento> findAll();
	
	boolean deleteById(int id);
	
	boolean deleteAll();
	
	boolean update(Evento ev);
	
}
