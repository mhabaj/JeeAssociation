package com.association.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.validator.ValidatorException;

import com.association.dao.InsertDao;
import com.association.model.User;

/**
 * \brief classe register bean permettant à l'utilisateur de créer son compte.
 * @author sean anica, juliette rondeau, alhabaj mahmod
 * @version 1.0
 *
 */
@ManagedBean
@RequestScoped
public class RegisterBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2135191050019499896L;
	//Attributs
	private User user = new User();
	
	/**
	 * \brief permet de créer le compte d'un utilisateur.
	 * @return
	 * @throws ValidatorException
	 */
	public String registerUser()throws ValidatorException{
		try {
			InsertDao insertDao = new InsertDao();
			insertDao.insertObject(user);
		} catch (Exception e) {
			return "Error";
		}
		return "Login?faces-redirect=trues";
	}
	
	/**
	 * getter de l'attribut user de registerbean
	 * @return user : User
	 */
	public User getUser() {
		return user;
	}

	/**
	 * setter de l'attribut user de registerbean
	 * @param user : User
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
