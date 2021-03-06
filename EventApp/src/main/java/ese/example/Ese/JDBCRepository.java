package ese.example.Ese;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


@Repository(value="MYSQL")
public class JDBCRepository implements utenteInterface, eventoInterface{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//----Utente------//
	@Override
	public int save(Utente u) {
		return jdbcTemplate.update("INSERT INTO utente(nome, cognome, username, email, password) VALUE(?,?,?,?,?)", new Object[] {u.getNome(), u.getCognome(), u.getUsername(), u.getEmail(), u.getPassword()});
	
	}
	
	@Override
	public int autore(EventoUtente eu) {
		return jdbcTemplate.update("INSERT INTO evento_utente (id_utente, numero_evento) VALUES (?,?)", new Object[] {eu.getId_utente(), eu.getnumero_evento()});
	
	}
	
	@Override
	public Utente findById(int id_utente) {
		return jdbcTemplate.queryForObject("SELECT * FROM utente WHERE id_utente=?", BeanPropertyRowMapper.newInstance(Utente.class),id_utente);
	}
	
	@Override
	public List<Utente> findAllusername() {
		return jdbcTemplate.query("SELECT username FROM utente", BeanPropertyRowMapper.newInstance(Utente.class));
	}
	
	@Override
	public List<Utente> findAll() {
		return jdbcTemplate.query("SELECT * FROM utente", BeanPropertyRowMapper.newInstance(Utente.class));
	}
	@Override
	public int updatePassword(Utente u) {
		return jdbcTemplate.update("UPDATE utente SET password=? WHERE username=?",new Object[] {u.getPassword(),u.getUsername()});
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
	public List<Evento> findByNumeroEvento() {
		return jdbcTemplate.query("SELECT e.numero_evento FROM evento e ORDER BY e.numero_evento DESC ", BeanPropertyRowMapper.newInstance(Evento.class));
	}
	
	@Override
	public Evento findByIdE(int numero_evento) {
		return jdbcTemplate.queryForObject("SELECT * FROM evento WHERE numero_evento=?", BeanPropertyRowMapper.newInstance(Evento.class),numero_evento);
	}
	
	
	@Override
	public Utente autoreevento(int numero_evento) {
		return jdbcTemplate.queryForObject("SELECT \r\n"
				+ "u.nome, u.cognome\r\n"
				+ "FROM \r\n"
				+ "utente u INNER JOIN evento_utente eu \r\n"
				+ "ON u.id_utente = eu.id_utente\r\n"
				+ "INNER JOIN evento e \r\n"
				+ "ON e.numero_evento= eu.numero_evento\r\n"
				+ "WHERE e.numero_evento = ?", BeanPropertyRowMapper.newInstance(Utente.class),numero_evento);
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
		return jdbcTemplate.update("INSERT INTO ticket(oggetto_ticket, testo_ticket) VALUE(?,?)", new Object[] {t.getOggetto_ticket(), t.getTesto_ticket()});
		
	}
	@Override
	public Ticket findByIdT(int codice) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * FROM ticket WHERE codice=?", BeanPropertyRowMapper.newInstance(Ticket.class),codice);
	}
	@Override
	public List<Ticket> findAllT() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM utente", BeanPropertyRowMapper.newInstance(Ticket.class));
	}
	@Override
	public int deleteByIdT(int codice) {
		// TODO Auto-generated method stub
		 return jdbcTemplate.update("DELETE FROM ticket WHERE codice=?",codice);
	}
	@Override
	public int deleteAllT() {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM ticket");
	}
	@Override
	public int updateT(Ticket t) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE ticket SET oggetto_ticket=? AND SET testo_ticket=? WHERE codice=?",new Object[] {t.getOggetto_ticket(),t.getTesto_ticket()});
	}
	@Override
	public Ticket findByOggetto(String oggetto_ticket) {
		// TODO Auto-generated method stub
		 return jdbcTemplate.queryForObject("SELECT * FROM ticket WHERE oggetto_ticket=?", BeanPropertyRowMapper.newInstance(Ticket.class),oggetto_ticket);
	}

	
	*/
	//------------------------------------------------------------------
		//----Commento------//
	
	/*@Override
	public List<Commento> findByIdC(int ID_evento) {
		return jdbcTemplate.query("SELECT * FROM commento c INNER JOIN evento e ON ID_evento = numero_evento INNER JOIN utente u ON c.ID_utente = u.ID_utente WHERE numero_evento=?", BeanPropertyRowMapper.newInstance(Commento.class),ID_evento);
	}
	
	@Override
	public int save(Commento c) {
		return jdbcTemplate.update("INSERT INTO commento(testo_commento, ID_utente, ID_evento) VALUE(?,?,?)", new Object[] {c.getTesto_commento(), c.getID_utente(), c.getID_evento()});
	
	}*/
	//------------------------------------------------------------------
	//----Luogo------//

	/*@Override
	public List<Luogo> findAllL() {
		return jdbcTemplate.query("SELECT * FROM luogo", BeanPropertyRowMapper.newInstance(Luogo.class));}
	
	
	*/
	

}
