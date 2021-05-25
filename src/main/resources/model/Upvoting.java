package com.association.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 * \brief classe des upvotes dans le modèle qui permettront de générer la base de données
 * à partir des annotations d'hibernate présentes dans la classe.
 * @author Sean Anica, Alhabaj Mahmod et Rondeau Juliette
 * @version 1.0
 */
@Entity
@IdClass(UpvotingId.class)
public class Upvoting {
	@Id
	@ManyToOne
	User user;

	@Id
	@ManyToOne
	Comment comment;
	
	private boolean upvoted;
	
	/**
	 * constructeur par défaut
	 */
	public Upvoting() {
		
	}
	
	/**
	 * constructeur de confort de la classe.
	 * @param user
	 * @param comment
	 */
	public Upvoting(User user, Comment comment) {
		super();
		this.user = user;
		this.comment = comment;
		this.upvoted = true; //on le met à true car si un objet upvoting est initialisé il passe à true par défaut
	}

	/***********************************GETTERS ET SETTERS DES ATTRIBUTS****************************************/

	public boolean isUpvoted() {
		return upvoted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public void setUpvoted(boolean upvoted) {
		this.upvoted = upvoted;
	}
	/****************************************************************************************************/

	/**
	 * redéfinition de la méthode toString de la classe Upvoting
	 * @return upvotingAffichage : String
	 */
	@Override
	public String toString() {
		return "Upvoting [user=" + user + ", comment=" + comment + ", upvoted=" + upvoted + "]";
	}

	
}
