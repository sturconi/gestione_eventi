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
public class EventoRestController {
	
	@Autowired
	eventoInterface eventoRepositery;
	
	@RequestMapping(value="/eventi",method=RequestMethod.GET)
	public List<Evento> getEvento(){
		return this.eventoRepositery.findAll();
		
		
	}
	
	@RequestMapping(value="/eventi/{id}", method=RequestMethod.GET)
	public ResponseEntity<Evento> getEventoByid(@PathVariable int id) {
		Evento e =this.eventoRepositery.findById(id);
		if(e!=null) {
		return new ResponseEntity(e,HttpStatus.OK);
		}
		else {
			return new ResponseEntity(e,HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/utenti/{id}", method=RequestMethod.DELETE)
	public void deleteAllEventi() {
		this.eventoRepositery.deleteAll();
	 }
	
	
	@RequestMapping(value="/evento", method=RequestMethod.POST)
	public ResponseEntity<String> addEvento(@RequestBody Evento newEvento) {
		String res="";
		if(this.eventoRepositery.save(newEvento)) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	

	@RequestMapping(value="/evento/{id}", method=RequestMethod.DELETE)
	public void deleteEventoByid(@PathVariable int id) {
		this.eventoRepositery.deleteById(id);
	}
	
	
	@RequestMapping(value="/evento/{id}", method=RequestMethod.PUT)
	public Evento updateUtente(@PathVariable int id,@RequestBody Evento newEvento) {
	Evento e=this.eventoRepositery.findById(id);
	if((!newEvento.getNome_evento().isBlank())&& newEvento.getNome_evento() !=null) {
		e.setNome_evento(newEvento.getNome_evento());
	}
	
	this.eventoRepositery.update(e);
	return e;
	}
}