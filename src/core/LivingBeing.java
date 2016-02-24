package core;

import diet.*;
import sexuality.*;

public class LivingBeing {
	private int age = 0;
	private int health = 20;
	private String species;
	private Boolean busy = true;
	
	private Diet diet = null;
	private Sexuality sexuality = null;
	
	public LivingBeing(int ageIn, int healthIn, String speciesIn) {
		this.age = ageIn;
		this.health = healthIn;
		this.species = speciesIn;
		System.out.println(this.age+" | "+this.health+" | "+this.species);
	}
	
	public void age() {
		this.age++;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void blown(int woundIn) {
		this.health -= woundIn;
	}
	
	public void grow(int healthIn) {
		this.health += healthIn;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public void setBusy(Boolean newValue){
		this.busy = newValue;
	}
	
	public Boolean isBusy() {
		return this.busy;
	}
	
	public Boolean isAlive() {
		return this.health > 0 && this.age <= 20;
	}
	
	public void evolve(Aquarium environmentIn) {
		if(this.getSpecies() != "alga") {
			this.blown(1);
		}
		this.age();
		if(this.health <= 5 && this.isAlive() && !this.isBusy()) {
			this.diet.eat(this, environmentIn);
		}
		if(this.isAlive() && !this.isBusy() && environmentIn.getAlgas().size() > 0 && environmentIn.getFishes().size() > 0) {
			LivingBeing baby = this.sexuality.copulate(this, environmentIn);
			if(baby != null){
				try {
					environmentIn.addBeLeaving(baby);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void setDiet(Diet newDietIn) {
		this.diet = newDietIn;
	}
	
	public void setSexuality(Sexuality newSexualityIn) {
		this.sexuality = newSexualityIn;
	}
	
	public String getType(){
		if(this.species.equals("alga")) {
			return "vegetable";
		} else {
			return "animal";
		}
	}
	
	public String getSex() {
		return this.sexuality.getSex();
	}
}
