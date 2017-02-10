package fr.fiegel.conjugueur.commun.messages;

import java.io.Serializable;

public abstract class AMessage implements Serializable{

	private static final long serialVersionUID = -3115934667517357920L;
	protected String contenu;
	
	public AMessage(String contenu){
		this.contenu=contenu;
	}
	
	public String getMessage(){
		return this.contenu;
	}
	
}
