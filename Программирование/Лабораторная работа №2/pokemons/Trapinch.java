package pokemons;

import attacks.Rest;
import attacks.SandAttack;
import ru.ifmo.se.pokemon.*;

public class Trapinch extends Pokemon {


	public Trapinch (String name, int level) {
		super(name, level);
		this.addType(Type.FLYING);
		this.setStats(79, 115, 70, 125, 80, 111);
		this.setMove(new Rest(), new SandAttack());
	}

}
