package com.association.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.association.dao.UserDao;

/**
 * \brief classe des validateurs de login, permet de vérifier la validité des données de connexion.
 * @author sean anica, juliette rondeau, alhabaj mahmod
 * @version 1.0
 *
 */
@FacesValidator(value = "loginValidator")
public class LoginValidator implements Validator{
	private final String ALREADY_EXIST = "Ce nom d'utilisateur existe déjà";

	private UserDao userDao;
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String pseudo = (String) value;//récupération de la valeur à traiter avec value
		userDao = new UserDao();
		try {
			if(userDao.getUserByLogin(pseudo) != null) {
				//si : l'utilisateur est trouvé à partir de son pseudo, il existe déjà donc on retourne une exception
				new FacesMessage(FacesMessage.SEVERITY_ERROR, ALREADY_EXIST, null);
			}
		}catch(Exception loginValidateException) {
			//si jamais il y a une erreur non prévue venant de la base de données
			//il y a un message qui sort, on affiche l'erreur à l'utilisateur.
			FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, loginValidateException.getMessage(), null );
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        facesContext.addMessage( component.getClientId( facesContext ), message );	
		}
	}
	
}
