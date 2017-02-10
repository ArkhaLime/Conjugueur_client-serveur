package fr.fiegel.conjugueur.commun.messages;

import java.util.Arrays;

public class MsgUtils {

	private static String[] quitter = {"/quitter","/quit","/exit"};
	private static String[] commandes = {"/commandes","/help"};
	
	public static boolean quitter(String msg){
		return Arrays.asList(quitter).contains(msg.toLowerCase());
	}
	
	public static boolean commande(String msg){
		return Arrays.asList(commandes).contains(msg.toLowerCase());
	}
	
}
