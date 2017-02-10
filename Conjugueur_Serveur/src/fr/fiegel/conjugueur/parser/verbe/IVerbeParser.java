package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;

public interface IVerbeParser {
	
	/**
	 * 
	 * @param infinitif
	 * @return AVerbe ou null si l'infinitif n'est pas reconnu comme un verbe
	 */
	public AVerbe obtenirVerbe(String infinitif);
	
}
