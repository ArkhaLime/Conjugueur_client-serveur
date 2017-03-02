package fr.fiegel.conjugueur.verbe;

public class VerbeTroisiemeGrSoudre extends AVerbe {

	public VerbeTroisiemeGrSoudre(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "soudre";
	}

	@Override
	public String termPresent1PS() {
		return "sous";
	}

	@Override
	public String termPresent2PS() {
		return "sous";
	}

	@Override
	public String termPresent3PS() {
		return "sout";
	}

	@Override
	public String termPresent1PP() {
		return "solvons";
	}

	@Override
	public String termPresent2PP() {
		return "solvez";
	}

	@Override
	public String termPresent3PP() {
		return "solvent";
	}

	@Override
	public String termFutur1PS() {
		return "soudrai";
	}

	@Override
	public String termFutur2PS() {
		return "soudras";
	}

	@Override
	public String termFutur3PS() {
		return "soudra";
	}

	@Override
	public String termFutur1PP() {
		return "soudrons";
	}

	@Override
	public String termFutur2PP() {
		return "soudrez";
	}

	@Override
	public String termFutur3PP() {
		return "soudront";
	}

	@Override
	public String termPassePS() {
		return "solu";
	}

	@Override
	public String termCondPresent1PS() {
		return "soudrais";
	}

	@Override
	public String termCondPresent3PS() {
		return "soudrait";
	}

	@Override
	public String termCondPresent1PP() {
		return "soudrions";
	}

	@Override
	public String termCondPresent2PP() {
		return "soudriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "soudraient";
	}

}
