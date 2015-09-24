package pe.com.dojoLearning.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.dojoLearning.beans.Contact;
import pe.com.dojoLearning.impl.ContactDAOImpl;

@Service
public class ConectaService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ConectaService.class);
	
	@Autowired
	private ContactDAOImpl contactDAOImpl;
	
	public List<Contact> buscar(String id){
		List<Contact> c = contactDAOImpl.get(id);
		return c;
	}

	public List<Contact> list() {
		List<Contact> c = contactDAOImpl.list();
		return c;
	}
}
