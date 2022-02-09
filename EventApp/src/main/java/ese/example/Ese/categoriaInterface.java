package ese.example.Ese;

import java.util.List;

public interface categoriaInterface {
boolean save(Categoria ca);
	
	Categoria findById(int id);
	
	List<Categoria> findAll();
	
	boolean deleteById(int id);
	
	boolean deleteAll();
	
	boolean update(Categoria ca);
}
