package ese.example.Ese;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


@Repository
public class JDBCRepository implements utenteInterface {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Utente u) {
		return jdbcTemplate.update("INSERT INTO utente(nome, cognome, username, email, password) VALUE(?,?,?,?,?)", new Object[] {u.getNome(), u.getCognome(), u.getUsername(), u.getEmail(), u.getPassword()});
	
	}

	@Override
	public Utente findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM utente WHERE id=?", BeanPropertyRowMapper.newInstance(Utente.class));
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
	public int deleteById(int id) {

	    return jdbcTemplate.update("DELETE FROM utente WHERE id=?",id);
	}

	@Override
	public int deleteAll() {
	    return jdbcTemplate.update("DELETE FROM utente");
	}

}
