package com.association.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.validator.ValidatorException;

import com.association.dao.InsertDao;
import com.association.model.User;
import com.association.util.MailUtil;

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
	 * permet d'envoyer le message de confirmation lors du login.
	 * @param destinataire
	 * @param expediteur
	 * @param prenom
	 * @param sujet
	 * @param message
	 * @throws Exception
	 */
    public void envoiMailConfirmation(String destinataire,String expediteur,String prenom, String sujet,String message) throws Exception{
    	MailUtil mail = new MailUtil();	
    	mail.setExpediteur(expediteur);
    	mail.setDestinataire(destinataire);
    	mail.setSujet(sujet);
    	mail.setMessage(message);
    	mail.envoiEmail();
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
