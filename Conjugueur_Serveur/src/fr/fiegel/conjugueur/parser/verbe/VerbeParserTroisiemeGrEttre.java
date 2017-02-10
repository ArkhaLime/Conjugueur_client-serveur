package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;
import fr.fiegel.conjugueur.verbe.VerbeTroisiemeGrEttre;

public class VerbeParserTroisiemeGrEttre extends AVerbeParser {

	public VerbeParserTroisiemeGrEttre(AVerbeParser suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new VerbeTroisiemeGrEttre(infinitif);
	}

}
