package pokemons;

import attacks.BugBuzz;
import ru.ifmo.se.pokemon.*;

public class Venomoth extends Venonat {


	public Venomoth (String name, int level) {
		super(name, level);
		this.addType(Type.FLYING);
		this.setStats(79, 115, 70, 125, 80, 111);
		this.addMove(new BugBuzz());
	}

}
