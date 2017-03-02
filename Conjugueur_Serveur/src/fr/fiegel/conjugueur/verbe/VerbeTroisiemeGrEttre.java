package fr.fiegel.conjugueur.verbe;

public class VerbeTroisiemeGrEttre extends AVerbe {

	public VerbeTroisiemeGrEttre(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "ettre";
	}

	@Override
	public String termPresent1PS() {
		return "ets";
	}

	@Override
	public String termPresent2PS() {
		return "ets";
	}

	@Override
	public String termPresent3PS() {
		return "et";
	}

	@Override
	public String termPresent1PP() {
		return "ettons";
	}

	@Override
	public String termPresent2PP() {
		return "ettez";
	}

	@Override
	public String termPresent3PP() {
		return "ettent";
	}

	@Override
	public String termFutur1PS() {
		return "ettrai";
	}

	@Override
	public String termFutur2PS() {
		return "ettras";
	}

	@Override
	public String termFutur3PS() {
		return "ettra";
	}

	@Override
	public String termFutur1PP() {
		return "ettrons";
	}

	@Override
	public String termFutur2PP() {
		return "ettrez";
	}

	@Override
	public String termFutur3PP() {
		return "ettront";
	}

	@Override
	public String termPassePS() {
		return "is";
	}

	@Override
	public String termCondPresent1PS() {
		return "ettrais";
	}

	@Override
	public String termCondPresent3PS() {
		return "ettrait";
	}

	@Override
	public String termCondPresent1PP() {
		return "ettrions";
	}

	@Override
	public String termCondPresent2PP() {
		return "ettriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "ettraient";
	}

}
