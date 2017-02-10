package fr.fiegel.conjugueur.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import fr.fiegel.conjugueur.commun.enums.ELog;
import fr.fiegel.conjugueur.commun.enums.EMsgType;
import fr.fiegel.conjugueur.commun.logger.Logger;
import fr.fiegel.conjugueur.commun.messages.MessageClient;
import fr.fiegel.conjugueur.commun.messages.MessageServeur;
import fr.fiegel.conjugueur.commun.messages.MsgUtils;
import fr.fiegel.conjugueur.parser.temps.ATempsParser;
import fr.fiegel.conjugueur.parser.temps.TempsParserFutur;
import fr.fiegel.conjugueur.parser.temps.TempsParserParticipePasse;
import fr.fiegel.conjugueur.parser.temps.TempsParserParticipePresent;
import fr.fiegel.conjugueur.parser.temps.TempsParserPasseCompose;
import fr.fiegel.conjugueur.parser.temps.TempsParserPresent;
import fr.fiegel.conjugueur.parser.verbe.AVerbeParser;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserAvoir;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserDeuxiemeGr;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserEtre;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserPremierGr;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserPremierGrCer;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserPremierGrGer;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserTroisiemeGrAitre;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserTroisiemeGrAller;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserTroisiemeGrCoudre;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserTroisiemeGrEttre;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserTroisiemeGrIndre;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserTroisiemeGrMoudre;
import fr.fiegel.conjugueur.parser.verbe.VerbeParserTroisiemeGrSoudre;
import fr.fiegel.conjugueur.temps.ATemps;
import fr.fiegel.conjugueur.verbe.AVerbe;

public class ThreadClient implements Runnable {

	private Socket socCom;
	private boolean quitte = false;
	private Logger log;
	private static int compteur=0;
	private int numClient;
	private String nomClasse;

	public ThreadClient(Socket socCom) {
		log = Logger.get();
		this.socCom = socCom;
		this.numClient=++compteur;
		this.nomClasse=this.getClass().getSimpleName()+" "+numClient;
		log.print(nomClasse, ELog.INFO, "Création thread");
	}

	@Override
	public void run() {
		AVerbeParser parserV = createVerbeParser();
		log.print(nomClasse, ELog.DEBUG	, "VerbeParser créé");
		ATempsParser parserT = createTempsParser();
		log.print(nomClasse, ELog.DEBUG	, "TempsParser créé");
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		try {
			in = new ObjectInputStream(socCom.getInputStream());
			log.print(nomClasse, ELog.DEBUG	, "Input récupéré");
			out = new ObjectOutputStream(socCom.getOutputStream());
			log.print(nomClasse, ELog.DEBUG	, "Output récupéré");
			MessageClient msgIn=null;
			MessageServeur msgOut=null;
			String msg="";
			EMsgType type =null;
			while(!quitte){
				msg="";
				type=null;
				msgOut=null;
				log.print(nomClasse, ELog.DEBUG	, "Attente d'un message");
				msgIn = (MessageClient)in.readObject();
				log.print(nomClasse, ELog.DEBUG, msgIn.toString());
				
				//vérification si ce n'est pas un message pour fermer la connexion
				if(MsgUtils.quitter(msgIn.getMessage())){
					log.print(nomClasse, ELog.INFO, "Demande de déconnexion du client");
					quitte=true;
				}
				
				if(!quitte){
					AVerbe verbe = parserV.obtenirVerbe(msgIn.getMessage());
					if(verbe!=null){
						log.print(nomClasse, ELog.DEBUG, "Le verbe '"+msgIn.getMessage()+"' a été trouvé");
						//un verbe a pu être créé
						ATemps temps = parserT.obtenirTemps(msgIn.getTemps());
						if(temps!=null){
							log.print(nomClasse, ELog.DEBUG, "Le temps '"+msgIn.getStrTemps()+"' a été trouvé");
							//un temps a pu être créé
							msg = temps.conjugue(verbe);
							type=EMsgType.SUCCES;
						}else{
							log.print(nomClasse, ELog.ERROR, "Le temps '"+msgIn.getStrTemps()+"' n'a pas été trouvé");
							//le temps donné ne correspond à rien
							msg = "Le temps '"+msgIn.getTemps().name()+"' n'est pas reconnu!";
							type = EMsgType.ERREUR;
						}
					}else{
						log.print(nomClasse, ELog.ERROR, "Le temps '"+msgIn.getStrTemps()+"' n'a pas été trouvé");
						//le verbe donné ne correspond à rien
						msg =  "Le verbe '"+msgIn.getMessage()+"' n'est pas reconnu!\n"+msg;
						type=EMsgType.ERREUR;
					}
					msgOut = new MessageServeur(type, msg);
					log.print(nomClasse, ELog.DEBUG, msgOut.toString());
					out.writeObject(msgOut);
					out.flush();
				}
				
			}

		} catch (SocketException e) {
			log.print(nomClasse, ELog.ERROR, "Perte du client");
			e.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			log.print(nomClasse, ELog.INFO, "Fin du thread");
			try {
				if(out!=null)out.close();
				if(in!=null)in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public AVerbeParser createVerbeParser() {
		AVerbeParser parser = new VerbeParserTroisiemeGrCoudre(null);
		parser = new VerbeParserTroisiemeGrMoudre(parser);
		parser = new VerbeParserTroisiemeGrSoudre(parser);
		parser = new VerbeParserTroisiemeGrIndre(parser);
		parser = new VerbeParserTroisiemeGrEttre(parser);
		parser = new VerbeParserTroisiemeGrAitre(parser);
		parser = new VerbeParserDeuxiemeGr(parser);
		parser = new VerbeParserPremierGr(parser);
		parser = new VerbeParserPremierGrCer(parser);
		parser = new VerbeParserPremierGrGer(parser);
		parser = new VerbeParserTroisiemeGrAller(parser);
		parser = new VerbeParserEtre(parser);
		parser = new VerbeParserAvoir(parser);
		return parser;
	}
	
	public ATempsParser createTempsParser(){
		ATempsParser parser = new TempsParserParticipePasse(null);
		parser = new TempsParserParticipePresent(parser);
		parser = new TempsParserPasseCompose(parser);
		parser = new TempsParserFutur(parser);
		parser = new TempsParserPresent(parser);
		return parser;
	}

}
