package fr.fiegel.conjugueur.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.verbe.AVerbe;;

public abstract class ATemps {
	
	public ATemps(ETemps temps) {
		if(temps!=getTemps()){
			throw new IllegalArgumentException("Le temps ne correspond pas");
		}
	}
	
	public abstract String conjugue(AVerbe verbe);
	
	protected abstract ETemps getTemps();

}
