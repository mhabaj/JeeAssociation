package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import dao.UserDao;
import model.User;

/**
 * classe Users bean qui permet de récupérer tous les utilisateurs du club.
 * @author sean anica, juliette rondeau, alhabaj mahmod
 * @version 4
 *
 */
@ManagedBean
@RequestScoped
public class UsersBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6753602910444382594L;
	//Attributs
	private List<User> users;
	
	/**
	 * getter de l'attribut users
	 * @return users : List<User>
	 */
	public List<User> getUsers() {
		UserDao userDao = new UserDao();
		users = userDao.getAllUsers();
		return users;
	}

	/**
	 * setter de l'attribut users
	 * @param users List<User>
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
