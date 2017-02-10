package fr.fiegel.conjugueur.parser.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.temps.ATemps;
import fr.fiegel.conjugueur.temps.TempsPasseCompose;

public class TempsParserPasseCompose extends ATempsParser {

	public TempsParserPasseCompose(ATempsParser suivant) {
		super(suivant);
	}

	@Override
	protected ATemps instancierTemps(ETemps temps) {
		return new TempsPasseCompose(temps);
	}

}
