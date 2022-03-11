package ese.example.Ese;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


@Repository(value="MYSQL")
public class JDBCRepository implements utenteInterface, eventoInterface, CommentoInterface {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//----Utente------//
	@Override
	public int save(Utente u) {
		return jdbcTemplate.update("INSERT INTO utente(nome, cognome, username, email, password) VALUE(?,?,?,?,?)", new Object[] {u.getNome(), u.getCognome(), u.getUsername(), u.getEmail(), u.getPassword()});
	
	}
	@Override
	public Utente findById(int ID_utente) {
		return jdbcTemplate.queryForObject("SELECT * FROM utente WHERE ID_utente=?", BeanPropertyRowMapper.newInstance(Utente.class),ID_utente);
	}
	@Override
	public List<Utente> findAll() {
		return jdbcTemplate.query("SELECT * FROM utente", BeanPropertyRowMapper.newInstance(Utente.class));
	}
	@Override
	public int update(Utente u) {
		return jdbcTemplate.update("UPDATE utente SET nome=? WHERE id=?",new Object[] {u.getNome(),u.getId()});
	}
	@Override
	public int updatePassword(Utente u) {
		return jdbcTemplate.update("UPDATE utente SET password=? WHERE ID_utente=?",new Object[] {u.getPassword(),u.getId()});
	}
	@Override
	public int deleteById(int id) {

	    return jdbcTemplate.update("DELETE FROM utente WHERE id=?",id);
	}
	@Override
	public int deleteAll() {
	    return jdbcTemplate.update("DELETE FROM utente");
	}
	@Override
	public Utente findByUsername(String username) {
		 return jdbcTemplate.queryForObject("SELECT * FROM utente WHERE username=?", BeanPropertyRowMapper.newInstance(Utente.class),username);
	}
//------------------------------------------------------------------
	//----Evento------//
	@Override
	public int saveE(Evento ev) {
		return jdbcTemplate.update("INSERT INTO evento(categoria, nome_evento, luogo, data, ora, descrizione) VALUE(?,?,?,?,?,?)", new Object[] {ev.getCategoria(), ev.getNome_evento(), ev.getLuogo(),ev.getData(), ev.getOra(),ev.getDescrizione()});
	
	}
	
	@Override
	public List<Evento> findByIdCat(String categoria) {
		return jdbcTemplate.query("SELECT * FROM evento WHERE categoria=?", BeanPropertyRowMapper.newInstance(Evento.class),categoria);
	}


	@Override
	public Evento findByIdE(int numero_evento) {
		return jdbcTemplate.queryForObject("SELECT * FROM evento WHERE numero_evento=?", BeanPropertyRowMapper.newInstance(Evento.class),numero_evento);
	}
	
	@Override
	public List<Evento> findAllE() {
		return jdbcTemplate.query("SELECT * FROM evento", BeanPropertyRowMapper.newInstance(Evento.class));
	}
	@Override
	public int deleteByIdE(int numero_evento) {

	    return jdbcTemplate.update("DELETE FROM evento WHERE numero_evento=?",numero_evento);
	}
	@Override
	public int deleteAllE() {
		return jdbcTemplate.update("DELETE FROM evento");
	}
	@Override
	public int updateE(Evento ev) {
		return jdbcTemplate.update("UPDATE evento SET Categoria=? AND SET nome-evento=? AND SET luogo WHERE numero_evento=?",new Object[] {ev.getCategoria(),ev.getNome_evento(), ev.getLuogo()});
	}
	
//------------------------------------------------------------------
	//----Ticket------//
	
	/*@Override
	public int saveT(Ticket t) {
		return jdbcTemplate.update("INSERT INTO ticket(oggetto, testo) VALUE(?,?)", new Object[] {t.getOggetto(), t.getTesto()});
		
	}
	@Override
	public Ticket findByIdT(int ID_ticket) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * FROM ticket WHERE ID_ticket=?", BeanPropertyRowMapper.newInstance(Ticket.class),ID_ticket);
	}
	@Override
	public List<Ticket> findAllT() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM utente", BeanPropertyRowMapper.newInstance(Ticket.class));
	}
	@Override
	public int deleteByIdT(int ID_ticket) {
		// TODO Auto-generated method stub
		 return jdbcTemplate.update("DELETE FROM ticket WHERE ID_ticket=?",ID_ticket);
	}
	@Override
	public int deleteAllT() {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM ticket");
	}
	@Override
	public int updateT(Ticket t) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE ticket SET Oggetto=? AND SET Testo=? WHERE ID_ticket=?",new Object[] {t.getOggetto(),t.getTesto()});
	}
	@Override
	public Ticket findByOggetto(String oggetto) {
		// TODO Auto-generated method stub
		 return jdbcTemplate.queryForObject("SELECT * FROM ticket WHERE oggetto=?", BeanPropertyRowMapper.newInstance(Ticket.class),oggetto);
	}
*/
	
	
	//------------------------------------------------------------------
		//----Commento------//
	
	@Override
	public List<Commento> findByIdC(int ID_evento) {
		return jdbcTemplate.query("SELECT * FROM commento c INNER JOIN evento e ON ID_evento = numero_evento INNER JOIN utente u ON c.ID_utente = u.ID_utente WHERE numero_evento=?", BeanPropertyRowMapper.newInstance(Commento.class),ID_evento);
	}
	
	@Override
	public int save(Commento c) {
		return jdbcTemplate.update("INSERT INTO commento(testo_commento, ID_utente, ID_evento) VALUE(?,?,?)", new Object[] {c.getTesto_commento(), c.getID_utente(), c.getID_evento()});
	
	}
	
	

}
