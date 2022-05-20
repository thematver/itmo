package pokemons;

import attacks.RockTomb;
import ru.ifmo.se.pokemon.*;

public class Flygon extends Vibrava {


	public Flygon (String name, int level) {
		super(name, level);
		this.addType(Type.FLYING);
		this.setStats(79, 115, 70, 125, 80, 111);
		this.addMove(new RockTomb());
	}

}
