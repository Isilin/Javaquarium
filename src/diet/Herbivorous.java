package diet;

import java.util.Random;

import core.Aquarium;
import core.LivingBeing;

public class Herbivorous implements Diet {

	@Override
	public void eat(LivingBeing ownSelfIn, Aquarium environmentIn) {
		Random rand = new Random();
		int indice = rand.nextInt(environmentIn.getAlgas().size()+1);
		if(indice > 0) {
			indice--;
		}
		LivingBeing target = environmentIn.getAlgas().get(indice);
		if(target.isAlive()) {
			target.blown(2);
			ownSelfIn.grow(3);
		}
		ownSelfIn.setBusy(true);
		target.setBusy(true);
	}

}
