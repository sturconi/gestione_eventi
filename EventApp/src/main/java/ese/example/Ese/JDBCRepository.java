package ese.example.Ese;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class JDBCRepository implements utenteInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean save(Utente ut) {
		
		try {
			jdbcTemplate.update("QUERY", 
					new Object[] {ut.getUsername(),ut.getPassword()});
		
		return true;
		}
		catch (Exception i) {
			System.out.println("Insert fallito");
			return false;
		}
	}

	@Override
	public Utente findById(int id) {
		try {
			return jdbcTemplate.queryForObject("QUERY", BeanPropertyRowMapper.newInstance(Utente.class), id);
		}
		catch(Exception i) {
			System.out.println("Select fallito");
			return null;
		}
	}

	@Override
	public List<Utente> findAll() {
		return jdbcTemplate.query("QUERY", BeanPropertyRowMapper.newInstance(Utente.class));
		
	}

	@Override
	public boolean deleteById(int id) {
		try {
			jdbcTemplate.update("QUERY", id);
			return true;
		}
		catch(Exception i) {
			System.out.println("Delete fallito");
			return false;
		}
	}

	@Override
	public boolean update(Utente ut) {
		try {
			jdbcTemplate.update("QUERY", 
					new Object[] {ut.getUsername(),ut.getPassword()});
		
		return true;
		}
		catch (Exception i) {
			System.out.println("Update fallito");
			return false;
		}
		
	}

	@Override
	public boolean deleteAll() {
		
		try {
			jdbcTemplate.update("QUERY");
			return true;
		}
		catch(Exception i) {
			System.out.println("Delete fallito");
			return false;
		}
	}

}
