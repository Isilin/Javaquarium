package sexuality;

public class SexualityFactory {
	private static SexualityFactory instance = null;
	
	private SexualityFactory() {
		SexualityFactory.instance = this;
	}
	
	public static SexualityFactory getInstance() {
		if(SexualityFactory.instance == null) {
			return new SexualityFactory();
		} else{
			return SexualityFactory.instance;
		}
	}
	
	public Sexuality build(String sexualityIn, String sexIn) throws Exception {
		switch(sexualityIn){
			case "cellularDivision":
				return new CellularDivision();
			case "monosexual":
				return new Monosexual(sexIn);
			case "sexualAltern":
				return new SexualAltern(sexIn);
			case "opportunist":
				return new Opportunist(sexIn);
			default:
				throw new Exception("Unknown type of sexuality.");
		}
	}
}
