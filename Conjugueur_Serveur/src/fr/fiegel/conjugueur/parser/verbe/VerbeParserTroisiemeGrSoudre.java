package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;
import fr.fiegel.conjugueur.verbe.VerbeTroisiemeGrSoudre;

public class VerbeParserTroisiemeGrSoudre extends AVerbeParser {

	public VerbeParserTroisiemeGrSoudre(AVerbeParser suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new VerbeTroisiemeGrSoudre(infinitif);
	}

}
