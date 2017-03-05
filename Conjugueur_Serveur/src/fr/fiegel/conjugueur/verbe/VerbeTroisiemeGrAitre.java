package fr.fiegel.conjugueur.verbe;

public class VerbeTroisiemeGrAitre extends AVerbe {

	public VerbeTroisiemeGrAitre(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "aître";
	}

	@Override
	public String termPresent1PS() {
		return "ais";
	}

	@Override
	public String termPresent2PS() {
		return "ais";
	}

	@Override
	public String termPresent3PS() {
		return "aît";
	}

	@Override
	public String termPresent1PP() {
		return "aissons";
	}

	@Override
	public String termPresent2PP() {
		return "aissez";
	}

	@Override
	public String termPresent3PP() {
		return "aissent";
	}

	@Override
	public String termFutur1PS() {
		return "aîtrai";
	}

	@Override
	public String termFutur2PS() {
		return "aîtras";
	}

	@Override
	public String termFutur3PS() {
		return "aîtra";
	}

	@Override
	public String termFutur1PP() {
		return "aîtrions";
	}

	@Override
	public String termFutur2PP() {
		return "aîtriez";
	}

	@Override
	public String termFutur3PP() {
		return "aîtraient";
	}

	@Override
	public String termPassePS() {
		return "u";
	}

	@Override
	public String termCondPresent1PS() {
		return "aîtrais";
	}

	@Override
	public String termCondPresent3PS() {
		return "aîtrait";
	}

	@Override
	public String termCondPresent1PP() {
		return "aîtrions";
	}

	@Override
	public String termCondPresent2PP() {
		return "aîtriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "aîtraient";
	}

}
