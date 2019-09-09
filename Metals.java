import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Metals extends Chemicals{

	private static final long serialVersionUID = 1L;

	public Metals() {
		
	}
	
	public Metals(String name, double mol, double amt, double restock, String unit) {
		super.store("MetalStock.txt", name + " " + mol + " " + amt + " " + restock + " " + unit);
	}

	public void display() throws FileNotFoundException {
		super.display("Metals");
	}
}
