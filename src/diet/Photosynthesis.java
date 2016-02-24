package diet;

import core.Aquarium;
import core.LivingBeing;

public class Photosynthesis implements Diet {

	@Override
	public void eat(LivingBeing ownSelfIn, Aquarium environmentIn) {
		ownSelfIn.grow(1);
		ownSelfIn.setBusy(true);
	}

}
