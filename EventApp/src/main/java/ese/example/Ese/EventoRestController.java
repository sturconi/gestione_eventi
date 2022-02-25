package ese.example.Ese;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	@Qualifier("MYSQL")
	eventoInterface eventoRepositery;
	
	@RequestMapping(value="/eventi",method=RequestMethod.GET)
	public List<Evento> getEvento(){
		return this.eventoRepositery.findAllE();
	}
	

	@RequestMapping(value="/eventi/{categoria}", method=RequestMethod.GET)
	public List<Evento> getEventbyCat(@PathVariable String categoria) {
		return this.eventoRepositery.findByIdCat(categoria);
		
	}
	
	@RequestMapping(value="/eventi", method=RequestMethod.DELETE)
	public void deleteAllEventi() {
		this.eventoRepositery.deleteAllE();
	 }
	
	
	@RequestMapping(value="/eventi", method=RequestMethod.POST)
	public ResponseEntity<String> addEvento(@RequestBody Evento newEvento) {
		String res="";
		if(this.eventoRepositery.saveE(newEvento)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	

	@RequestMapping(value="/evento/{numero_evento}", method=RequestMethod.DELETE)
	public void deleteEventoByid(@PathVariable int numero_evento) {
		this.eventoRepositery.deleteByIdE(numero_evento);
	}
	
	
	/*@RequestMapping(value="/eventi/{numero_evento}", method=RequestMethod.PUT)
	public Evento updateEvento(@PathVariable int numero_evento,@RequestBody Evento newEvento) {
	Evento ev=this.eventoRepositery.findByIdE(numero_evento);
	if((!newEvento.getNome_evento().isBlank())&& newEvento.getNome_evento() !=null) {
		ev.setNome_evento(newEvento.getNome_evento());
	}
	this.eventoRepositery.updateE(ev);
	return ev;
	}
	*/
	
}
