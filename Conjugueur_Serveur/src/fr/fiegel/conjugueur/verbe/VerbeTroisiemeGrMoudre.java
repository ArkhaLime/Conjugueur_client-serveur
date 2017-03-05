package fr.fiegel.conjugueur.verbe;

public class VerbeTroisiemeGrMoudre extends AVerbe {

	public VerbeTroisiemeGrMoudre(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "moudre";
	}

	@Override
	public String termPresent1PS() {
		return "mouds";
	}

	@Override
	public String termPresent2PS() {
		return "mouds";
	}

	@Override
	public String termPresent3PS() {
		return "moud";
	}

	@Override
	public String termPresent1PP() {
		return "moulons";
	}

	@Override
	public String termPresent2PP() {
		return "moulez";
	}

	@Override
	public String termPresent3PP() {
		return "moulent";
	}

	@Override
	public String termFutur1PS() {
		return "moudrai";
	}

	@Override
	public String termFutur2PS() {
		return "moudras";
	}

	@Override
	public String termFutur3PS() {
		return "moudra";
	}

	@Override
	public String termFutur1PP() {
		return "moudrons";
	}

	@Override
	public String termFutur2PP() {
		return "moudrez";
	}

	@Override
	public String termFutur3PP() {
		return "moudront";
	}

	@Override
	public String termPassePS() {
		return "moulu";
	}

	@Override
	public String termCondPresent1PS() {
		return "moudrais";
	}

	@Override
	public String termCondPresent3PS() {
		return "moudrait";
	}

	@Override
	public String termCondPresent1PP() {
		return "moudrions";
	}

	@Override
	public String termCondPresent2PP() {
		return "moudriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "moudraient";
	}

}
