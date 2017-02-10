package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;
import fr.fiegel.conjugueur.verbe.VerbePremierGrGer;

public class VerbeParserPremierGrGer extends AVerbeParser {

	public VerbeParserPremierGrGer(AVerbeParser suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new VerbePremierGrGer(infinitif);
	}

}
