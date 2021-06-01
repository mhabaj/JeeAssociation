package model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	//Attributs
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComment;

	@NotNull(message = "Vous devez saisir votre commentaire")
	@Size(max = 800, message = "Votre commentaire ne doit pas dépasser 800 caractères")
	private String content;

	private LocalDate date;

	private int upvoteNumber;
	
	/**
	 * constructeur par défaut de la classe
	 */
	public Comment() {
		this.upvoteNumber = 0;
	}
	
	/**
	 * Constructeur de confort de la classe.
	 * @param content
	 */
	public Comment(String content) {
		this.content = content;
		this.date = LocalDate.now();
	}
	
	/***********************************GETTERS ET SETTERS DES ATTRIBUTS****************************************/
	/**
	 * getter de l'idComment de la classe
	 * @return idComment : int
	 */
	public int getIdComment() {
		return idComment;
	}

	/**
	 * setter de l'IdComment de la classe.
	 * @param idComment : int
	 */
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	/**
	 * getter de l'attribut content de la classe.
	 * @return content : String
	 */
	public String getContent() {
		return content;
	}

	/**
	 * setter de l'attribut content de la classe.
	 * @param content :  String
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * getter de l'attribut date de la classe.
	 * @return date : LocalDate
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * setter de l'attribut date de la classe.
	 * @param date : LocalDate
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * getter de l'attribut upvoteNumber de la classe.
	 * @return upvoteNumber : int
	 */
	public int getUpvoteNumber() {
		return upvoteNumber;
	}

	/**
	 * setter de l'attribut upvoteNumver de la classe.
	 * @param upvoteNumber : int
	 */
	public void setUpvoteNumber(int upvoteNumber) {
		this.upvoteNumber = upvoteNumber;
	}
	/***************************************************************************************************/

	/**
	 * redéfinition de la méthode toString de la classe.
	 */
	@Override
	public String toString() {
		return "Comment [content=" + content + "]";
	}



	
}
