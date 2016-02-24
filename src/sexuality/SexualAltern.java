package sexuality;

import java.util.Random;

import core.Aquarium;
import core.LivingBeing;
import core.LivingBeingFactory;

public class SexualAltern implements Sexuality {
	private String sex = "";
	
	public SexualAltern(String sexIn) {
		this.sex = sexIn;
	}

	@Override
	public String getSex() {
		return this.sex;
	}

	@Override
	public LivingBeing copulate(LivingBeing ownSelfIn, Aquarium environmentIn) {
		if(ownSelfIn.getAge() >= 10 && this.sex.equals("male")) {
			this.sex = "female";
		}
		
		LivingBeingFactory factory = new LivingBeingFactory();
		Random rand = new Random();
		int indice = rand.nextInt(environmentIn.getFishes().size()+1);
		if(indice > 0) {
			indice--;
		}
		LivingBeing partner = environmentIn.getFishes().get(indice);
		if(partner.getSpecies().equals(ownSelfIn.getSpecies()) && !partner.getSex().equals(this.sex) && partner.isAlive()) {
			ownSelfIn.setBusy(true);
			partner.setBusy(true);
			String babySex = "female";
			if(rand.nextInt(1) == 0) {
				babySex = "male";
			}
			try {
				return factory.build(ownSelfIn.getSpecies(), 0, 10, "Bibi", babySex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
