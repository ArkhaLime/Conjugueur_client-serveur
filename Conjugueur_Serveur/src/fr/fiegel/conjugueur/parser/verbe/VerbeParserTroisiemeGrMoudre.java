package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;
import fr.fiegel.conjugueur.verbe.VerbeTroisiemeGrMoudre;

public class VerbeParserTroisiemeGrMoudre extends AVerbeParser {

	public VerbeParserTroisiemeGrMoudre(AVerbeParser suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new VerbeTroisiemeGrMoudre(infinitif);
	}

}
