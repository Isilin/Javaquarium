package core;

public class Animal extends LivingBeing {
	private String name = "";
	
	public Animal(int ageIn, int healthIn, String speciesIn, String nameIn) {
		super(ageIn, healthIn, speciesIn);
		this.name = nameIn;
	}
	
	public String getName() {
		return this.name;
	}
}
