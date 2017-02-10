package fr.fiegel.conjugueur.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.verbe.AVerbe;

public class TempsFutur extends ATemps {

	public TempsFutur(ETemps temps) {
		super(temps);
	}

	@Override
	public String conjugue(AVerbe verbe) {
		return verbe.conjugueFutur();
	}

	@Override
	protected ETemps getTemps() {
		return ETemps.FUTUR;
	}

}
