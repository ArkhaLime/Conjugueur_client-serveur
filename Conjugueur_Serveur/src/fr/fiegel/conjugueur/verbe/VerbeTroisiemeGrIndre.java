package fr.fiegel.conjugueur.verbe;

public class VerbeTroisiemeGrIndre extends AVerbe {

	public VerbeTroisiemeGrIndre(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "indre";
	}

	@Override
	public String termPresent1PS() {
		return "ins";
	}

	@Override
	public String termPresent2PS() {
		return "ins";
	}

	@Override
	public String termPresent3PS() {
		return "int";
	}

	@Override
	public String termPresent1PP() {
		return "ignons";
	}

	@Override
	public String termPresent2PP() {
		return "ignez";
	}

	@Override
	public String termPresent3PP() {
		return "ignent";
	}

	@Override
	public String termFutur1PS() {
		return "indrai";
	}

	@Override
	public String termFutur2PS() {
		return "indras";
	}

	@Override
	public String termFutur3PS() {
		return "indra";
	}

	@Override
	public String termFutur1PP() {
		return "indrons";
	}

	@Override
	public String termFutur2PP() {
		return "indrez";
	}

	@Override
	public String termFutur3PP() {
		return "indront";
	}

	@Override
	public String termPassePS() {
		return "int";
	}

	@Override
	public String termCondPresent1PS() {
		return "indrais";
	}

	@Override
	public String termCondPresent3PS() {
		return "indrait";
	}

	@Override
	public String termCondPresent1PP() {
		return "indrions";
	}

	@Override
	public String termCondPresent2PP() {
		return "indriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "indraient";
	}

}
