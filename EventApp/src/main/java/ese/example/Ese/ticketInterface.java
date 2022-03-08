package ese.example.Ese;

import java.util.List;

public interface ticketInterface {
    int saveT(Ticket t);
	
	Ticket findByIdT(int ID_ticket);
	
	List<Ticket> findAllT();
	
	int deleteByIdT(int ID_ticket);
	
	int deleteAllT();
	
	int updateT(Ticket t);

	Ticket findByOggetto(String oggetto);
	
}

