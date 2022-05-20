package attacks;

import ru.ifmo.se.pokemon.*;


 public class LeechLife extends PhysicalMove {

	public LeechLife() {
		super(Type.BUG, 80.0, 100);
	}

	@Override
	protected void applyOppEffects(Pokemon p) {
		
	}

	@Override
	protected void applySelfEffects(Pokemon p) {
			Effect heal = new Effect().stat(Stat.HP, (int) (p.getStat(Stat.HP)-p.getHP())/2).turns(1);
			p.addEffect(heal);
	}

	@Override
	protected String describe() {
	return "крадет жизнь";
	}

}