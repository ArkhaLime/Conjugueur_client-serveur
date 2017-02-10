package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;
import fr.fiegel.conjugueur.verbe.VerbePremierGr;

public class VerbeParserPremierGr extends AVerbeParser {

	public VerbeParserPremierGr(AVerbeParser suivant) {
		super(suivant);
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new VerbePremierGr(infinitif);
	}

}
