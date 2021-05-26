package com.association.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.association.dao.CommentDao;
import com.association.dao.InsertDao;
import com.association.dao.UserDao;
import com.association.model.Comment;

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
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	
	/**
	 * Ajouter un commentaire à la base de données.
	 * @return redirection : String 
	 */
	public String CommentSomething() {
		try {
			InsertDao insertDao = new InsertDao();
			UserDao userDao = new UserDao();
			Comment comment = new Comment(this.comment.getContent());
			comment.setUser(userDao.getUserByLogin(loginBean.getUser().getPseudo()));
			insertDao.insertObject(comment);
		} catch (Exception e) {
			return "Error?faces-redirect=true";
		}
		return "Comments?faces-redirect=true";
	}
	
	/**
	 * augmenter le nombre d'upvotes d'un commentaire en fonction de son contenant.
	 * @param content : String
	 * @return redirection : String
	 */
	public String upvoteAComment(String content) {
		try {
			UserDao userDao = new UserDao();
			CommentDao commentDao = new CommentDao();
			InsertDao insertDao = new InsertDao();
			for (Comment comment : comments) {
				if (content.equals(comment.getContent())) {
					int userId = userDao.getUserByLogin(loginBean.getUser().getPseudo()).getIdUser();
					if (!userDao.hasUserUpvotedComment(userId, comment.getIdComment())) { //si l'utilisateur a upvote un commentaire
						commentDao.updateCompteur(comment.getContent());
						insertDao.insertObjectbyMerging(commentDao.getCommentByContent(comment.getContent()));
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			return "Error?faces-redirect=true";
		}
		return "Comments";
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

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	/****************************************************************************************************************************/

	
}
