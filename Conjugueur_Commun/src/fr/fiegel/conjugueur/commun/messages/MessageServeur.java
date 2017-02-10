package fr.fiegel.conjugueur.commun.messages;

import fr.fiegel.conjugueur.commun.enums.EMsgType;

public class MessageServeur extends AMessage{

	private static final long serialVersionUID = -7355114561479914862L;
	private EMsgType type;
	
	public MessageServeur(EMsgType type, String contenu){
		super(contenu);
		this.type=type;
	}
	
	public EMsgType getType(){
		return this.type;
	}
	
	public String getStrType(){
		return this.type.toString();
	}
	
	@Override
	public String toString(){
		return "MessageServeur => {["+this.type+"] "+this.contenu+"}";
	}
	
}
