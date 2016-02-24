package diet;

import java.util.Random;

import core.Aquarium;
import core.LivingBeing;

public class Carnivorous implements Diet {

	@Override
	public void eat(LivingBeing ownSelfIn, Aquarium environmentIn) {
		Random rand = new Random();
		int indice = rand.nextInt(environmentIn.getFishes().size()+1);
		if(indice > 0) {
			indice--;
		}
		LivingBeing target = environmentIn.getFishes().get(indice);
		if(!ownSelfIn.getSpecies().equals(target.getSpecies()) && target.isAlive()) {
			target.blown(4);
			ownSelfIn.grow(5);
		}
		ownSelfIn.setBusy(true);
		target.setBusy(true);
	}

}
