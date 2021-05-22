package com.association.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import com.association.model.Comment;

/**
 * \brief classe DAO des commentaires, permet d'effectuer les opérations classiques sur la table de la base de données.
 * @author sean anica, juliette rondeau, alhabaj mahmod
 * @version 1.0
 */
public class CommentDao extends Dao {
	/**
	 * Récupère la liste des commentaires de la base de données
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getAllComments() {
		List<Comment> returnList = new ArrayList<Comment>();
		Query query = getEm().createQuery("SELECT e FROM Comment e ORDER BY e.upvoteNumber DESC");
		returnList = query.getResultList();

		return returnList;
	}

	/**
	 * Met à jour le compteur de votes d'un commentaire
	 * 
	 * @param content : String
	 */
	public void updateCompteur(String content) {
		try {
			Comment comment = getEm().find(Comment.class, FindIdByContent(content));
			getEm().getTransaction().begin();
			comment.setUpvoteNumber(comment.getUpvoteNumber() + 1);
			getEm().merge(comment);
			getEm().flush();
			getEm().getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Récupère l'id d'un commentaire par rapport à son contenu entré en paramètre.
	 * 
	 * @param content : String
	 * @return idComment : int
	 */
	private int FindIdByContent(String content) {
		Query query = getEm().createQuery("SELECT u FROM Comment u WHERE content = :content ");
		query.setParameter("content", content);
		Comment comment = (Comment) query.getResultList().get(0);
		return comment.getIdComment();
	}

	/**
	 * Récupère un commentaire à partir de son contenu entré en paramètre.
	 * 
	 * @param content : String
	 * @return comment : Comment
	 */
	public Comment getCommentByContent(String content) {
		Query query = getEm().createQuery("SELECT u FROM Comment u WHERE content = :content ");
		query.setParameter("content", content);
		if (query.getResultList().size() != 0)
			return (Comment) query.getResultList().get(0);
		return null;
	}

}