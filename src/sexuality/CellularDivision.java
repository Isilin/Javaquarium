package sexuality;

import core.Aquarium;
import core.LivingBeing;
import core.LivingBeingFactory;

public class CellularDivision implements Sexuality {

	@Override
	public String getSex() {
		return "undefined";
	}

	@Override
	public LivingBeing copulate(LivingBeing ownSelfIn, Aquarium environmentIn) {
		LivingBeingFactory factory = new LivingBeingFactory();
		if(ownSelfIn.getHealth() >= 10) {
			int life = ownSelfIn.getHealth()/2;
			ownSelfIn.blown(life);
			try {
				return factory.build(ownSelfIn.getSpecies(), 0, 10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
