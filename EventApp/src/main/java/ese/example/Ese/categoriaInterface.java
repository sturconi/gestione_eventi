package ese.example.Ese;

import java.util.List;

public interface categoriaInterface {
boolean save(Categoria ca);
	
	Categoria findById1(String categoria);
	
	List<Categoria> findAll();
	
	boolean deleteById(int id);
	
	boolean deleteAll();
	
	boolean update(Categoria ca);

	Categoria findById(String categoria);
}
