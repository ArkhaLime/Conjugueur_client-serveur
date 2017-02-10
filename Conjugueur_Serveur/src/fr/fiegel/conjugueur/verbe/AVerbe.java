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
		return getPremierePers(auxiliaire.termPresent1PS())+" "+radical+termPasseComposePS();
	}
	
	public String conjuguePasseCompose2PS(){
		return "Tu "+auxiliaire.termPresent2PS()+" "+radical+termPasseComposePS();
	}
	
	public String conjuguePasseCompose3PS(){
		return "Il "+auxiliaire.termPresent3PS()+" "+radical+termPasseComposePS();
	}
	
	public String conjuguePasseCompose1PP(){
		return "Nous "+auxiliaire.termPresent1PP()+" "+radical+termPasseComposePP();
	}
	
	public String conjuguePasseCompose2PP(){
		return "Vous "+auxiliaire.termPresent2PP()+" "+radical+termPasseComposePP();
	}
	
	public String conjuguePasseCompose3PP(){
		return "Ils "+auxiliaire.termPresent3PP()+" "+radical+termPasseComposePP();
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
	
	public String conjugueParticipePresent(){
		return "En "+radical+termPresent1PP().replace("ons", "ant")+"\n";
	}
	
	public  String conjugueParticipePasse(){
		return radical+termPasseComposePS()+"\n";
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
	public abstract String termPasseComposePS();
	public String termPasseComposePP(){
		return termPasseComposePS();
	}
	
}
