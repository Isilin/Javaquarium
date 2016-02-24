package core;

import diet.DietFactory;
import sexuality.SexualityFactory;

public class LivingBeingFactory {
	public LivingBeing build(String speciesIn, int ageIn, int healthIn) throws Exception{
		DietFactory dietFactory = DietFactory.getInstance();
		SexualityFactory sexualityFactory = SexualityFactory.getInstance();
		switch(speciesIn){
			case "alga":
				LivingBeing newAlga = new LivingBeing(ageIn, healthIn, speciesIn);
				newAlga.setDiet(dietFactory.build("photosynthesis"));
				newAlga.setSexuality(sexualityFactory.build("cellularDivision", ""));
				return newAlga;
			default:
				throw new Exception("Unknown type or invalid parameters.");
		}
	}
	
	public LivingBeing build(String speciesIn, int ageIn, int healthIn, String nameIn, String sexIn) throws Exception {
		DietFactory dietFactory = DietFactory.getInstance();
		SexualityFactory sexualityFactory = SexualityFactory.getInstance();
		switch(speciesIn){
			case "carp":
				LivingBeing newFish = new Animal(ageIn, healthIn, speciesIn, nameIn);
				newFish.setDiet(dietFactory.build("herbivorous"));
				newFish.setSexuality(sexualityFactory.build("monosexual", sexIn));
				return newFish;
			default:
				throw new Exception("Unknown type or invalid parameters.");
		}
	}
}
