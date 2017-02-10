package fr.fiegel.conjugueur.client.console;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import fr.fiegel.conjugueur.commun.enums.EMsgType;
import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.commun.messages.MessageClient;
import fr.fiegel.conjugueur.commun.messages.MessageServeur;
import fr.fiegel.conjugueur.commun.messages.MsgUtils;

public class ConjugueurClientCon {

	public static void main(String[] args) {
		if (args.length == 2) {
			try {
				Scanner clavier = new Scanner(System.in);
				Socket emission = new Socket(args[0], Integer.parseInt(args[1]));
				System.out.println("Socket : " + emission);
				System.out.println("Port de connexion : " + emission.getLocalPort());
				
				ObjectOutputStream out = new ObjectOutputStream(emission.getOutputStream());
				System.out.println("Output récupéré");
				ObjectInputStream in = new ObjectInputStream( emission.getInputStream());
				System.out.println("Input récupéré");

				System.out.println("début de la boucle");
				boolean envoiServeur=true;
				while (true) {
					try {
						envoiServeur=true;
						
						//demande du verbe à l'infinitif
						System.out.print("\nEcrivez un verbe à l'infinitif: ");
						String msg = clavier.nextLine();
						while(msg.equals("")){
							msg=clavier.nextLine();
						}
						
						if(MsgUtils.quitter(msg)){
							System.out.println("Arrêt du client par l'utilisateur");
							MessageClient obj = new MessageClient(msg, ETemps.PRESENT);
							out.writeObject(obj);
							out.flush();
							break;
						}
						if(MsgUtils.commande(msg)){
							afficheCommandes();
							envoiServeur=false;
						}
						if(envoiServeur){
							//demande du temps
							String tps="";
							ETemps eTps = null;
							do{
								System.out.print("\nEcrivez le nom du temps: ");
								tps=clavier.nextLine();
								eTps= ETemps.getTempsParNom(tps);
							}while (eTps ==null);
							
							MessageClient obj = new MessageClient(msg, eTps);
							System.out.println(obj);
							out.writeObject(obj);
							out.flush();
							MessageServeur retour = (MessageServeur)in.readObject();
							if (retour == null) {
								System.out.println("Connexion serveur perdue");
								break;
							}
							if(retour.getType()==EMsgType.SUCCES){
								System.out.println(retour.getMessage());
							}else{
								System.err.println(retour.getMessage());
							}
						}
						
					} catch (SocketException e) {
						System.out.println("Connexion serveur perdue");
						break;
					}
				}

				out.close();
				in.close();
				emission.close();
				clavier.close();

			} catch (NumberFormatException e) {
				System.out.println("Erreur avec le port fourni");
				e.printStackTrace();
			} catch (UnknownHostException e) {
				System.out.println("Impossible de trouver le serveur. Réessayer plus tard");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Impossible de se connecter au serveur. Réessayer plus tard");
				e.printStackTrace();
			}catch(Exception e){
				System.out.println("Exception : " + e.getMessage());
			}
		} else {
			System.out.println("Il manque des arguments");
			System.out.println("Mettre l'adresse ip et le port du serveur");
		}
	}
	
	private static void afficheCommandes(){
		System.out.println("==========================\n");
		System.out.println(" /commandes");
		System.out.println("\tPour voir la liste des commandes utilisables\n");
		System.out.println(" /quitter");
		System.out.println("\tPour fermer le client\n");
		System.out.println("==========================\n");
	}

}
