package ese.example.Ese;

import java.util.List;

public interface ticketInterface {
	
    int saveT(Ticket t);
	
	Ticket findByIdT(int codice);
	
	List<Ticket> findAllT();
	
	int deleteByIdT(int codice);
	
	int deleteAllT();
	
	int updateT(Ticket t);

	Ticket findByOggetto(String oggetto_ticket);
	
}

