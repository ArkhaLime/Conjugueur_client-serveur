package fr.fiegel.conjugueur.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.verbe.AVerbe;

public class TempsParticipePasse extends ATemps {

	public TempsParticipePasse(ETemps temps) {
		super(temps);
	}

	@Override
	public String conjugue(AVerbe verbe) {
		return verbe.conjugueParticipePasse();
	}

	@Override
	protected ETemps getTemps() {
		return ETemps.PARTICIPE_PASSE;
	}

}
