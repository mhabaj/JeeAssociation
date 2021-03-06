package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import model.Comment;

/**
 * \brief classe DAO des commentaires, permet d'effectuer les opérations classiques sur la table de la base de données.
 * @author sean anica, juliette rondeau, alhabaj mahmod
 * @version 1.0
 */
public class CommentDao extends Dao {
	
	/**
	 * Constructeur par défaut de la classe CommentDao.
	 */
	public CommentDao() {
		super();
	}
	
	/**
	 * Récupère la liste des commentaires de la base de données
	 * 
	 * @return returnList : List<Comment>
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getAllComments() {
		List<Comment> returnList = new ArrayList<Comment>();
		Query query = getEm().createQuery("SELECT e FROM Comment e ORDER BY UpvoteNumber DESC");
		returnList = query.getResultList();
		return returnList;
	}
	
	/**
	 * Augmenter le nombre de likes d'un commentaire de 1.
	 * @param content : String
	 */
	public void updateCommentLikes(String content) {
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
	 * baisser le nombre de likes d'un commentaire de 1. On ne peut pas disliker dans les négatifs.
	 * @param content : String
	 */
	public void updateCommentDislikes(String content) {
		try {
			Comment comment = getEm().find(Comment.class, FindIdByContent(content));
			if(comment.getUpvoteNumber() > 0) {
				getEm().getTransaction().begin();
				comment.setUpvoteNumber(comment.getUpvoteNumber() - 1);
				getEm().merge(comment);
				getEm().flush();
				getEm().getTransaction().commit();
			}
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