package fr.fiegel.conjugueur.verbe;

public class VerbePremierGrGer extends AVerbe {

	public VerbePremierGrGer(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "ger";
	}

	@Override
	public String termPresent1PS() {
		return "ge";
	}

	@Override
	public String termPresent2PS() {
		return "ges";
	}

	@Override
	public String termPresent3PS() {
		return "ge";
	}

	@Override
	public String termPresent1PP() {
		return "geons";
	}

	@Override
	public String termPresent2PP() {
		return "gez";
	}

	@Override
	public String termPresent3PP() {
		return "gent";
	}

	@Override
	public String termFutur1PS() {
		return "gerai";
	}

	@Override
	public String termFutur2PS() {
		return "geras";
	}

	@Override
	public String termFutur3PS() {
		return "gera";
	}

	@Override
	public String termFutur1PP() {
		return "gerons";
	}

	@Override
	public String termFutur2PP() {
		return "gerez";
	}

	@Override
	public String termFutur3PP() {
		return "geront";
	}

	@Override
	public String termPassePS() {
		return "gé";
	}

	@Override
	public String termCondPresent1PS() {
		return "gerais";
	}

	@Override
	public String termCondPresent3PS() {
		return "gerait";
	}

	@Override
	public String termCondPresent1PP() {
		return "gerions";
	}

	@Override
	public String termCondPresent2PP() {
		return "geriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "geraient";
	}

}
