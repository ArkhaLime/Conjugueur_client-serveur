package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.Etre;
import fr.fiegel.conjugueur.verbe.AVerbe;

public class VerbeParserEtre extends AVerbeParser {

	public VerbeParserEtre(AVerbeParser suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new Etre(infinitif);
	}

}
