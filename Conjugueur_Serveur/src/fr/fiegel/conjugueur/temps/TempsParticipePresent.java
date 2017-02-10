package fr.fiegel.conjugueur.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.verbe.AVerbe;

public class TempsParticipePresent extends ATemps {

	public TempsParticipePresent(ETemps temps) {
		super(temps);
	}

	@Override
	public String conjugue(AVerbe verbe) {
		return verbe.conjugueParticipePresent();
	}

	@Override
	protected ETemps getTemps() {
		return ETemps.PARTICIPE_PRESENT;
	}

}
