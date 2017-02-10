package fr.fiegel.conjugueur.verbe;

public class VerbeTroisiemeGrAller extends AVerbe {

	public VerbeTroisiemeGrAller() {
		this("aller");
		
	}
	
	public VerbeTroisiemeGrAller(String infinitif) {
		super(infinitif);
		this.auxiliaire=new Etre();
	}

	@Override
	public String termInfinitif() {
		// TODO Auto-generated method stub
		return "aller";
	}

	@Override
	public String termPresent1PS() {
		// TODO Auto-generated method stub
		return "vais";
	}

	@Override
	public String termPresent2PS() {
		// TODO Auto-generated method stub
		return "vas";
	}

	@Override
	public String termPresent3PS() {
		// TODO Auto-generated method stub
		return "va";
	}

	@Override
	public String termPresent1PP() {
		// TODO Auto-generated method stub
		return "allons";
	}

	@Override
	public String termPresent2PP() {
		// TODO Auto-generated method stub
		return "allez";
	}

	@Override
	public String termPresent3PP() {
		// TODO Auto-generated method stub
		return "vont";
	}

	@Override
	public String termFutur1PS() {
		// TODO Auto-generated method stub
		return "irai";
	}

	@Override
	public String termFutur2PS() {
		// TODO Auto-generated method stub
		return "iras";
	}

	@Override
	public String termFutur3PS() {
		// TODO Auto-generated method stub
		return "ira";
	}

	@Override
	public String termFutur1PP() {
		// TODO Auto-generated method stub
		return "irons";
	}

	@Override
	public String termFutur2PP() {
		// TODO Auto-generated method stub
		return "irez";
	}

	@Override
	public String termFutur3PP() {
		// TODO Auto-generated method stub
		return "iront";
	}

	@Override
	public String termPasseComposePS() {
		// TODO Auto-generated method stub
		return "allé";
	}
	
	@Override
	public String termPasseComposePP() {
		// TODO Auto-generated method stub
		return "allés";
	}

}
