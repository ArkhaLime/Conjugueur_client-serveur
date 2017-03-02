package fr.fiegel.conjugueur.verbe;

public class VerbeTroisiemeGrAller extends AVerbe {

	public VerbeTroisiemeGrAller() {
		this("aller");

	}

	public VerbeTroisiemeGrAller(String infinitif) {
		super(infinitif);
		this.auxiliaire = new Etre();
	}

	@Override
	public String termInfinitif() {
		return "aller";
	}

	@Override
	public String termPresent1PS() {
		return "vais";
	}

	@Override
	public String termPresent2PS() {
		return "vas";
	}

	@Override
	public String termPresent3PS() {
		return "va";
	}

	@Override
	public String termPresent1PP() {
		return "allons";
	}

	@Override
	public String termPresent2PP() {
		return "allez";
	}

	@Override
	public String termPresent3PP() {
		return "vont";
	}

	@Override
	public String termFutur1PS() {
		return "irai";
	}

	@Override
	public String termFutur2PS() {
		return "iras";
	}

	@Override
	public String termFutur3PS() {
		return "ira";
	}

	@Override
	public String termFutur1PP() {
		return "irons";
	}

	@Override
	public String termFutur2PP() {
		return "irez";
	}

	@Override
	public String termFutur3PP() {
		return "iront";
	}

	@Override
	public String termPassePS() {
		return "allé";
	}

	@Override
	public String termPassePP() {
		return "allés";
	}

	@Override
	public String termCondPresent1PS() {
		return "irais";
	}

	@Override
	public String termCondPresent3PS() {
		return "irait";
	}

	@Override
	public String termCondPresent1PP() {
		return "irions";
	}

	@Override
	public String termCondPresent2PP() {
		return "iriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "iraient";
	}

}
