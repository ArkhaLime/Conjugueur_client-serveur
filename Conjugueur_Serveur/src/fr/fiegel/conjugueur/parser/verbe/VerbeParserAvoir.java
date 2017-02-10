package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.Avoir;
import fr.fiegel.conjugueur.verbe.AVerbe;

public class VerbeParserAvoir extends AVerbeParser {

	public VerbeParserAvoir(AVerbeParser suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new Avoir(infinitif);
	}

}
