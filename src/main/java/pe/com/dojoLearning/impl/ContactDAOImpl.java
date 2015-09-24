package pe.com.dojoLearning.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.com.dojoLearning.beans.Contact;
import pe.com.dojoLearning.conecta.Conexion;
import pe.com.dojoLearning.dao.ContactDAO;

@Repository
public class ContactDAOImpl extends Conexion implements ContactDAO{
	 
	@Override
	public void saveOrUpdate(Contact contact) {
		if (contact.getId() > 0) {
	        // update
	        String sql = "UPDATE contact SET name=?, email=?, address=?, "
	                    + "telephone=? WHERE contact_id=?";
	        this.getJdbcTemplate().update(sql, contact.getName(), contact.getEmail(),
	                contact.getAddress(), contact.getTelephone(), contact.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO contact (name, email, address, telephone)"
	                    + " VALUES (?, ?, ?, ?)";
	        this.getJdbcTemplate().update(sql, contact.getName(), contact.getEmail(),
	                contact.getAddress(), contact.getTelephone());
	    }
	}

	@Override
	public void delete(int contactId) {
		String sql = "DELETE FROM contact WHERE contact_id=?";
		this.getJdbcTemplate().update(sql, contactId);
	}

	@Override
	public List<Contact> get(String valor) {
//		String sql = "SELECT * FROM contact WHERE id=" + valor;
		String sql = "select * from contact where id= ? or name like ?";
		List<Contact> ltaContact = this.getJdbcTemplate().query(sql,new Object[]{valor,"%"+valor+"%"}, new RowMapper<Contact>(){
			@Override
			public Contact mapRow(ResultSet rs, int i) throws SQLException {
				String nombre = rs.getString("name");
				String email = rs.getString("email");
				String address= rs.getString("address");
				String telefono = rs.getString("telefono");
				int id = rs.getInt("id");
				Contact c = new Contact(id,nombre,email,address,telefono);
				return c;
			}
		});
		return ltaContact;
	}

	@Override
	public List<Contact> list() {
		String sql = "select * from contact";
		List<Contact> ltaContact = this.getJdbcTemplate().query(sql, new RowMapper<Contact>(){
			@Override
			public Contact mapRow(ResultSet rs, int i) throws SQLException {
				String nombre = rs.getString("name");
				String email = rs.getString("email");
				String address= rs.getString("address");
				String telefono = rs.getString("telefono");
				int id = rs.getInt("id");
				Contact c = new Contact(id,nombre,email,address,telefono);
				return c;
			}
		});
		return ltaContact;
	}

}
