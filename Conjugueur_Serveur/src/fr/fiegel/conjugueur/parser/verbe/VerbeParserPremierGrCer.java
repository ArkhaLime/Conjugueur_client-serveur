package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;
import fr.fiegel.conjugueur.verbe.VerbePremierGrCer;

public class VerbeParserPremierGrCer extends AVerbeParser {

	public VerbeParserPremierGrCer(AVerbeParser suivant) {
		super(suivant);
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new VerbePremierGrCer(infinitif);
	}

}
