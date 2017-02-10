package fr.fiegel.conjugueur.client.launcher;

import fr.fiegel.conjugueur.client.ui.VueConjugueur;
import fr.fiegel.conjugueur.client.ui.VueControleur;

public class Launcher {

	public static void main(String[] args) {
		VueControleur ctrl = new VueControleur();
		VueConjugueur vue = new VueConjugueur(ctrl);
		ctrl.setVue(vue);
		vue.setVisible(true);
	}
}
