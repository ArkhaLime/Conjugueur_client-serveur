package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;
import fr.fiegel.conjugueur.verbe.VerbeTroisiemeGrAller;

public class VerbeParserTroisiemeGrAller extends AVerbeParser {

	public VerbeParserTroisiemeGrAller(AVerbeParser suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new VerbeTroisiemeGrAller(infinitif);
	}

}
