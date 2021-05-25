package com.association.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * \brief classe des utilisateurs du modèle qui permettront de générer la base de données
 * à partir des annotations d'hibernate présentes dans la classe.
 * @version 1.0
 * @author Sean Anica, Alhabaj Mahmod et Rondeau Juliette
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
	
	@NotNull(message = "Une adresse mail doit être saisie")
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "veuillez saisir une adresse mail valide")
	private String mail;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "user") //1 user peut posséder plusieurs commentaires à son nom
	private List<Comment> commentList;//liste de ses commentaires écrits.
	

	/**
	 * constructeur par défaut
	 */
	public User() {
		super();
	}
	
	/**
	 * constructeur de confort qui permet d'initialiser tous les attributs de la classe.
	 * @param pseudo
	 * @param password
	 * @param name
	 * @param firstname
	 * @param address
	 * @param mail
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
	 * @param pseudo
	 * @param password
	 */
	public User(String pseudo, String password) {
		super();
		this.pseudo = pseudo;
		this.password = password;
	}

	/***********************************GETTERS ET SETTERS DES ATTRIBUTS****************************************/
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
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
				+ ", firstname=" + firstname + ", address=" + address + ", mail=" + mail + ", commentList="
				+ commentList + "]";
	}
	
	
}
