package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;
import fr.fiegel.conjugueur.verbe.VerbeTroisiemeGrCoudre;

public class VerbeParserTroisiemeGrCoudre extends AVerbeParser {

	public VerbeParserTroisiemeGrCoudre(AVerbeParser suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new VerbeTroisiemeGrCoudre(infinitif);
	}

}
