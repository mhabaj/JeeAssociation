package com.association.util;

import java.io.*;
import java.util.*;
import javax.mail.internet.*;
import javax.mail.*;

public final class MailUtil extends Object implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3600096520857835145L;
	/* Bean Properties */
	private String destinataire = null;
	private String expediteur = null;
	private String sujet = null;
	private String message = null;
	public static Properties props = null;
	public static Session session = null;

	static {
		
		props = System.getProperties();
		props.put("mail.smtp.host", "mail.gmail.com");
		session = Session.getDefaultInstance(props, null);
	}
	
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	/* L'envoi d'un Email */
	public void envoiEmail() throws Exception {
		if(!this.everythingIsSet())
			throw new Exception("problème dans l'envoie du mail");
		try {
			MimeMessage message = new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO, 
				new InternetAddress(this.destinataire));
			message.setFrom(new InternetAddress(this.expediteur));
			message.setSubject(this.sujet);
			message.setText(this.message);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new Exception(e.getMessage());
		}
	}

	/* Verifier si toutes les proprietes ont été entrees */
	private boolean everythingIsSet() {
		if((this.destinataire == null) || (this.expediteur == null) || 
		   (this.sujet == null) || (this.message == null))
			return false;

		if((this.destinataire.indexOf("@") == -1) ||
			(this.destinataire.indexOf(".") == -1))
			return false;

		if((this.expediteur.indexOf("@") == -1) ||
			(this.expediteur.indexOf(".") == -1))
			return false;

		return true;
	}
}
