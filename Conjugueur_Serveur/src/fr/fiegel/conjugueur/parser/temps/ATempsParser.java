package fr.fiegel.conjugueur.parser.temps;

import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.temps.ATemps;

public abstract class ATempsParser implements ITempsParser {

	protected ATempsParser suivant;
	
	public ATempsParser(ATempsParser suivant) {
		this.suivant=suivant;
	}

	@Override
	public ATemps obtenirTemps(ETemps temps) {
		
		ATemps res=trouverTemps(temps);
		
		if(res!=null){
			return res;
		}else{
			if(this.suivant!=null){
				return this.suivant.obtenirTemps(temps);
			}else{
				return null;
			}
		}
	}
	
	/**
	 * Permet de récupérer l'exception que peut lancer <code>instancierTemps()</code>
	 * @param
	 * @return 
	 */
	protected  ATemps trouverTemps(ETemps temps){
		try{
			return this.instancierTemps(temps);
		}catch(Exception ex){
			return null;
		}
	}
	
	/**
	 * Méthode qui tente d'instancier le bon temps
	 * @param temps
	 * @return ATemps
	 */
	protected abstract ATemps instancierTemps(ETemps temps);
	
	@Override
	protected void finalize() throws Throwable {
		if(suivant!=null){
			suivant.finalize();
		}
		super.finalize();
	}
	

}
