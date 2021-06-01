package validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import dao.UserDao;

/**
 * \brief classe des validateurs de register, permet de vérifier la validité des
 * 			données d'inscription.
 * 
 * @author sean anica, juliette rondeau, alhabaj mahmod
 * @version 1.0
 *
 */
@ManagedBean
@RequestScoped
public class EmailValidator implements Validator {
	final String ALREADY_EXISTS = "Cette adresse mail est déjà utilisée";

	@EJB
	private UserDao userDao;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String email = (String) value;// récupération de la valeur à traiter avec value
		userDao = new UserDao();
		try {
			if (userDao.isEmailUsed(email) == true) {
				System.out.println(userDao.isEmailUsed(email));
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ALREADY_EXISTS, null));
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(component.getClientId(facesContext), message);
		}
	}
}
