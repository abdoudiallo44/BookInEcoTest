package fr.dawan.projettest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projettest.DAO.AdresseDAO;

@Service
@Transactional
public class AdresseService extends GenericService {
	@Autowired
	private AdresseDAO adresseDao;
	
	public void deleteAdresseById(long id) {
		adresseDao.deleteAdresseById(id);
	}
}
