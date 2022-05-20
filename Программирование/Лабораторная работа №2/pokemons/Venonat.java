package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.*;

public class Venonat extends Pokemon {


	public Venonat (String name, int level) {
		super(name, level);
		this.addType(Type.FLYING);
		this.setStats(79, 115, 70, 125, 80, 111);
		this.setMove(new SleepPowder(), new Swagger(), new LeechLife());
	}

}
