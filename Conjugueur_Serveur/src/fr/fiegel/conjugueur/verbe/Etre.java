package fr.fiegel.conjugueur.verbe;

public class Etre extends AVerbe {

	public Etre() {
		this("être");
	}
	
	public Etre(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		// TODO Auto-generated method stub
		return "être";
	}

	@Override
	public String termPresent1PS() {
		// TODO Auto-generated method stub
		return "suis";
	}

	@Override
	public String termPresent2PS() {
		// TODO Auto-generated method stub
		return "es";
	}

	@Override
	public String termPresent3PS() {
		// TODO Auto-generated method stub
		return "est";
	}

	@Override
	public String termPresent1PP() {
		// TODO Auto-generated method stub
		return "sommes";
	}

	@Override
	public String termPresent2PP() {
		// TODO Auto-generated method stub
		return "êtes";
	}

	@Override
	public String termPresent3PP() {
		// TODO Auto-generated method stub
		return "sont";
	}

	@Override
	public String termFutur1PS() {
		// TODO Auto-generated method stub
		return "serai";
	}

	@Override
	public String termFutur2PS() {
		// TODO Auto-generated method stub
		return "seras";
	}

	@Override
	public String termFutur3PS() {
		// TODO Auto-generated method stub
		return "sera";
	}

	@Override
	public String termFutur1PP() {
		// TODO Auto-generated method stub
		return "serons";
	}

	@Override
	public String termFutur2PP() {
		// TODO Auto-generated method stub
		return "serez";
	}

	@Override
	public String termFutur3PP() {
		// TODO Auto-generated method stub
		return "seront";
	}

	@Override
	public String termPasseComposePS() {
		// TODO Auto-generated method stub
		return "été";
	}


}
