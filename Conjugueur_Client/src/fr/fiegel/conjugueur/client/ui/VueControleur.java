package fr.fiegel.conjugueur.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import fr.fiegel.conjugueur.commun.enums.EMsgType;
import fr.fiegel.conjugueur.commun.enums.ETemps;
import fr.fiegel.conjugueur.commun.messages.MessageClient;
import fr.fiegel.conjugueur.commun.messages.MessageServeur;
import fr.fiegel.conjugueur.commun.messages.MsgUtils;

public class VueControleur implements ActionListener,WindowListener,KeyListener {

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
				vue.ecrireSucces("La connexion au serveur a réussie\n");
				out = new ObjectOutputStream(emission.getOutputStream());
				in = new ObjectInputStream( emission.getInputStream());
				vue.enablePartieConjuguaison(true);
				vue.setStatutServeurOk();
			} catch (UnknownHostException e) {
				exceptionConnexionServeur("Le serveur à l'adresse '"+adrServeur+":"+port+"' est introuvable!\n",e);
			}catch(ConnectException e){
				exceptionConnexionServeur("La connexion a été refusée!\n",e);
			} catch (IOException e) {
				exceptionConnexionServeur(e.getLocalizedMessage(),e);
			}
		}
	}
	
	private void exceptionConnexionServeur(String msg,Exception e){
		vue.ecrireErreur(msg);
		vue.enablePartieServeur(true);
		vue.setStatutServeurKo();
		JOptionPane.showMessageDialog(vue, msg, "Erreur connexion", JOptionPane.ERROR_MESSAGE);
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
					vue.ecrireErreur("Fin de connexion demandée par le client");
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
//						vue.ecrireErreur("Connexion serveur perdue");
//						vue.enablePartieServeur(true);
//						vue.setStatutServeurKo();
//						out=null;
//						in=null;
						ecrireConnexionPerdue();
						return;
					}
					if(retour.getType()==EMsgType.SUCCES){
						vue.ecrireTexte("-- "+infinitif+" ("+eTps.getIntitule()+") --\n"+ retour.getMessage());
					}else{
						vue.ecrireErreur(retour.getMessage());
						//JOptionPane.showMessageDialog(vue, retour.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
						erreurDialogueMessage(retour.getMessage());
					}
					vue.focusTxtInfintif();
				}
				vue.setStatutServeurOk();
				vue.enablePartieConjuguaison(true);
			} catch (ClassNotFoundException e) {
				vue.ecrireErreur(e.getLocalizedMessage());
				vue.enablePartieConjuguaison(true);
				erreurDialogueMessage(e.getLocalizedMessage());
				e.printStackTrace();
			} catch (SocketException e) {
//				vue.ecrireErreur("Connexion au serveur perdue!\n");
//				vue.setStatutServeurKo();
//				vue.enablePartieServeur(true);
				ecrireConnexionPerdue();
			}catch (IOException e) {
				vue.enablePartieConjuguaison(true);
				vue.setStatutServeurEnCours();
				vue.ecrireErreur(e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
	}
	
	private void erreurDialogueMessage(String msg){
		JOptionPane.showMessageDialog(vue, msg, "Erreur dialogue", JOptionPane.ERROR_MESSAGE);
		vue.focusTxtInfintif();
	}
	
	private void ecrireConnexionPerdue(){
		vue.ecrireErreur("Connexion serveur perdue");
		vue.enablePartieServeur(true);
		vue.setStatutServeurKo();
		erreurDialogueMessage("Connexion serveur perdue");
		out=null;
		in=null;
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
		res+="==========================\n";
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String nomComp = e.getComponent().getName();
		int touche = e.getExtendedKeyCode();
		if(touche==KeyEvent.VK_ENTER){
			if(nomComp.equalsIgnoreCase("txtAdrServeur")){
				vue.focusTxtPortServeur();
				e.consume();
			}
			if(nomComp.equalsIgnoreCase("txtPortServeur") || nomComp.equalsIgnoreCase("btnConnexion")){
				vue.cliqueBtnConnexion();
				e.consume();
			}
			if(nomComp.equalsIgnoreCase("txtInfinitif") || nomComp.equalsIgnoreCase("cboTemps") || nomComp.equalsIgnoreCase("btnValider")){
				vue.cliqueBtnValider();
				e.consume();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
