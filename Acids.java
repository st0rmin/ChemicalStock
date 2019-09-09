package chemicalstock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class Acids extends Chemicals {

	private static final long serialVersionUID = 1L;

	public Acids() {

	}

	public Acids(String name, double mol, double amt, double restock, String unit) {
		super.store("AcidStock.txt", name + " " + mol + " " + amt + " " + restock + " " + unit);
	}

	public void display() throws FileNotFoundException {
		super.display("Acids");
	}
}
