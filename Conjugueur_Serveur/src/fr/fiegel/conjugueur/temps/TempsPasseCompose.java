package fr.fiegel.conjugueur.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.verbe.AVerbe;

public class TempsPasseCompose extends ATemps {

	public TempsPasseCompose(ETemps temps) {
		super(temps);
	}

	@Override
	public String conjugue(AVerbe verbe) {
		return verbe.conjuguePasseCompose();
	}

	@Override
	protected ETemps getTemps() {
		return ETemps.PASSE_COMPOSE;
	}

}
