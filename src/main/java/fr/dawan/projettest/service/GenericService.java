package fr.dawan.projettest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projettest.DAO.GenericDAO;
import fr.dawan.projettest.entite.DbObject;


@Service
public class GenericService<T extends DbObject> {
	
	@Autowired
	GenericDAO<T> genericDAO;
	
	public void create(T entity) {
		genericDAO.create(entity);
	}
	
	public List<T> findAll(Class<T> clazz) {
		return genericDAO.findAll(clazz);
	}

}
