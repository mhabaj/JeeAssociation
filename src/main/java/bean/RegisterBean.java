package bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.mindrot.jbcrypt.BCrypt;

import dao.InsertDao;
import dao.UserDao;
import model.User;

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
	
	private User user;
	
	@EJB
	private UserDao userDao;
	
	public RegisterBean() {
		user = new User();
	}
	/**
	 * \brief permet de créer le compte d'un utilisateur.
	 * @return
	 * @throws ValidatorException
	 */
	public String registerUser()throws ValidatorException{
		try {
			InsertDao insertDao = new InsertDao();
			//hashage de mot de passe
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashed);
			//ajout de l'utilisateur
			insertDao.insertObject(user);
			FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
	        FacesContext.getCurrentInstance().addMessage( null, message );
		} catch (Exception e) {
			System.out.println(e);
			return "Error";
		}
		return "Login?faces-redirect=true";
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
