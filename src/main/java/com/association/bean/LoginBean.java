package com.association.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.mindrot.jbcrypt.BCrypt;

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
	 * Permet de valider la connexion d'un utilisateur et par conséquent de le rediriger vers la page qu'il faut.
	 * @return redirection : String
	 */
	public String isUserValid() {
		try {
			UserDao UserDao = new UserDao();
			//vérification du mot de passe
			User userToTest = new User();
			userToTest = UserDao.getUserByLogin(user.getPseudo());//on cherche l'utilisateur dans la base de données
			if (BCrypt.checkpw(user.getPassword(), userToTest.getPassword()))//on le compare au mot de passe rentré
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
	 * permet de déconnecter l'utilisateur de son compte.
	 * @return redirection : String
	 */
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();//nettoyer la session
		return "Login?faces-redirect=true"; //rediriger vers la page de connexion.
	}

	/**
	 * permet d'obtenir l'erreur d'un certain champs.
	 * @return errorMessage : String
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Permet de générer les erreurs de champs.
	 * @param errorMessage : String
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/**
	 * Getter de l'attribut user.
	 * @return
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * Setter de l'attribut user.
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
