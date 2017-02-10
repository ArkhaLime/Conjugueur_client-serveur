package fr.fiegel.conjugueur.commun.messages;

import fr.fiegel.conjugueur.commun.enums.ETemps;

public class MessageClient extends AMessage {

	private static final long serialVersionUID = 4727940565009313122L;
	private ETemps tps;

	public MessageClient(String infinitif, ETemps temps) {
		super(infinitif);
		this.tps=temps;
	}

	public ETemps getTemps(){
		return this.tps;
	}
	
	public String getStrTemps(){
		return this.tps.toString();
	}
	
	@Override
	public String toString() {
		return "MessageClient => {'"+this.contenu+"' au "+getStrTemps()+"}";
	}
	
}
