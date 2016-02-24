package diet;

import core.Aquarium;
import core.LivingBeing;

public interface Diet {
	public void eat(LivingBeing ownSelfIn, Aquarium environmentIn);
}
