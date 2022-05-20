package attacks;

import ru.ifmo.se.pokemon.*;


public class RockTomb extends PhysicalMove {

	public RockTomb() {
		super(Type.ROCK, 60.0, 95);
	}

	@Override
	protected void applyOppEffects(Pokemon p) {
		p.setMod(Stat.SPEED, -1);
	}

	@Override
	protected String describe() {
	return "закидывает камнями";
	}

}