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
public class TicketRestController {
	
	@Autowired()
	@Qualifier("MYSQL")
	ticketInterface ticketRepositery;
	
	
	
	@RequestMapping(value="/ticket",method=RequestMethod.GET)
	public List<Ticket> getTicket(){
		return this.ticketRepositery.findAllT();
	}
	
	@RequestMapping(value="/ticket/{oggetto}",method=RequestMethod.GET)
	public ResponseEntity<Ticket> getTicketByOggetto(@PathVariable String oggetto){
		Ticket t = ticketRepositery.findByOggetto(oggetto);
		if(t!=null) {
			return new ResponseEntity(t,HttpStatus.OK);
			}
			else {
				return new ResponseEntity(t,HttpStatus.NOT_FOUND);
			}
	}
	
	
	@RequestMapping(value="/ticket/{ID_ticket}", method=RequestMethod.GET)
	public ResponseEntity<Ticket> getTiketByid(@PathVariable int ID_ticket) {
		Ticket t =this.ticketRepositery.findByIdT(ID_ticket);
		if(t!=null) {
		return new ResponseEntity(t,HttpStatus.OK);
		}
		else {
			return new ResponseEntity(t,HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/ticket", method=RequestMethod.DELETE)
	public void deleteAllTicket() {
		this.ticketRepositery.deleteAllT();
	 }
	
	
	@RequestMapping(value="/ticket", method=RequestMethod.POST)
	public ResponseEntity<String> addTicket(@RequestBody Ticket newTicket) {
		String res="";
		if(this.ticketRepositery.saveT(newTicket)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	

	@RequestMapping(value="/ticket/{id}", method=RequestMethod.DELETE)
	public void deleteTicketByid(@PathVariable int id) {
		this.ticketRepositery.deleteByIdT(id);
	}
	
	
	
}

