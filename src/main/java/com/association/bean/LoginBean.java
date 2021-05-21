package com.association.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.association.dao.UserDao;
import com.association.model.User;

/**
 * \brief classe bean de login qui permet aux utilisateurs de se connecter.
 * @author sayen
 *
 */
@ManagedBean(name = "loginBean", eager = true)
@SessionScoped
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6077309216492300196L;
	//Attributs
	private User user = new User();
	private String errorMessage;
	private static final String UNMATCHED = "identifiants faux !";
	
	/**
	 * 
	 * @return redirection : String
	 */
	public String isUserValid() {
		try {
			UserDao UserDao = new UserDao();
			if (UserDao.isAuthentified(user.getPseudo(), user.getPassword()))
				return "Welcome?faces-redirect=true";
			else
				setErrorMessage(UNMATCHED);
		} catch (Exception e) {
			System.out.println(e);
			return "Error?faces-redirect=true";
		}
		return "Login?faces-redirect=true";
	}
	
	/**
	 * 
	 * @return redirection : String
	 */
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();//nettoyer la session
		return "Login?faces-redirect=true"; //rediriger vers la page de connexion.
	}

	/**
	 * 
	 * @return errorMessage : String
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * 
	 * @param errorMessage : String
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/**
	 * 
	 * @return
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
