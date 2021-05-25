package com.association.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.association.model.Comment;
import com.association.model.Upvoting;
import com.association.model.User;

/**
 * \brief classe DAO qui permet d'effectuer des requêtes à la base de données en fonction des tables associées à l'utilisateur.
 * @author sayen
 *
 */
public class UserDao extends Dao {
	
	/**
	 * constructeur par défaut de la classe UserDao
	 */
	public UserDao() {
		super();
	}

	/**
	 * Permet de savoir si les identifiants de connexions sont valides ou pas.
	 * 
	 * @param pseudo : String
	 * @param password : String
	 * @return {true|false] : boolean
	 */
	public boolean isAuthentified(String pseudo, String password) {
		Query query = getEm().createQuery("SELECT u FROM User u WHERE pseudo = :pseudo AND password = :password");
		query.setParameter("pseudo", pseudo);
		query.setParameter("password", password);
		if (query.getResultList().size() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Détermine si l'email existe déjà dans la BDD ou pas.
	 * 
	 * @param email : String
	 * @return {true|false} : boolean
	 */
	public boolean find(String email) {
		Query query = getEm().createQuery("SELECT u FROM User u WHERE mail = :mail ");
		query.setParameter("mail", email);
		if (query.getResultList().size() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Récupère un utilisateur à partir de son login
	 * 
	 * @param login : String
	 * @return userByLogin : User
	 */
	public User getUserByLogin(String login) {
		Query query = getEm().createQuery("SELECT u FROM User u WHERE pseudo = :login ");
		query.setParameter("login", login);
		if (query.getResultList().size() != 0)
			return (User) query.getResultList().get(0);
		return null;
	}
	
	/**
	 * Récupère la liste de tous les utilisateurs de la base de données.
	 * @return allUsers : List<USer>
	 */
	public List<User> getAllUsers(){
		List<User> allUsers = new ArrayList<User>();
		allUsers = getEm().createQuery("SELECT u FROM User u", User.class).getResultList();
		
		//selectionner ses commentaires et ses upvotes
		List<Comment> commentsOfThisUser = new ArrayList<Comment>();
		List<Upvoting> upvotingsOfThisUser = new ArrayList<Upvoting>(); 
		for(User currentUser : allUsers) {
			//commentaires
			Query query = getEm().createQuery("SELECT e FROM Comment e WHERE user_idUser= :user_idUser ORDER BY e.upvoteNumber DESC")
					.setParameter("user_idUser", currentUser.getIdUser());
			if(query.getResultList().size() != 0) {
				commentsOfThisUser = query.getResultList();
				currentUser.setCommentList(commentsOfThisUser);
			}
			//upvotes
			Query query2 = getEm().createQuery("SELECT v FROM Upvoting v WHERE user_idUser= :user_idUser")
					.setParameter("user_idUser", currentUser.getIdUser());
			if(query2.getResultList().size() != 0) {
				upvotingsOfThisUser = query2.getResultList();
				currentUser.setUpvotingList(upvotingsOfThisUser);
			}
		}
		return allUsers;
	}

	/**
	 * Détermine si un utilisateur a voté pour un commentaire
	 * 
	 * @param userId : int
	 * @param commentId : int
	 * @return {true|false} : boolean
	 */
	public boolean hasUserUpvotedComment(int userId, int commentId) {
		Query query = getEm()
				.createQuery(
						"SELECT u FROM Upvoting u WHERE user_idUser = :user_idUser AND comment_idComment =:comment_idComment ")
				.setParameter("user_idUser", userId).setParameter("comment_idComment", commentId);
		if (query.getResultList().size() != 0) {
			return true;
		}
		return false;
	}

}