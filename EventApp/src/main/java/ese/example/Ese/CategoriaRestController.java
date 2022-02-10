package ese.example.Ese;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaRestController {
	
	@Autowired
	categoriaInterface categoriaRepositery;
	
	@RequestMapping(value="/categorie",method=RequestMethod.GET)
	public List<Categoria> getEvento(){
		return this.categoriaRepositery.findAll();
		
		
	}
	
	@RequestMapping(value="/categorie/{categoria}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> getCategoriaByid(@PathVariable String categoria) {
		Categoria c =this.categoriaRepositery.findById(categoria);
		if(c!=null) {
		return new ResponseEntity(c,HttpStatus.OK);
		}
		else {
			return new ResponseEntity(c,HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/categorie/{categoria}", method=RequestMethod.DELETE)
	public void deleteAllEventi() {
		this.categoriaRepositery.deleteAll();
	 }
	
	
	@RequestMapping(value="/categoria", method=RequestMethod.POST)
	public ResponseEntity<String> addCategoria(@RequestBody Categoria newCategoria) {
		String res="";
		if(this.categoriaRepositery.save(newCategoria)) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	

	@RequestMapping(value="/categoria/{categoria}", method=RequestMethod.DELETE)
	public void deleteCategoriaByid(@PathVariable String categoria) {
		this.categoriaRepositery.deleteById(categoria);
	}
	
	
	@RequestMapping(value="/categoria/{categoria}", method=RequestMethod.PUT)
	public Categoria updateEvento(@PathVariable String categoria,@RequestBody Categoria newCategoria) {
		Categoria c=this.categoriaRepositery.findById(categoria);
	if((!newCategoria.getImmagine().isBlank())&& newCategoria.getImmagine() !=null) {
		c.setImmagine(newCategoria.getImmagine());
	}
	
	this.categoriaRepositery.update(c);
	return c;
	}
}
