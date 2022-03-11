package ese.example.Ese;

import java.util.List;

public interface CommentoInterface {
	
	List<Commento> findByIdC(int ID_evento);
	int save(Commento c);
}
