package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import model.User;

/**
 * \brief classe DAO qui permet d'effectuer des requêtes à la base de données en fonction des tables associées à l'utilisateur.
 * @author sayen
 *
 */
public class UserDao extends Dao {
	
	/**
	 * constructeur par défaut de la classe UserDao
	 */
	public UserDao() {
		super();
	}

	/**
	 * Permet de savoir si les identifiants de connexions sont valides ou pas.
	 * 
	 * @param pseudo : String
	 * @param password : String
	 * @return {true|false] : boolean
	 */
	public boolean isAuthentified(String pseudo, String password) {
		Query query = getEm().createQuery("SELECT u FROM User u WHERE pseudo = :pseudo AND password = :password");
		query.setParameter("pseudo", pseudo);
		query.setParameter("password", password);
		if (query.getResultList().size() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Détermine si l'email existe déjà dans la BDD ou pas.
	 * 
	 * @param email : String
	 * @return {true|false} : boolean
	 */
	public boolean isEmailUsed(String email) {
		Query query = getEm().createQuery("SELECT u FROM User u WHERE mail = :mail ");
		query.setParameter("mail", email);
		if (query.getResultList().size() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Récupère un utilisateur à partir de son login
	 * 
	 * @param login : String
	 * @return userByLogin : User
	 */
	public User getUserByLogin(String login) {
		Query query = getEm().createQuery("SELECT u FROM User u WHERE pseudo = :login ");
		query.setParameter("login", login);
		if (query.getResultList().size() != 0)
			return (User) query.getResultList().get(0);
		return null;
	}
	
	/**
	 * Récupère la liste de tous les utilisateurs de la base de données.
	 * @return allUsers : List<USer>
	 */
	public List<User> getAllUsers(){
		List<User> allUsers = new ArrayList<User>();
		allUsers = getEm().createQuery("SELECT u FROM User u", User.class).getResultList();
		return allUsers;
	}

}