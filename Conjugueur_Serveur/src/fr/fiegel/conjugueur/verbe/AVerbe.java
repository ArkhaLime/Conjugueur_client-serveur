package fr.fiegel.conjugueur.verbe;

import java.util.Arrays;

public abstract class AVerbe {

	protected String infinitif;
	protected String radical;
	protected AVerbe auxiliaire;
	
	public AVerbe(String infinitif){
		this.infinitif=infinitif.toLowerCase();
		if(!infinitif.endsWith(termInfinitif().toLowerCase())){
			throw new IllegalArgumentException("Le verbe '"+infinitif+"' ne se termine pas par '"+termInfinitif()+"'");
		}
		this.radical=getRadical();
		if(infinitif.equalsIgnoreCase("avoir")){
			this.auxiliaire=this;
		}else{
			this.auxiliaire=new Avoir();
		}
		
	}
	
	public String getRadical(){
		return infinitif.substring(0,infinitif.length()-termInfinitif().length());
	}
	
	private String getPremierePers(String str){
		String[] debut = {"a","e","i","o","u","y"};
		if(Arrays.asList(debut).contains(str.substring(0, 1))){
			return "J'"+str;
		}
		return "Je "+str;
	}
	
	//present
	public String conjuguePresent1PS(){
		return getPremierePers(radical+termPresent1PS());
	}
	
	public String conjuguePresent2PS(){
		return "Tu "+radical+termPresent2PS();
	}
	
	public String conjuguePresent3PS(){
		return "Il "+radical+termPresent3PS();
	}
	
	public String conjuguePresent1PP(){
		return "Nous "+radical+termPresent1PP();
	}
	
	public String conjuguePresent2PP(){
		return "Vous "+radical+termPresent2PP();
	}
	
	public String conjuguePresent3PP(){
		return "Ils "+radical+termPresent3PP();
	}
	
	//futur
	public String conjugueFutur1PS(){
		return getPremierePers(radical+termFutur1PS());
	}
	
	public String conjugueFutur2PS(){
		return "Tu "+radical+termFutur2PS();
	}
	
	public String conjugueFutur3PS(){
		return "Il "+radical+termFutur3PS();
	}
	
	public String conjugueFutur1PP(){
		return "Nous "+radical+termFutur1PP();
	}
	
	public String conjugueFutur2PP(){
		return "Vous "+radical+termFutur2PP();
	}
	
	public String conjugueFutur3PP(){
		return "Ils "+radical+termFutur3PP();
	}
		
	//passé composé
	public String conjuguePasseCompose1PS(){
		return getPremierePers(auxiliaire.termPresent1PS())+" "+radical+termPassePS();
	}
	
	public String conjuguePasseCompose2PS(){
		return "Tu "+auxiliaire.termPresent2PS()+" "+radical+termPassePS();
	}
	
	public String conjuguePasseCompose3PS(){
		return "Il "+auxiliaire.termPresent3PS()+" "+radical+termPassePS();
	}
	
	public String conjuguePasseCompose1PP(){
		return "Nous "+auxiliaire.termPresent1PP()+" "+radical+termPassePP();
	}
	
	public String conjuguePasseCompose2PP(){
		return "Vous "+auxiliaire.termPresent2PP()+" "+radical+termPassePP();
	}
	
	public String conjuguePasseCompose3PP(){
		return "Ils "+auxiliaire.termPresent3PP()+" "+radical+termPassePP();
	}
	
	//conditionnel présent
	public String conjugueCondPresent1PS(){
		return getPremierePers(radical+termCondPresent1PS());
	}
	
	public String conjugueCondPresent2PS(){
		return "Tu "+radical+termCondPresent2PS();
	}
	
	public String conjugueCondPresent3PS(){
		return "Il "+radical+termCondPresent3PS();
	}
	
	public String conjugueCondPresent1PP(){
		return "Nous "+radical+termCondPresent1PP();
	}
	
	public String conjugueCondPresent2PP(){
		return "Vous "+radical+termCondPresent2PP();
	}
	
	public String conjugueCondPresent3PP(){
		return "Ils "+radical+termCondPresent3PP();
	}
	
