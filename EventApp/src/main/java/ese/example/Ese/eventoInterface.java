package ese.example.Ese;

import java.util.List;

public interface eventoInterface{

int saveE(Evento ev);
	
	Evento findByIdE(int numero_evento);
	
	Utente autoreevento(int numero_evento);
	
	List<Evento> findAllE();
	
	int deleteByIdE(int numero_evento);
	
	int deleteAllE();
	
	int updateE(Evento ev);

	List<Evento> findByIdCat(String categoria);
	
	List<Evento> findByNumeroEvento();

}
