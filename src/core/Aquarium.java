package core;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aquarium {
	private List<LivingBeing> listFishes = new ArrayList<LivingBeing>();
	private List<LivingBeing> listAlgas = new ArrayList<LivingBeing>();
	
	private List<LivingBeing> babyFishes = new ArrayList<LivingBeing>();
	private List<LivingBeing> babyAlgas = new ArrayList<LivingBeing>();
	
	public Aquarium() {
		
	}
	
	public void addFish(LivingBeing newFishIn) throws Exception {
		if(newFishIn != null) {
			babyFishes.add(newFishIn);
		} else {
			throw new Exception("Null parameter not allowed.");
		}
	}
	
	public void addAlga(LivingBeing newAlgaIn) throws Exception {
		if(newAlgaIn != null) {
			babyAlgas.add(newAlgaIn);
		} else {
			throw new Exception("Null parameter not allowed.");
		}
	}
	
	public void addBeLeaving(LivingBeing newBeLeavingIn) throws Exception {
		switch(newBeLeavingIn.getType()){
			case "animal":
				this.addFish(newBeLeavingIn);
				break;
			case "vegetable":
				this.addAlga(newBeLeavingIn);
				break;
			default:
				throw new Exception("Unknow type of be leaving.");
		}
	}
	
	public List<LivingBeing> getFishes() {
		return this.listFishes;
	}
	
	public List<LivingBeing> getAlgas() {
		return this.listAlgas;
	}
	
	public void loadFromFile(String fileIn) {
		try {
			Scanner scanner = new Scanner(new File(fileIn));
			while (scanner.hasNextLine()) {
			    String line = scanner.nextLine();
			    // TODO : analyse line
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void saveToFile(String fileIn) {
		for(int i = 0; i < 20; i++) {
			// TODO : save by age
		}
		for(LivingBeing element : this.listFishes) {
			// TODO : save one per line
		}
	}
	
	public void nextTurn() {
		for (LivingBeing element : this.listAlgas) {
			element.evolve(this);
		}
		for (LivingBeing element : this.listFishes) {
			element.evolve(this);
		}
		
		for(LivingBeing element : this.babyAlgas) {
			this.listAlgas.add(element);
		}
		for(LivingBeing element : this.babyFishes) {
			this.listAlgas.add(element);
		}
		this.babyAlgas.clear();
		this.babyFishes.clear();
		
		// clean
		List<Integer> old = new ArrayList<Integer>();
		for (LivingBeing element : this.listAlgas) {
			element.setBusy(false);
			if(!element.isAlive()) {
				old.add(this.listAlgas.indexOf(element));
			}
		}
		for (Integer element : old) {
			this.listAlgas.remove(element);
		}
		old.clear();
		for (LivingBeing element : this.listFishes) {
			element.setBusy(false);
			if(!element.isAlive()) {
				old.add(this.listFishes.indexOf(element));
			}
		}
		for (Integer element : old) {
			this.listFishes.remove(element);
		}
	}

	public static void main(String[] args) {
		Aquarium environment = new Aquarium();
		environment.loadFromFile("aquarium.save");
		
		while(true) {
			System.out.println(environment.getAlgas().size()+" | "+environment.getFishes().size());
			environment.nextTurn();
		}
		//environment.saveToFile("aquarium.save");
	}

}
