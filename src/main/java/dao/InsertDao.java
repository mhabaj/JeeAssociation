package dao;

/**
 * \brief classe DAO qui permet d'insérer des objets dans la base de données, on a pas besoin de faire des fonctions d'insertions dans chaque Dao, une classe commune suffit.
 * @author sean anica, juliette rondeau, alhabaj mahmod
 *
 */
public class InsertDao extends Dao {
	/**
	 * constructeur par défaut de la classe InsertDao.
	 */
	public InsertDao() {
			super();
		}

	/**
	 * Insertion d'un objet dans la base de données
	 * 
	 * @param o : Object
	 */
	public void insertObject(Object o) {
		getEm().getTransaction().begin();
		getEm().persist(o);
		getEm().getTransaction().commit();
	}

	/**
	 * Insertion d'un objet dans la base de données
	 * 
	 * @param o : Object
	 */
	public void insertObjectbyMerging(Object o) {
		getEm().getTransaction().begin();
		getEm().merge(o);
		getEm().getTransaction().commit();
	}
}
