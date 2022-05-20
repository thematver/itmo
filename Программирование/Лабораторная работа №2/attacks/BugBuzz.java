package attacks;

import ru.ifmo.se.pokemon.*;



public class BugBuzz extends SpecialMove {

	public BugBuzz () {
		super(Type.BUG, 90.0, 100);
	}

	@Override
	protected void applyOppEffects(Pokemon p) {
		Effect ef = new Effect().stat(Stat.SPECIAL_DEFENSE, 1).chance(0.1);
		p.addEffect(ef);
	}

	@Override
	protected String describe() {
	return "использует Bug Buzz";
	}

}
