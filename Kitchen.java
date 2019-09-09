import java.io.FileNotFoundException;

public class Kitchen extends Chemicals{

	private static final long serialVersionUID = 1L;
	
	public Kitchen() {
		
	}
	
	public Kitchen(String name, double mol, double amt, double restock, String unit) {
		super.store("KitchenStock.txt", name + " " + mol + " " + amt + " " + restock + " " + unit);
	}
	
	public void display() throws FileNotFoundException {
		super.display("Kitchen");
	}
}
