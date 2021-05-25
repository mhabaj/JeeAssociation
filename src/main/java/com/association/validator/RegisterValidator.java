package com.association.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.association.dao.UserDao;

/**
 * \brief classe des validateurs de register, permet de vérifier la validité des données d'inscription.
 * @author sean anica, juliette rondeau, alhabaj mahmod
 * @version 1.0
 *
 */
@FacesValidator(value = "registerValidator")
public class RegisterValidator implements Validator{
	private final String ALREADY_EXIST = "Cette adresse mail existe déjà";
	private UserDao userDao;
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String email = (String) value;//récupération de la valeur à traiter avec value
		userDao = new UserDao();
		try {
			if(userDao.find(email)) {
				//si : vérifie l'existence du mail de l'utilisateur dans la bdd, il existe déjà donc on retourne une exception
				new FacesMessage(FacesMessage.SEVERITY_ERROR, ALREADY_EXIST, null);
			}
		}catch(Exception registerValidateException) {
			//si jamais il y a une erreur non prévue venant de la base de données
			//il y a un message qui sort, on affiche l'erreur à l'utilisateur.
			FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, registerValidateException.getMessage(), null );
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        facesContext.addMessage( component.getClientId( facesContext ), message );	
		}
	}
}
