package com.association.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.association.dao.UserDao;
import com.association.model.User;

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
	private List<User> users;
	
	/**
	 * getter de l'attribut users
	 * @return users
	 */
	public List<User> getUsers() {
		UserDao userDao = new UserDao();
		users = userDao.getAllUsers();
		return users;
	}

	/**
	 * setter de l'attribut users
	 * @param users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
