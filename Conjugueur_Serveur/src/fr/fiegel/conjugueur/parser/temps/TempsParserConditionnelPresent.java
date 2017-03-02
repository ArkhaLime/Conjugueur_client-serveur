package fr.fiegel.conjugueur.parser.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.temps.ATemps;
import fr.fiegel.conjugueur.temps.TempsConditionnelPresent;

public class TempsParserConditionnelPresent extends ATempsParser {

	public TempsParserConditionnelPresent(ATempsParser suivant) {
		super(suivant);
	}

	@Override
	protected ATemps instancierTemps(ETemps temps) {
		return new TempsConditionnelPresent(temps);
	}

}
