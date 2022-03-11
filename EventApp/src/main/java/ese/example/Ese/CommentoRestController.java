package ese.example.Ese;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CommentoRestController {
	
	@Autowired
	@Qualifier("MYSQL")
	CommentoInterface commentoRepositery;
	
	@RequestMapping(value="/commenti/{ID_evento}", method=RequestMethod.GET)
	public List<Commento> findByIdC(@PathVariable int ID_evento) {
		return this.commentoRepositery.findByIdC(ID_evento);
		}
	
	@RequestMapping(value="/commenti/crea", method=RequestMethod.POST)
	public ResponseEntity<String> addCommento(@RequestBody Commento newCommento) {
		String res="";
		if(this.commentoRepositery.save(newCommento)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
}
	
	

