package fr.fiegel.conjugueur.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.verbe.AVerbe;

public class TempsConditionnelPresent extends ATemps {

	public TempsConditionnelPresent(ETemps temps) {
		super(temps);
	}

	@Override
	public String conjugue(AVerbe verbe) {
		return verbe.conjugueCondPresent();
	}

	@Override
	protected ETemps getTemps() {
		return ETemps.CONDITIONNEL_PRESENT;
	}

}
