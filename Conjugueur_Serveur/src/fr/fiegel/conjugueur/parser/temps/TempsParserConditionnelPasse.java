package fr.fiegel.conjugueur.parser.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.temps.ATemps;
import fr.fiegel.conjugueur.temps.TempsConditionnelPasse;

public class TempsParserConditionnelPasse extends ATempsParser {

	public TempsParserConditionnelPasse(ATempsParser suivant) {
		super(suivant);
	}

	@Override
	protected ATemps instancierTemps(ETemps temps) {
		return new TempsConditionnelPasse(temps);
	}

}
