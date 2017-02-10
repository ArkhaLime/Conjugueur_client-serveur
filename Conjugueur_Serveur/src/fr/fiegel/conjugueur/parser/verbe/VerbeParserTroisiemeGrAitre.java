package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;
import fr.fiegel.conjugueur.verbe.VerbeTroisiemeGrAitre;

public class VerbeParserTroisiemeGrAitre extends AVerbeParser {

	public VerbeParserTroisiemeGrAitre(AVerbeParser suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AVerbe instancierVerbe(String infinitif) {
		return new VerbeTroisiemeGrAitre(infinitif);
	}

}
