package fr.dawan.projettest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projettest.DAO.GenericDAO;
import fr.dawan.projettest.entite.DbObject;


@Service
@Transactional
public class GenericService<T extends DbObject> {
	
	@Autowired
	GenericDAO<T> genericDAO;
	
	public void create(T entity,boolean close) {
		genericDAO.create(entity,close);
	}
	
	public List<T> findAll(Class<T> clazz,boolean close) {
		return genericDAO.findAll(clazz,close);
	}

	public void deleteById(Class<T> clazz,long id,boolean close) {
		genericDAO.delete(clazz, id, close);
	}
	
	public void update(T entity,boolean close) {
		genericDAO.update(entity, close);
	}
	public T findById(Class<T> clazz,long id,boolean close) {
		return genericDAO.findById(clazz, id, close);
	}

}