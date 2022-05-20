package attacks;

import ru.ifmo.se.pokemon.*;


public class Swagger extends StatusMove {

	public Swagger() { 
		super(Type.NORMAL, 0, 90);
	}



	@Override
	protected String describe() {
	return "конфузит";
}
	@Override
	protected void applyOppEffects(Pokemon p) {
		p.setMod(Stat.ATTACK, 2);
		p.confuse();
	}


	}