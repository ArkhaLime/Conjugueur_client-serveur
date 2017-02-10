package fr.fiegel.conjugueur.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import fr.fiegel.conjugueur.commun.enums.EMsgType;
import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.commun.messages.MessageClient;
import fr.fiegel.conjugueur.commun.messages.MessageServeur;
import fr.fiegel.conjugueur.commun.messages.MsgUtils;

public class VueControleur implements ActionListener,WindowListener {

	private VueConjugueur vue;
	Socket emission;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	public void setVue(VueConjugueur vue){
		this.vue=vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String aCommand = e.getActionCommand();
		if(aCommand.equalsIgnoreCase("connexion")){
			connexionServeur();
		}else if(aCommand.equalsIgnoreCase("valider")){
			dialogueServeur();
		}
	}
	
	private void connexionServeur(){
		if(vue.verifChampsConnexion()){
			vue.setStatutServeurEnCours();
			vue.enablePartieServeur(false);
			String adrServeur = vue.getAdresseServeur();
			int port = vue.getPortServeur();
			try {
				emission = new Socket(adrServeur, port);
				vue.ecrireSucces("La connexion au serveur a réussie\n\n");
				out = new ObjectOutputStream(emission.getOutputStream());
				in = new ObjectInputStream( emission.getInputStream());
				vue.enablePartieConjuguaison(true);
				vue.setStatutServeurOk();
			} catch (UnknownHostException e) {
				exceptionConnexionServeur("Le serveur à l'adresse '"+adrServeur+":"+port+"' est introuvable!\n\n",e);
			}catch(ConnectException e){
				exceptionConnexionServeur("La connexion a été refusée!\n",e);
			} catch (IOException e) {
				exceptionConnexionServeur(e.getLocalizedMessage()+"\n",e);
			}
		}
	}
	
	private void exceptionConnexionServeur(String msg,Exception e){
		vue.ecrireErreur(msg);
		vue.enablePartieServeur(true);
		vue.setStatutServeurKo();
		e.printStackTrace();
	}
	
	private void dialogueServeur(){
		if(vue.verifChampsVerbe()){
			vue.enablePartieConjuguaison(false);
			String infinitif = vue.getVerbeInfinitif();
			ETemps eTps = vue.getTemps();
			boolean envoiServeur = true;
			
			try {
				if(MsgUtils.quitter(infinitif)){
					vue.ecrireErreur("Fin de connexion demandée par le client\n");
//					MessageClient obj = new MessageClient(infinitif, ETemps.PRESENT);
//					out.writeObject(obj);
//					out.flush();
//					return; //appeler méthode pour quitter appli
					arreterClient();
				}
				if(MsgUtils.commande(infinitif)){
					vue.ecrireTexte(afficheCommandes());
					vue.effacerInfinitif();
					envoiServeur=false;
				}
				if(envoiServeur){	
					vue.setStatutServeurEnCours();
					MessageClient obj = new MessageClient(infinitif, eTps);
					out.writeObject(obj);
					out.flush();
					MessageServeur retour = (MessageServeur)in.readObject();
					if (retour == null) {
						vue.ecrireErreur("Connexion serveur perdue\n");
						vue.enablePartieServeur(true);
						vue.setStatutServeurKo();
						return;
					}
					if(retour.getType()==EMsgType.SUCCES){
						vue.ecrireTexte("-- "+infinitif+" ("+eTps.getIntitule()+") --\n"+ retour.getMessage()+"\n");
					}else{
						vue.ecrireErreur(retour.getMessage()+"\n");
					}
				}
				vue.setStatutServeurOk();
				vue.enablePartieConjuguaison(true);
			} catch (ClassNotFoundException e) {
				vue.ecrireErreur(e.getLocalizedMessage());
				vue.enablePartieConjuguaison(true);
				e.printStackTrace();
			} catch (SocketException e) {
				vue.ecrireErreur("Connexion au serveur perdue!\n\n");
				vue.setStatutServeurKo();
				vue.enablePartieServeur(true);
			}catch (IOException e) {
				vue.enablePartieConjuguaison(true);
				vue.setStatutServeurEnCours();
				e.printStackTrace();
			}
		}
	}
	
	private void arreterClient(){
		vue.setStatutServeurKo();
		//vue.setVisible(false);
		try {
			if(out!=null){
				MessageClient obj = new MessageClient("/quit", ETemps.PRESENT);
				out.writeObject(obj);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(out != null)out.close();
				if(in!=null)in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		vue.dispose();
		System.exit(0);
	}
	
	private String afficheCommandes(){
		String res="";
		res+="\n==========================\n";
		res+=" /commandes";
		res+="\tPour voir la liste des commandes utilisables\n";
		res+=" /quitter";
		res+="\tPour fermer le client\n";
		res+="==========================\n\n";
		return res;
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		arreterClient();
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

}
