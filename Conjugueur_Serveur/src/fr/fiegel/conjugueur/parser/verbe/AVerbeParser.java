package fr.fiegel.conjugueur.parser.verbe;

import fr.fiegel.conjugueur.verbe.AVerbe;

public abstract class AVerbeParser implements IVerbeParser {

	protected AVerbeParser suivant;
	
	public AVerbeParser(AVerbeParser suivant) {
		this.suivant=suivant;
	}

	@Override
	public AVerbe obtenirVerbe(String infinitif) {
		
		AVerbe res=trouverVerbe(infinitif);
		
		if(res!=null){
			return res;
		}else{
			if(this.suivant!=null){
				return this.suivant.obtenirVerbe(infinitif);
			}else{
				return null;
			}
		}
	}
	
	/**
	 * Permet de récupérer l'exception que peut lancer <code>instancierVerbe()</code>
	 * @param infinitif
	 * @return Verbe ou null si l'infinitif n'est pas reconnu comme un verbe
	 */
	protected  AVerbe trouverVerbe(String infinitif){
		try{
			return this.instancierVerbe(infinitif);
		}catch(Exception ex){
			return null;
		}
	}
	
	/**
	 * Méthode qui tente d'instancier le bon groupe à partir de l'infinitif
	 * @param infinitif
	 * @return Verbe
	 */
	protected abstract AVerbe instancierVerbe(String infinitif);
	
	@Override
	protected void finalize() throws Throwable {
		if(suivant!=null){
			suivant.finalize();
		}
		super.finalize();
	}
	
}
