package fr.fiegel.conjugueur.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.verbe.AVerbe;

public class TempsConditionnelPasse extends ATemps {

	public TempsConditionnelPasse(ETemps temps) {
		super(temps);
	}

	@Override
	public String conjugue(AVerbe verbe) {
		return verbe.conjugueCondPasse();
	}

	@Override
	protected ETemps getTemps() {
		return ETemps.CONDITIONNEL_PASSE;
	}

}
