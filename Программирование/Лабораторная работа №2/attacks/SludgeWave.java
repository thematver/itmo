package attacks;

import ru.ifmo.se.pokemon.*;



public class SludgeWave extends SpecialMove {

	public SludgeWave() {
		super(Type.POISON, 95.0, 100);
	}

	@Override
	protected void applyOppEffects(Pokemon p) {
		double chance = Math.random() * 10;
		if (chance <= 1)
			Effect.poison(p);
	}

	@Override
	protected String describe() {
	return "делает волновой осадок";
	}

}
