package fr.fiegel.conjugueur.parser.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.temps.ATemps;
import fr.fiegel.conjugueur.temps.TempsFutur;

public class TempsParserFutur extends ATempsParser {

	public TempsParserFutur(ATempsParser suivant) {
		super(suivant);
	}

	@Override
	protected ATemps instancierTemps(ETemps temps) {
		return new TempsFutur(temps);
	}

}
