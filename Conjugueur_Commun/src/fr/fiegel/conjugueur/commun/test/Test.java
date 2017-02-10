package fr.fiegel.conjugueur.commun.test;

import fr.fiegel.conjugueur.commun.enums.ELog;
import fr.fiegel.conjugueur.commun.enums.EMsgType;
import fr.fiegel.conjugueur.commun.logger.Logger;
import fr.fiegel.conjugueur.commun.messages.MessageServeur;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger.create("");
		Logger log = Logger.get();
		MessageServeur m1 = new MessageServeur(EMsgType.ERREUR, "Une erreur est survenue");
		System.out.println(m1.getType());
		System.out.println(m1.getMessage());
		System.out.println(m1);
		log.print(ELog.INFO, m1.getStrType());
		log.print(m1, ELog.WARNING, m1.getMessage());
		log.print("Truc", ELog.ERROR, m1.toString());
		
	}

}
