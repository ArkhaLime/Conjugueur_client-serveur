package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;
import fr.fiegel.conjugueur.verbe.VerbeDeuxiemeGr;

public class VerbeParserDeuxiemeGr extends AVerbeParser {

	public VerbeParserDeuxiemeGr(AVerbeParser suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new VerbeDeuxiemeGr(infinitif);
	}

}
