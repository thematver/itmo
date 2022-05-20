package attacks;

import ru.ifmo.se.pokemon.*;



public class SleepPowder extends StatusMove {

	public SleepPowder() {
		super(Type.GRASS, 0, 75);
	}

	@Override
	protected boolean checkAccuracy(Pokemon att, Pokemon def){
		return true;
	}

	@Override
	protected void applyOppEffects(Pokemon p) {
		Effect.sleep(p);
	}

	@Override
	protected String describe() {
	return "усыпляет";
	}

}
