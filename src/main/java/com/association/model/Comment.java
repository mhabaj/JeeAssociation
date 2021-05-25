package com.association.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * \brief classe des commentaires dans le modèle qui permettront de générer la base de données
 * à partir des annotations d'hibernate présentes dans la classe.
 * @author Sean Anica, Alhabaj Mahmod et Rondeau Juliette
 * @version 1.0
 */
@Entity(name = "Comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComment;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;

	@NotNull(message = "Vous devez saisir votre commentaire")
	@Size(max = 800, message = "Votre commentaire ne doit pas dépasser 800 caractères")
	private String content;

	private LocalDate date;

	private int upvoteNumber;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "comment")
	private List<Upvoting> upvoting; // le commentaire a sa liste d'upvotes qui lui sont associés.
	
	/**
	 * constructeur par défaut
	 */
	public Comment() {
		this.upvoteNumber = 0;
	}
	
	public Comment(String content) {
		this.content = content;
		this.date = LocalDate.now();
	}
	
	/***********************************GETTERS ET SETTERS DES ATTRIBUTS****************************************/
	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getUpvoteNumber() {
		return upvoteNumber;
	}

	public void setUpvoteNumber(int upvoteNumber) {
		this.upvoteNumber = upvoteNumber;
	}

	public List<Upvoting> getUpvoting() {
		return upvoting;
	}

	public void setUpvoting(List<Upvoting> upvoting) {
		this.upvoting = upvoting;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/***************************************************************************************************/

	@Override
	public String toString() {
		return "Comment [content=" + content + "]";
	}



	
}
