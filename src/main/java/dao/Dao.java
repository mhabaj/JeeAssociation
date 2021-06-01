package dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * \brief classe Dao mère qui sera la base de tous les sous dao.
 * @author sean anica, juliette rondeau, alhabaj mahmod
 * @version 1.0
 */
public class Dao {
	
	//Attributs
	private EntityManager em;

	/**
	 * constructeur qui génère l'entity manager
	 */
	public Dao() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestionAssociation");
		this.setEm(entityManagerFactory.createEntityManager());
	}
	
	/**
	 * getter de l'attribut entity manager
	 * @return em : EntityManager
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * setter de l'attribut entity manager
	 * @param em : EntityManager
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	

}
