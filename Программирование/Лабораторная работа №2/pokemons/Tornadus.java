package pokemons;

import attacks.Crunch;
import attacks.Psychic;
import attacks.SludgeWave;
import attacks.Swagger;
import ru.ifmo.se.pokemon.*;

public class Tornadus extends Pokemon {


	public Tornadus (String name, int level) {
		super(name, level);
		this.addType(Type.FLYING);
		this.setStats(79, 115, 70, 125, 80, 111);
		this.setMove(new Psychic(), new Swagger(), new SludgeWave(), new Crunch());
	}

}
