package fr.fiegel.conjugueur.verbe;

public class Avoir extends AVerbe {

	public Avoir() {
		this("avoir");
	}
	
	public Avoir(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "avoir";
	}
	
	@Override
	public String termPresent1PS() {
		return "ai";
	}

	@Override
	public String termPresent2PS() {
		return "as";
	}

	@Override
	public String termPresent3PS() {
		return "a";
	}

	@Override
	public String termPresent1PP() {
		return "avons";
	}

	@Override
	public String termPresent2PP() {
		return "avez";
	}

	@Override
	public String termPresent3PP() {
		return "ont";
	}

	@Override
	public String termFutur1PS() {
		return "aurai";
	}

	@Override
	public String termFutur2PS() {
		return "auras";
	}

	@Override
	public String termFutur3PS() {
		return "aura";
	}

	@Override
	public String termFutur1PP() {
		return "aurons";
	}

	@Override
	public String termFutur2PP() {
		return "aurez";
	}

	@Override
	public String termFutur3PP() {
		return "aurons";
	}

	@Override
	public String termPassePS() {
		return "eu";
	}

	@Override
	public String termCondPresent1PS() {
		return "aurais";
	}

	@Override
	public String termCondPresent3PS() {
		return "aurait";
	}

	@Override
	public String termCondPresent1PP() {
		return "aurions";
	}

	@Override
	public String termCondPresent2PP() {
		return "auriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "auraient";
	}

}
