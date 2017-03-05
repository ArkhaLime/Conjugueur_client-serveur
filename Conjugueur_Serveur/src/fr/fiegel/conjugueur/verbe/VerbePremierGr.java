package fr.fiegel.conjugueur.verbe;

public class VerbePremierGr extends AVerbe {

	public VerbePremierGr(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "er";
	}

	@Override
	public String termPresent1PS() {
		return "e";
	}

	@Override
	public String termPresent2PS() {
		return "es";
	}

	@Override
	public String termPresent3PS() {
		return "e";
	}

	@Override
	public String termPresent1PP() {
		return "ons";
	}

	@Override
	public String termPresent2PP() {
		return "ez";
	}

	@Override
	public String termPresent3PP() {
		return "ent";
	}

	@Override
	public String termFutur1PS() {
		return "erai";
	}

	@Override
	public String termFutur2PS() {
		return "eras";
	}

	@Override
	public String termFutur3PS() {
		return "era";
	}

	@Override
	public String termFutur1PP() {
		return "erons";
	}

	@Override
	public String termFutur2PP() {
		return "erez";
	}

	@Override
	public String termFutur3PP() {
		return "eront";
	}

	@Override
	public String termPassePS() {
		return "é";
	}

	@Override
	public String termCondPresent1PS() {
		return "erais";
	}

	@Override
	public String termCondPresent3PS() {
		return "erait";
	}

	@Override
	public String termCondPresent1PP() {
		return "erions";
	}

	@Override
	public String termCondPresent2PP() {
		return "eriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "eraient";
	}

}
