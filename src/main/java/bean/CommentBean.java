package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.CommentDao;
import dao.InsertDao;
import model.Comment;

/**
 * \brief classe Comment bean permettant à l'utilisateur de poster, consulter les commentaires du livre d'or.
 * @author sean anica, juliette rondeau, alhabaj mahmod
 *
 */
@ManagedBean
@RequestScoped
public class CommentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7213580951683074092L;
	//Attributs
	private List<Comment> comments;
	private Comment comment = new Comment();
	
	/**
	 * Ajouter un commentaire à la base de données.
	 * @return redirection : String 
	 */
	public String CommentSomething() {
		try {
			InsertDao insertDao = new InsertDao();
			Comment comment = new Comment(this.comment.getContent());
			insertDao.insertObject(comment);
		} catch (Exception e) {
			return "Error?faces-redirect=true";
		}
		return "Comments?faces-redirect=true";
	}
	
	/**
	 * permet de liker un commentaire et de mettre à jour le nombre de likes dans la base de données.
	 * @param content
	 * @return
	 */
	public String likeAComment(String content) {
		try {
			CommentDao commentDao = new CommentDao();
			for(Comment comment : comments) {
				if(content.equals(comment.getContent())) {
					commentDao.updateCommentLikes(content);
				}
			}
		}catch(Exception e) {
			return "Erreur?faces-redirect=true";
		}
		return "LivretDeCommentaires?faces-redirect=true";
	}
	
	/**
	 * permet de disliker un commentaire et de mettre à jour le nombre de likes dans la base de données.
	 * @param content
	 * @return
	 */
	public String dislikeAComment(String content) {
		try {
			CommentDao commentDao = new CommentDao();
			for(Comment comment : comments) {
				if(content.equals(comment.getContent())) {
					commentDao.updateCommentDislikes(content);
				}
			}
		}catch(Exception e) {
			return "Erreur?faces-redirect=true";
		}
		return "LivretDeCommentaires?faces-redirect=true";
	}
	

	/********************************************GETTERS ET SETTERS DE LA CLASSE********************************************/
	public List<Comment> getComments() {
		CommentDao commentDao = new CommentDao();
		comments = commentDao.getAllComments();
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	/****************************************************************************************************************************/

	
}
