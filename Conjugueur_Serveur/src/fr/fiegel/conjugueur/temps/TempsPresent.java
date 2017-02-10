package fr.fiegel.conjugueur.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.verbe.AVerbe;

public class TempsPresent extends ATemps {

	
	
	public TempsPresent(ETemps temps) {
		super(temps);
	}

	@Override
	public String conjugue(AVerbe verbe) {
		return verbe.conjuguePresent();
	}

	@Override
	protected ETemps getTemps() {
		return ETemps.PRESENT;
	}

}
