package com.association.model;

import java.io.Serializable;


/**
 * \brief Cette classe formalise la génération d'une clé primaire composite (composée de user et comment qui forment une clé primaire)
 * ET CETTE MERDE NE FONCTIONNE PAS SUR MAVEN CASSE LES COUILLES BORDEL ! 
 * @author sean anica, juliette rondeau et alhabaj mahmod
 * @version 3.0
 */
public class UpvotingId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -879616048896540208L;
	//Attributs
	public int user;
	public int comment;
	
	/**
	 * constructeur par défaut de la classe UpvotingId
	 * 
	 */
	public UpvotingId() {
		
	}
	
	/**
	 * constructeur de confort de la classe.
	 * @param user : int
	 * @param comment : int
	 */
	public UpvotingId(int user, int comment) {
		this.user = user;
		this.comment = comment;
	}
	/***********************************GETTERS ET SETTERS DES ATTRIBUTS****************************************/
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	/*******************************************************************************************************/
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpvotingId other = (UpvotingId) obj;
		if (comment != other.comment)
			return false;
		if (user != other.user)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	
	

}
