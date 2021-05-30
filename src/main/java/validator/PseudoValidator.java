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
 * classe de validation du pseudo dans le formulaire.
 * @author sean anica, alhabaj mahmod, rondeau juliette
 * @version 5.0
 *
 */
@ManagedBean
@RequestScoped
public class PseudoValidator implements Validator {
	//Attributs
	final String ALREADY_EXISTS = "Ce pseudo est déjà utilisé";
	@EJB
	private UserDao userDao;

	/**
	 * fonction permettant de valider un champs du formulaire d'enregistrement.
	 */
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String pseudo = (String) value;
		userDao = new UserDao();
		try {
			if (userDao.getUserByLogin(pseudo) != null) {
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						ALREADY_EXISTS, null));
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(component.getClientId(facesContext), message);
		}

	}

}
