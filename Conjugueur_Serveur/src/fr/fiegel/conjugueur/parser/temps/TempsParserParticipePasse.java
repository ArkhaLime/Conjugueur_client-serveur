package fr.fiegel.conjugueur.parser.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.temps.ATemps;
import fr.fiegel.conjugueur.temps.TempsParticipePasse;

public class TempsParserParticipePasse extends ATempsParser {

	public TempsParserParticipePasse(ATempsParser suivant) {
		super(suivant);
	}

	@Override
	protected ATemps instancierTemps(ETemps temps) {
		return new TempsParticipePasse(temps);
	}

}
