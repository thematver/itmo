package attacks;

import ru.ifmo.se.pokemon.*;


public class Rest extends StatusMove {

	public Rest() {
		super(Type.PSYCHIC, 0, 100);
	}

	@Override
	protected void applySelfEffects(Pokemon p) {
<<<<<<< HEAD:lab2/attacks/Rest.java
		Effect ef_sleep = new Effect().turns(2).condition(Status.SLEEP);
		Effect ef_heal  = new Effect().stat(Stat.HP, (int) (p.getHP() - p.getStat(Stat.HP)));
=======
		p.setCondition(new Effect().turns(2).condition(Status.SLEEP));
		Effect ef_heal  = new Effect().stat(Stat.HP, (int) (p.getHP() - p.getStat(Stat.HP))).turns(1);
>>>>>>> 188bd29a390820569b8f6117b017178483d7ef20:Pokemon/attacks/Rest.java
		p.addEffect(ef_heal);
	}

	@Override
	protected String describe() {
	return "отдыхает. Круто!";
	}

}
