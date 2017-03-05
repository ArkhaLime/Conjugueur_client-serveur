package fr.fiegel.conjugueur.verbe;

public class Etre extends AVerbe {

	public Etre() {
		this("être");
	}

	public Etre(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "être";
	}

	@Override
	public String termPresent1PS() {
		return "suis";
	}

	@Override
	public String termPresent2PS() {
		return "es";
	}

	@Override
	public String termPresent3PS() {
		return "est";
	}

	@Override
	public String termPresent1PP() {
		return "sommes";
	}

	@Override
	public String termPresent2PP() {
		return "êtes";
	}

	@Override
	public String termPresent3PP() {
		return "sont";
	}

	@Override
	public String termFutur1PS() {
		return "serai";
	}

	@Override
	public String termFutur2PS() {
		return "seras";
	}

	@Override
	public String termFutur3PS() {
		return "sera";
	}

	@Override
	public String termFutur1PP() {
		return "serons";
	}

	@Override
	public String termFutur2PP() {
		return "serez";
	}

	@Override
	public String termFutur3PP() {
		return "seront";
	}

	@Override
	public String termPassePS() {
		return "été";
	}

	@Override
	public String termCondPresent1PS() {
		return "serais";
	}

	@Override
	public String termCondPresent3PS() {
		return "serait";
	}

	@Override
	public String termCondPresent1PP() {

		return "serions";
	}

	@Override
	public String termCondPresent2PP() {
		return "seriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "seraient";
	}

}
