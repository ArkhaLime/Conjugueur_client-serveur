package fr.fiegel.conjugueur.client.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import fr.fiegel.conjugueur.commun.Constantes;
import fr.fiegel.conjugueur.commun.enums.ETemps;

public class VueConjugueur extends JFrame {
	
	private static final long serialVersionUID = 7182368510840407411L;
	private static String nomFenetre = "Conjugueur";
	private VueControleur ctrl;
	private JTextField txtAdrServeur;
	private JTextField txtPortServeur;
	private JTextField txtInfinitif;
	private JComboBox<Object> cboTemps;
	private ColorPane colorPane;
	private JPanel pnlEtatServeur;
	private JButton btnConnexion;
	private JButton btnValider;

	public VueConjugueur(VueControleur ctrl) throws HeadlessException {
		super(nomFenetre);
		setPreferredSize(new Dimension(600, 300));
		setMinimumSize(new Dimension(500, 300));
		this.ctrl=ctrl;
		addWindowListener(ctrl);
		creationComposants();
		enablePartieConjuguaison(false);
		setStatutServeurKo();
		pack();
	}
	
	public boolean verifChampsConnexion(){
		boolean verifOk = true;
		String msg ="";
		
		if(txtAdrServeur.getText().equals("") || txtAdrServeur.getText()==null){
			//msg+= "L'adresse du serveur doit être renseignée\n";
			//verifOk=false;
			txtAdrServeur.setText("localhost");
		}
		if(txtPortServeur.getText().equals("") || txtPortServeur.getText() ==null){
			msg+="Le port utilisé sera le port "+Constantes.PORT_SERVEUR+"\n";
			txtPortServeur.setText(String.valueOf(Constantes.PORT_SERVEUR));
		}else{
			try{
				int port = Integer.parseInt(txtPortServeur.getText());
				if(port<0 || port > 65535){
					msg+="Le port doit être compris entre 0 et 65535 inclus\n";
				}
			}catch(Exception ex){
				msg+="Le port doit être un nombre entier (par exemple: "+Constantes.PORT_SERVEUR+")\n";
				verifOk=false;
			}			
		}
		
		if(!verifOk){
			JOptionPane.showMessageDialog(this, msg, "Données incorrectes - Serveur", JOptionPane.WARNING_MESSAGE);
		}
		
		return verifOk;
	}
	
	public boolean verifChampsVerbe(){
		boolean verifOk = true;
		String msg ="";
		
		if(txtInfinitif.getText().equals("") || txtInfinitif.getText()==null){
			msg+= "Un verbe à l'infinitif doit être renseigné\n";
			verifOk=false;
		}
		if(txtPortServeur.getText().equals("") || txtPortServeur.getText() ==null){
			msg+="Le temps utilisé sera le "+ETemps.PRESENT.getIntitule()+"\n";
			cboTemps.setSelectedItem(ETemps.PRESENT.getIntitule());
		}
		
		if(!verifOk){
			JOptionPane.showMessageDialog(this, msg, "Données incorrectes - Verbe", JOptionPane.WARNING_MESSAGE);
		}
		
		return verifOk;
	}
	
	public String getAdresseServeur(){
		if(txtAdrServeur.getText().equals("")){
			return "localhost";
		}
		return txtAdrServeur.getText();
	}
	
	public int getPortServeur(){
		int port=Constantes.PORT_SERVEUR;
		try{
			port = Integer.parseInt(txtPortServeur.getText());
		}catch(Exception ex){
			
		}	
		return port;
	}
	
	public String getVerbeInfinitif(){
		return txtInfinitif.getText();
	}
	
	public void effacerInfinitif(){
		txtInfinitif.setText("");
	}
	
	public ETemps getTemps(){
		return ETemps.getTempsParNom(cboTemps.getSelectedItem().toString());
	}
	
	public void ecrireSucces(String msg){
		colorPane.append(Color.GREEN, msg);
	}
	
	public void ecrireTexte(String msg){
		colorPane.append(Color.BLACK, msg);
	}
	
