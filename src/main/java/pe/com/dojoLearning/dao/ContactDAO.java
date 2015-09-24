package pe.com.dojoLearning.dao;

import java.util.List;

import pe.com.dojoLearning.beans.Contact;

public interface ContactDAO {
	public void saveOrUpdate(Contact contact);
    
    public void delete(int contactId);
     
    public List<Contact> get(String contactId);
     
    public List<Contact> list();
}
