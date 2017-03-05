package fr.fiegel.conjugueur.verbe;

public class VerbeTroisiemeGrCoudre extends AVerbe {

	public VerbeTroisiemeGrCoudre(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "coudre";
	}

	@Override
	public String termPresent1PS() {
		return "couds";
	}

	@Override
	public String termPresent2PS() {
		return "couds";
	}

	@Override
	public String termPresent3PS() {
		return "coud";
	}

	@Override
	public String termPresent1PP() {
		return "cousons";
	}

	@Override
	public String termPresent2PP() {
		return "cousez";
	}

	@Override
	public String termPresent3PP() {
		return "cousent";
	}

	@Override
	public String termFutur1PS() {
		return "coudrai";
	}

	@Override
	public String termFutur2PS() {
		return "coudras";
	}

	@Override
	public String termFutur3PS() {
		return "coudra";
	}

	@Override
	public String termFutur1PP() {
		return "coudrons";
	}

	@Override
	public String termFutur2PP() {
		return "coudrez";
	}

	@Override
	public String termFutur3PP() {
		return "coudront";
	}

	@Override
	public String termPassePS() {
		return "cousu";
	}

	@Override
	public String termCondPresent1PS() {
		return "coudrais";
	}

	@Override
	public String termCondPresent3PS() {
		return "coudrait";
	}

	@Override
	public String termCondPresent1PP() {
		return "coudrions";
	}

	@Override
	public String termCondPresent2PP() {
		return "coudriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "coudraient";
	}

}
