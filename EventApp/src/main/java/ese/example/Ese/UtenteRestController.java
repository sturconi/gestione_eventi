package ese.example.Ese;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UtenteRestController {
	
	@Autowired()
	@Qualifier("MYSQL")
	utenteInterface utenteRepositery;
	
	@GetMapping("/")
	public ModelAndView getRoot()
	{
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("loginregistrazione.html");
	    return modelAndView;
	}
	
	
	@RequestMapping(value="/utenti",method=RequestMethod.GET)
	public List<Utente> getUtente(){
		return this.utenteRepositery.findAll();
	}
	
	@RequestMapping(value="/utente/{username}",method=RequestMethod.GET)
	public ResponseEntity<Utente> getUtenteByUserAndPass(@PathVariable String username){
		Utente u = utenteRepositery.findByUsername(username);
		if(u!=null) {
			return new ResponseEntity(u,HttpStatus.OK);
			}
			else {
				return new ResponseEntity(u,HttpStatus.NOT_FOUND);
			}
	}
	
	
	@RequestMapping(value="/utenti/{ID_utente}", method=RequestMethod.GET)
	public ResponseEntity<Utente> getUtenteByid(@PathVariable int ID_utente) {
		Utente u =this.utenteRepositery.findById(ID_utente);
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

