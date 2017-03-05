package fr.fiegel.conjugueur.verbe;

public class VerbeDeuxiemeGr extends AVerbe {

	public VerbeDeuxiemeGr(String infinitif) {
		super(infinitif);
	}

	@Override
	public String termInfinitif() {
		return "ir";
	}

	@Override
	public String termPresent1PS() {
		return "is";
	}

	@Override
	public String termPresent2PS() {
		return "is";
	}

	@Override
	public String termPresent3PS() {
		return "it";
	}

	@Override
	public String termPresent1PP() {
		return "issons";
	}

	@Override
	public String termPresent2PP() {
		return "issez";
	}

	@Override
	public String termPresent3PP() {
		return "issent";
	}

	@Override
	public String termFutur1PS() {
		return "irai";
	}

	@Override
	public String termFutur2PS() {
		return "iras";
	}

	@Override
	public String termFutur3PS() {
		return "ira";
	}

	@Override
	public String termFutur1PP() {
		return "irons";
	}

	@Override
	public String termFutur2PP() {
		return "irez";
	}

	@Override
	public String termFutur3PP() {
		return "iront";
	}

	@Override
	public String termPassePS() {
		return "i";
	}

	@Override
	public String termCondPresent1PS() {
		return "irais";
	}

	@Override
	public String termCondPresent3PS() {
		return "irait";
	}

	@Override
	public String termCondPresent1PP() {
		return "irions";
	}

	@Override
	public String termCondPresent2PP() {
		return "iriez";
	}

	@Override
	public String termCondPresent3PP() {
		return "iraient";
	}

}
