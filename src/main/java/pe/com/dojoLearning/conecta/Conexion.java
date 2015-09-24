package pe.com.dojoLearning.conecta;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class Conexion {
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}	
	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
