package fr.fiegel.conjugueur.verbe;

public class VerbePremierGrCer extends AVerbe {

	public VerbePremierGrCer(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "cer";
	}

	@Override
	public String termPresent1PS() {
		return "ce";
	}

	@Override
	public String termPresent2PS() {
		return "ces";
	}

	@Override
	public String termPresent3PS() {
		return "ce";
	}

	@Override
	public String termPresent1PP() {
		return "çons";
	}

	@Override
	public String termPresent2PP() {
		return "cez";
	}

	@Override
	public String termPresent3PP() {
		return "cent";
	}

	@Override
	public String termFutur1PS() {
		return "cerai";
	}

	@Override
	public String termFutur2PS() {
		return "ceras";
	}

	@Override
	public String termFutur3PS() {
		return "cera";
	}

	@Override
	public String termFutur1PP() {
		return "cerons";
	}

	@Override
	public String termFutur2PP() {
		return "cerez";
	}

	@Override
	public String termFutur3PP() {
		return "ceront";
	}

	@Override
	public String termPassePS() {
		return "cé";
	}

	@Override
	public String termCondPresent1PS() {
		return "cerais";
	}

	@Override
	public String termCondPresent3PS() {
		return "cerait";
	}

	@Override
	public String termCondPresent1PP() {
		return "cerions";
	}

	@Override
	public String termCondPresent2PP() {
		return "ceriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "ceraient";
	}

}
