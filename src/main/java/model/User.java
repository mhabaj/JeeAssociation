package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * \brief classe des utilisateurs du modèle qui permettront de générer la base de données
 * à partir des annotations d'hibernate présentes dans la classe.
 * @version 1.0
 * @author Anica Sean,  Alhabaj Mahmod et Rondeau Juliette
 *
 */
@Entity(name = "User")
public class User {
	//Attributs de la classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@NotNull(message = "Un nom d'utilisateur (pseudo) doit être saisi")
	@Size(max = 50, message ="Le nom d'utilisateur doit être inferieur à 50 caractères")
	private String pseudo;
	
	@NotNull(message = "Un mot de passe (password) doit être saisi")
	@Size(min = 8, message = "Le mot de passe saisi doit contenir au moins 8 caractères")
	private String password;
	
	@NotNull(message = "Un nom doit être saisi")
	private String name;
	
	@NotNull(message = "Un prénom doit être saisi")
	private String firstname;
	
	@NotNull(message = "Une adresse doit être saisie")
	private String address;
	
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "veuillez saisir une adresse mail valide")
	@NotNull(message = "Une adresse mail doit être saisie")
	private String mail;
	
	/**
	 * constructeur par défaut de la classe.
	 */
	public User() {
		super();
	}
	
	/**
	 * constructeur de confort qui permet d'initialiser tous les attributs de la classe.
	 * @param pseudo : String
	 * @param password : String
	 * @param name : String
	 * @param firstname : String
	 * @param address : String
	 * @param mail : String
	 */
	public User(String pseudo, String password, String name, String firstname, String address, String mail) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.address = address;
		this.mail = mail;
		this.pseudo = pseudo;
		this.password = password;
	}
	
	/**
	 * constructeur de confort qui permet d'initialiser les attributs pseudo et mot de passe de la classe.
	 * @param pseudo : String
	 * @param password : String
	 */
	public User(String pseudo, String password) {
		super();
		this.pseudo = pseudo;
		this.password = password;
	}

	/***********************************GETTERS ET SETTERS DES ATTRIBUTS****************************************/
	/**
	 * getter de l'attribut idUser de la classe.
	 * @return idUser : int
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * setter de l'attribut idUser de la classe.
	 * @param idUser : int
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * getter de l'attribut pseudo de la classe.
	 * @return pseudo : String
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * setter de l'attribut pseudo de la classe.
	 * @param pseudo : String
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * getter de l'attribut password de la classe.
	 * @return password : String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter de l'attribut password de la classe.
	 * @param password : String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getter de l'attribut name de la classe.
	 * @return name : String
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter de l'attribut name de la classe.
	 * @param name : String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter de l'attribut firstName de la classe.
	 * @return firstName : String
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * setter de l'attribut firstName de la classe.
	 * @param firstname : String
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * getter de l'attribut address de la classe.
	 * @return address : String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * setter de l'attribut address de la classe.
	 * @param address : String
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getter de l'attribut mail de la classe.
	 * @return mail : String
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * setter de l'attribut mail de la classe.
	 * @param mail : String
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/****************************************************************************************************/

	/**
	 * redéfinition de la méthode toString de la classe User.
	 * 
	 *@return affichageUser : String
	 */
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", pseudo=" + pseudo + ", password=" + password + ", name=" + name
				+ ", firstname=" + firstname + ", address=" + address + ", mail=" + mail + "]";
	}
	
	
}
