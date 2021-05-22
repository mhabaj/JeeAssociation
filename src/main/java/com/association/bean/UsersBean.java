package com.association.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.association.dao.UserDao;
import com.association.model.User;

@ManagedBean
@RequestScoped
public class UsersBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6753602910444382594L;
	private List<User> users;
	

	public List<User> getUsers() {
		UserDao userDao = new UserDao();
		users = userDao.getAllUsers();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