	public void ecrireErreur(String msg){
		colorPane.append(Color.RED, msg);
	}
	
	
	public void setStatutServeurOk(){
		pnlEtatServeur.setBackground(Color.GREEN);
	}
	
	public void setStatutServeurEnCours(){
		pnlEtatServeur.setBackground(Color.ORANGE);
	}
	
	public void setStatutServeurKo(){
		pnlEtatServeur.setBackground(Color.RED);
	}
	
	public void enablePartieServeur(boolean enable){
		txtAdrServeur.setEnabled(enable);
		txtPortServeur.setEnabled(enable);
		btnConnexion.setEnabled(enable);
	}
	
	public void enablePartieConjuguaison(boolean enable){
		txtInfinitif.setEnabled(enable);
		cboTemps.setEnabled(enable);
		btnValider.setEnabled(enable);
	}
	
	private void creationComposants(){
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlHaut = new JPanel();
		pnlHaut.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		getContentPane().add(pnlHaut, BorderLayout.NORTH);
		pnlHaut.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JLabel lblAdrServeur = new JLabel("Adresse serveur");
		lblAdrServeur.setPreferredSize(new Dimension(80, 14));
		pnlHaut.add(lblAdrServeur);
		
		txtAdrServeur = new JTextField();
		txtAdrServeur.setMinimumSize(new Dimension(80, 20));
		txtAdrServeur.setPreferredSize(new Dimension(80, 20));
		pnlHaut.add(txtAdrServeur);
		txtAdrServeur.setColumns(10);
		
		JLabel lblPortServeur = new JLabel("Port serveur");
		pnlHaut.add(lblPortServeur);
		
		txtPortServeur = new JTextField();
		txtPortServeur.setPreferredSize(new Dimension(80, 20));
		txtPortServeur.setMinimumSize(new Dimension(80, 20));
		pnlHaut.add(txtPortServeur);
		txtPortServeur.setColumns(10);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(ctrl);
		btnConnexion.setActionCommand("connexion");
		pnlHaut.add(btnConnexion);
		
		pnlEtatServeur = new JPanel();
		pnlEtatServeur.setPreferredSize(new Dimension(40, 20));
		pnlEtatServeur.setMinimumSize(new Dimension(20, 20));
		pnlHaut.add(pnlEtatServeur);
		
		JPanel pnlCentre = new JPanel();
		getContentPane().add(pnlCentre, BorderLayout.CENTER);
		pnlCentre.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		pnlCentre.add(panel, BorderLayout.NORTH);
		
		JLabel lblVerbeLinfinitif = new JLabel("Verbe à l'infinitif");
		lblVerbeLinfinitif.setPreferredSize(new Dimension(80, 14));
		panel.add(lblVerbeLinfinitif);
		
		txtInfinitif = new JTextField();
		txtInfinitif.setPreferredSize(new Dimension(80, 20));
		txtInfinitif.setMinimumSize(new Dimension(80, 20));
		panel.add(txtInfinitif);
		txtInfinitif.setColumns(10);
		
		JLabel lblTemps = new JLabel("Temps");
		lblTemps.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTemps.setPreferredSize(new Dimension(60, 14));
		panel.add(lblTemps);
		
		cboTemps = new JComboBox<Object>();
		cboTemps.setModel(new DefaultComboBoxModel<Object>(ETemps.getArrayTemps()));
		cboTemps.setMinimumSize(new Dimension(80, 20));
		cboTemps.setPreferredSize(new Dimension(80, 20));
		panel.add(cboTemps);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(ctrl);
		btnValider.setActionCommand("valider");
		panel.add(btnValider);
		
		JScrollPane scrollPane = new JScrollPane();
		pnlCentre.add(scrollPane, BorderLayout.CENTER);
		
		colorPane = new ColorPane();
		colorPane.setFocusable(false);
		colorPane.setDisabledTextColor(Color.BLACK);
		scrollPane.setViewportView(colorPane);
	}



}
