package diet;

public class DietFactory {
	private static DietFactory instance = null;
	
	private DietFactory() {
		DietFactory.instance = this;
	}
	
	public static DietFactory getInstance() {
		if(DietFactory.instance == null) {
			return new DietFactory();
		} else{
			return DietFactory.instance;
		}
	}
	
	public Diet build(String dietIn) throws Exception {
		switch(dietIn){
			case "photosynthesis":
				return new Photosynthesis();
			case "carnivorous":
				return new Carnivorous();
			case "herbivorous":
				return new Herbivorous();
			default:
				throw new Exception("Unknown type of diet.");
		}
	}
}
