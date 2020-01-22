package fr.dawan.projettest.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.Commande;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long>{

}