	//conditionnel passé
	public String conjugueCondPasse1PS(){
		return getPremierePers(auxiliaire.termCondPresent1PS())+" "+radical+termPassePS();
	}
	
	public String conjugueCondPasse2PS(){
		return "Tu "+auxiliaire.termCondPresent2PS()+" "+radical+termPassePS();
	}
	
	public String conjugueCondPasse3PS(){
		return "Il "+auxiliaire.termCondPresent3PS()+" "+radical+termPassePS();
	}
	
	public String conjugueCondPasse1PP(){
		return "Nous "+auxiliaire.termCondPresent1PP()+" "+radical+termPassePP();
	}
	
	public String conjugueCondPasse2PP(){
		return "Vous "+auxiliaire.termCondPresent2PP()+" "+radical+termPassePP();
	}
	
	public String conjugueCondPasse3PP(){
		return "Ils "+auxiliaire.termCondPresent3PP()+" "+radical+termPassePP();
	}
	
	public String conjuguePresent(){
		String res="";
		res+=conjuguePresent1PS()+"\n";
		res+=conjuguePresent2PS()+"\n";
		res+=conjuguePresent3PS()+"\n";
		res+=conjuguePresent1PP()+"\n";
		res+=conjuguePresent2PP()+"\n";
		res+=conjuguePresent3PP()+"\n";
		return res;
	}
	
	public String conjugueFutur(){
		String res="";
		res+=conjugueFutur1PS()+"\n";
		res+=conjugueFutur2PS()+"\n";
		res+=conjugueFutur3PS()+"\n";
		res+=conjugueFutur1PP()+"\n";
		res+=conjugueFutur2PP()+"\n";
		res+=conjugueFutur3PP()+"\n";
		return res;
	}
	
	public String conjuguePasseCompose(){
		String res="";
		res+=conjuguePasseCompose1PS()+"\n";
		res+=conjuguePasseCompose2PS()+"\n";
		res+=conjuguePasseCompose3PS()+"\n";
		res+=conjuguePasseCompose1PP()+"\n";
		res+=conjuguePasseCompose2PP()+"\n";
		res+=conjuguePasseCompose3PP()+"\n";
		return res;
	}
	
	public String conjugueCondPresent(){
		String res="";
		res+=conjugueCondPresent1PS()+"\n";
		res+=conjugueCondPresent2PS()+"\n";
		res+=conjugueCondPresent3PS()+"\n";
		res+=conjugueCondPresent1PP()+"\n";
		res+=conjugueCondPresent2PP()+"\n";
		res+=conjugueCondPresent3PP()+"\n";
		return res;
	}
	
	public String conjugueCondPasse(){
		String res="";
		res+=conjugueCondPasse1PS()+"\n";
		res+=conjugueCondPasse2PS()+"\n";
		res+=conjugueCondPasse3PS()+"\n";
		res+=conjugueCondPasse1PP()+"\n";
		res+=conjugueCondPasse2PP()+"\n";
		res+=conjugueCondPasse3PP()+"\n";
		return res;
	}
	
	public String conjugueParticipePresent(){
		return "En "+radical+termPresent1PP().replace("ons", "ant")+"\n";
	}
	
	public  String conjugueParticipePasse(){
		return radical+termPassePS()+"\n";
	}
	
	//infinitif
	public abstract String termInfinitif();
	
	//present
	public abstract String termPresent1PS();
	public abstract String termPresent2PS();
	public abstract String termPresent3PS();
	public abstract String termPresent1PP();
	public abstract String termPresent2PP();
	public abstract String termPresent3PP();
	
	//futur
	public abstract String termFutur1PS();
	public abstract String termFutur2PS();
	public abstract String termFutur3PS();
	public abstract String termFutur1PP();
	public abstract String termFutur2PP();
	public abstract String termFutur3PP();
	
	//passé composé
	public abstract String termPassePS();
	public String termPassePP(){
		return termPassePS();
	}
	
	//conditionnel présent
	public abstract String termCondPresent1PS();
	public String termCondPresent2PS(){
		return termCondPresent1PS();
	}
	public abstract String termCondPresent3PS();
	public abstract String termCondPresent1PP();
	public abstract String termCondPresent2PP();
	public abstract String termCondPresent3PP();
	
}
