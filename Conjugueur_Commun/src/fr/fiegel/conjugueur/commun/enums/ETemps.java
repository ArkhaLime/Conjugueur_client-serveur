package fr.fiegel.conjugueur.commun.enums;

import java.util.ArrayList;
import java.util.List;

public enum ETemps {

	PRESENT("Présent"),
	FUTUR("Futur"),
	PASSE_COMPOSE("Passé composé"),
	PARTICIPE_PRESENT("Participe présent"),
	PARTICIPE_PASSE("Participe passé"),
	CONDITIONNEL_PRESENT("Conditionnel présent"),
	CONDITIONNEL_PASSE("Conditionnel passé");
	
	private String intitule;
	
	private ETemps(String intitule){
		this.intitule=intitule;
	}
	
	public String getIntitule(){
		return intitule;
	}
	
	public static ETemps getTempsParNom(String nom){
		for (ETemps temps : ETemps.values()) {
			if (temps.getIntitule().equalsIgnoreCase(nom) || temps.name().equalsIgnoreCase(nom)) {
				return temps;
			}
		}
		return null;
	}
	
	public static List<String> getListeTemps(){
		List<String> liste = new ArrayList<String>();
		for (ETemps temps : ETemps.values()) {
			liste.add(temps.intitule);
		}
		return liste;
	}
	
	public static Object[] getArrayTemps(){
		return getListeTemps().toArray();
	}
	
}
