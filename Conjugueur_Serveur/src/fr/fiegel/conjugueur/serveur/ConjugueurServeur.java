package fr.fiegel.conjugueur.serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import fr.fiegel.conjugueur.commun.Constantes;
import fr.fiegel.conjugueur.commun.enums.ELog;
import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.commun.logger.Logger;

public class ConjugueurServeur {

	public static void main(String[] args) {
		
		ServerSocket serveur = null;
		Logger.create("Serveur");
		Logger log = Logger.get();
		//log.setPrintDebug(true);
		try {
			int port = Constantes.PORT_SERVEUR;
			if (args.length >= 1) {
				port = Integer.parseInt(args[0]);
			}
			serveur = new ServerSocket(port);
			log.print(ELog.INFO, "Le serveur reçoit sur le port "+serveur.getLocalPort());
			log.print(ELog.INFO, "> Serveur prêt");
			log.print(ELog.INFO, "Version Conjugueur_Commun: " + Constantes.LIB_VERSION);
			log.print(ELog.INFO, "Temps disponibles:");
			afficherTemps();
			
			while (true) {
				try {
					Socket socCom = serveur.accept();
//					Thread fils = new Thread(new ThreadClient(socCom));
					Thread fils = new ThreadClient(socCom);
					fils.start();
				} catch (IOException e) {
					log.print(ELog.ERROR, "Erreur avec un fils\n\t"+e.getLocalizedMessage());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

			
//			serveur.close();
//		} else {
//			System.out.println("Il manque le port du serveur");
//		}

	}
	
	private static void afficherTemps(){
		Object[] temps = ETemps.getArrayTemps();
		for(int i=0;i<temps.length;i++){
			System.out.println(temps[i]);
		}
		System.out.print("\n");
	}

}
