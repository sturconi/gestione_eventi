package ese.example.Ese;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

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
public class UtenteRestController {
	
	@Autowired
	utenteInterface utenteRepositery;
	
	@RequestMapping(value="/utenti",method=RequestMethod.GET)
	public List<Utente> getUtente(){
		return this.utenteRepositery.findAll();
	}
	
	@RequestMapping(value="/conferma/{username}",method=RequestMethod.GET)
	public Utente getUtenteByUser(@PathVariable String username)throws AccountNotFoundException{
		Utente u = utenteRepositery.findByUser(username);
		if (u == null) {
			throw new AccountNotFoundException("User not found");
		}
		return u;
	}
	
	@RequestMapping(value="/utenti/{id}", method=RequestMethod.GET)
	public ResponseEntity<Utente> getUtenteByid(@PathVariable int id) {
		Utente u =this.utenteRepositery.findById(id);
		if(u!=null) {
		return new ResponseEntity(u,HttpStatus.OK);
		}
		else {
			return new ResponseEntity(u,HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/utenti/{id}", method=RequestMethod.DELETE)
	public void deleteAllUtenti() {
		this.utenteRepositery.deleteAll();
	 }
	
	
	@RequestMapping(value="/utenti", method=RequestMethod.POST)
	public ResponseEntity<String> addUtente(@RequestBody Utente newUtente) {
		String res="";
		if(this.utenteRepositery.save(newUtente)>0) {
			return new ResponseEntity<String>("Ok", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("KO", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	

	@RequestMapping(value="/utente/{id}", method=RequestMethod.DELETE)
	public void deleteUtenteByid(@PathVariable int id) {
		this.utenteRepositery.deleteById(id);
	}
	
	
	@RequestMapping(value="/utenti/{id}", method=RequestMethod.PUT)
	public Utente updateUtente(@PathVariable int id,@RequestBody Utente newUtente) {
	Utente u=this.utenteRepositery.findById(id);
	if((!newUtente.getNome().isBlank())&& newUtente.getNome() !=null) {
		u.setNome(newUtente.getNome());
	}
	
	this.utenteRepositery.update(u);
	return u;
	}
}

