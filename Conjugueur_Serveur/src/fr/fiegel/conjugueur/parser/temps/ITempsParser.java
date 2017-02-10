package fr.fiegel.conjugueur.parser.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.temps.ATemps;

public interface ITempsParser {
	
	/**
	 * 
	 * @param infinitif
	 * @return ATemps ou null si le paramètre 'temps' n'est pas reconnu comme un temps
	 */
	public ATemps obtenirTemps(ETemps temps);
	
}
