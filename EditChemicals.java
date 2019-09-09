import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditChemicals extends Chemicals{
	JFrame editChemFrame = new JFrame();
	JPanel editChemPanel = new JPanel();
	int staticWidth = 960;
	int staticHeight = 540;

	public void editChemicalsCreate() {
		this.editChemFrame.setSize(this.staticWidth / 3, this.staticHeight / 3);
		this.editChemFrame.setLocation(new Point(((int) ((super.screenWidth - editChemFrame.getWidth()) / 2)) , ((int) ((super.screenHeight- editChemFrame.getHeight()) / 2))));
		this.editChemPanel.setSize(this.staticWidth / 3, this.staticHeight / 3);
		this.editChemFrame.setTitle("Edit Chemicals");
		this.editChemFrame.setResizable(false);
		this.editChemPanel.setLayout(new GridLayout(2, 1));

		final JButton addChem = new JButton();
		addChem.setSize(new Dimension(160, 20));
		addChem.setText("Add Chemical");
		addChem.setVisible(true);
		addChem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addChem.isEnabled()) {
					EditChemicals.this.editChemFrame.dispose();
					EditChemicals.this.addChemical();
				}
			}
		});
		final JButton removeChem = new JButton();
		removeChem.setSize(new Dimension(160, 20));
		removeChem.setText("Remove Chemical");
		removeChem.setVisible(true);
		removeChem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (removeChem.isEnabled()) {
					EditChemicals.this.editChemFrame.dispose();
					EditChemicals.this.removeChemical();
				}
			}
		});
		this.editChemPanel.add(addChem);
		this.editChemPanel.add(removeChem);
		this.editChemFrame.add(this.editChemPanel);
		this.editChemPanel.setVisible(true);
		this.editChemFrame.setVisible(true);
	}

	public void addChemical() {
		JFrame addChemFrame = new JFrame();
		JPanel addChemPanel = new JPanel();

		addChemFrame.setSize(this.staticWidth / 3, this.staticHeight / 3);
		addChemFrame.setLocation(new Point(((int) ((super.screenWidth - editChemFrame.getWidth()) / 2)) , ((int) ((super.screenHeight- editChemFrame.getHeight()) / 2))));
		addChemPanel.setSize(this.staticWidth / 3, this.staticHeight / 3);
		addChemPanel.setLayout(null);
		addChemFrame.setResizable(false);

		JLabel nameLabel = new JLabel();
		nameLabel.setSize(180, 20);
		nameLabel.setLocation(this.staticWidth / 9 - 5, this.staticHeight / 24 - 25);
		nameLabel.setText("Name of Chemical");
		nameLabel.setVisible(true);

		JTextField chemName = new JTextField();
		chemName.setSize(150, 20);
		chemName.setLocation(this.staticWidth / 9 - 30, this.staticHeight / 30);
		chemName.setVisible(true);

		JLabel molLabel = new JLabel();
		molLabel.setSize(50, 20);
		molLabel.setLocation(this.staticWidth / 9 + 138, this.staticHeight / 24 - 25);
		molLabel.setText("Molarity");
		molLabel.setVisible(true);

		JTextField molAmount = new JTextField();
		molAmount.setSize(30, 20);
		molAmount.setLocation(this.staticWidth / 9 + 145, this.staticHeight / 30);
		molAmount.setText("0");
		molAmount.setVisible(true);

		JLabel molApplicableLabel = new JLabel();
		molApplicableLabel.setSize(50, 20);
		molApplicableLabel.setLocation(this.staticWidth / 9 + 140, this.staticHeight / 24 + 15);
		molApplicableLabel.setText("0 if N/A");
		molApplicableLabel.setVisible(true);

		JLabel chemTypeLabel = new JLabel();
		chemTypeLabel.setSize(150, 20);
		chemTypeLabel.setLocation(this.staticWidth / 9, this.staticHeight / 15);
		chemTypeLabel.setText("Chemical Type");
		chemTypeLabel.setVisible(true);

		String[] chemType = { "Acid", "Inorganic Salt", "Nitrate", "Metal", "Kitchen" };
		JComboBox<String> chemTypeBox = new JComboBox<String>(chemType);
		chemTypeBox.setSize(90, 20);
		chemTypeBox.setLocation(this.staticWidth / 9 - 3, this.staticHeight / 15 + 20);
		chemTypeBox.setVisible(true);

		JLabel amountLabel = new JLabel();
		amountLabel.setSize(80, 20);
		amountLabel.setLocation(this.staticWidth / 6 + 10, this.staticHeight / 15 + 40);
		amountLabel.setText("Enter Amount");
		amountLabel.setVisible(true);

		JTextField chemAmount = new JTextField();
		chemAmount.setSize(80, 20);
		chemAmount.setLocation(this.staticWidth / 6 + 10, this.staticHeight / 15 + 60);
		chemAmount.setVisible(true);

		JLabel restockLabel = new JLabel();
		restockLabel.setSize(120, 20);
		restockLabel.setLocation(this.staticWidth / 18 - 10, this.staticHeight / 15 + 40);
		restockLabel.setText("Restock Threshold");
		restockLabel.setVisible(true);

		JTextField restockAmount = new JTextField();
		restockAmount.setSize(80, 20);
		restockAmount.setLocation(this.staticWidth / 18, this.staticHeight / 15 + 60);
		restockAmount.setVisible(true);

		String[] unitTypes = { "mg", "g", "mL", "L" };
		JComboBox<String> units = new JComboBox<String>(unitTypes);
		units.setSize(60, 20);
		units.setLocation(this.staticWidth / 4 + 15, this.staticHeight / 15 + 60);
		units.setVisible(true);

		JButton addButton = new JButton();
		addButton.setSize(60, 20);
		addButton.setText("Add");
		addButton.setLocation(this.staticWidth / 9 + 15, this.staticHeight / 15 + 85);
		addButton.setVisible(true);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addButton.isEnabled()) {
					Chemicals newChem = new Chemicals(chemName.getText(), Double.parseDouble(molAmount.getText()),
							chemTypeBox.getSelectedItem().toString(), Double.parseDouble(chemAmount.getText()),
							Double.parseDouble(restockAmount.getText()), units.getSelectedItem().toString());
					newChem.designate();
					addChemFrame.dispose();
				}
			}
		});

		addChemPanel.add(nameLabel);
		addChemPanel.add(chemName);
		addChemPanel.add(molLabel);
		addChemPanel.add(molAmount);
		addChemPanel.add(molApplicableLabel);
		addChemPanel.add(chemTypeLabel);
		addChemPanel.add(chemTypeBox);
		addChemPanel.add(chemAmount);
		addChemPanel.add(amountLabel);
		addChemPanel.add(restockLabel);
		addChemPanel.add(restockAmount);
		addChemPanel.add(units);
		addChemPanel.add(addButton);
		addChemFrame.add(addChemPanel);
		addChemPanel.setVisible(true);
		addChemFrame.setVisible(true);
	}

	public void removeChemical() {
		JFrame removeChemFrame = new JFrame();
		JPanel removeChemPanel = new JPanel();
		JPanel removeChemPanelSelect = new JPanel();

		removeChemFrame.setSize(this.staticWidth / 3, this.staticHeight / 3);
		removeChemFrame.setLocation(new Point(((int) ((super.screenWidth - editChemFrame.getWidth()) / 2)) , ((int) ((super.screenHeight- editChemFrame.getHeight()) / 2))));
		removeChemFrame.setLayout(new BorderLayout());
		removeChemPanel.setSize(this.staticWidth / 3, this.staticHeight / 3 - 100);
		removeChemPanel.setLayout(new BoxLayout(removeChemPanel, BoxLayout.Y_AXIS));
		removeChemPanelSelect.setSize(this.staticWidth / 3, 20);
		removeChemFrame.setResizable(false);

		JLabel selectText = new JLabel();
		selectText.setText("Select a Chemical Type to Remove");
		selectText.setVisible(true);

		final JButton acidButton = new JButton();
		acidButton.setSize(new Dimension(160, 20));
		acidButton.setText("Acid");
		acidButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		acidButton.setVisible(true);
		acidButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (acidButton.isEnabled()) {
					removeChemFrame.dispose();
					try {
						EditChemicals.this.chemRemove("AcidStock.txt");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		final JButton inorgButton = new JButton();
		inorgButton.setSize(new Dimension(160, 20));
		inorgButton.setText("Inorganic Salt");
		inorgButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		inorgButton.setVisible(true);
		inorgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (acidButton.isEnabled()) {
					removeChemFrame.dispose();
					try {
						EditChemicals.this.chemRemove("InorganicSaltStock.txt");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		final JButton nitButton = new JButton();
		nitButton.setSize(new Dimension(160, 20));
		nitButton.setText("Nitrate");
		nitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		nitButton.setVisible(true);
		nitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (acidButton.isEnabled()) {
					removeChemFrame.dispose();
					try {
						EditChemicals.this.chemRemove("NitrateStock.txt");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		final JButton metButton = new JButton();
		metButton.setSize(new Dimension(160, 20));
		metButton.setText("Metal");
		metButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		metButton.setVisible(true);
		metButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (acidButton.isEnabled()) {
					removeChemFrame.dispose();
					try {
						EditChemicals.this.chemRemove("MetalStock.txt");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		final JButton kitButton = new JButton();
		kitButton.setSize(new Dimension(160, 20));
		kitButton.setText("Kitchen");
		kitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		kitButton.setVisible(true);
		kitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (acidButton.isEnabled()) {
					removeChemFrame.dispose();
					try {
						EditChemicals.this.chemRemove("KitchenStock.txt");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		removeChemPanelSelect.add(selectText);
		removeChemPanel.add(acidButton);
		removeChemPanel.add(inorgButton);
		removeChemPanel.add(nitButton);
		removeChemPanel.add(metButton);
		removeChemPanel.add(kitButton);
		removeChemFrame.add(removeChemPanelSelect, BorderLayout.NORTH);
		removeChemFrame.add(removeChemPanel, BorderLayout.SOUTH);
		removeChemPanelSelect.setVisible(true);
		removeChemPanel.setVisible(true);
		removeChemFrame.setVisible(true);
	}

	public void chemRemove(String fileName) throws FileNotFoundException {
		JFrame removeChemFrame = new JFrame();
		JPanel removeChemPanel = new JPanel();

		removeChemFrame.setSize(this.staticWidth / 3, this.staticHeight / 3);
		removeChemFrame.setLocation(new Point(((int) ((super.screenWidth - editChemFrame.getWidth()) / 2)) , ((int) ((super.screenHeight- editChemFrame.getHeight()) / 2))));
		removeChemPanel.setSize(this.staticWidth / 3, this.staticHeight / 3);
		removeChemPanel.setLayout(null);
		removeChemFrame.setResizable(false);

		JLabel nameLabel = new JLabel();
		nameLabel.setSize(180, 20);
		nameLabel.setLocation(this.staticWidth / 9 - 30, this.staticHeight / 12 - 20);
		nameLabel.setText("Select a Chemical to Remove");
		nameLabel.setVisible(true);

		File chemFile = new File(fileName);
		Scanner inputList = new Scanner(chemFile);
		ArrayList<String> chemList = new ArrayList<String>();
		ArrayList<String> completeChemList = new ArrayList<String>();
		while (inputList.hasNextLine()) {
			String line = inputList.nextLine();
			String[] lineList = line.split(" ");
			if (lineList[1].equals("0.0")) {
				chemList.add(lineList[0]);
			} else {
				chemList.add(lineList[0] + " " + lineList[1] + "M");
			}
			for (int i = 0; i < lineList.length; i++) {
				completeChemList.add(lineList[i]);
			}
		}

		JLabel amountLabel = new JLabel();
		amountLabel.setSize(80, 20);
		amountLabel.setLocation(this.staticWidth / 9 + 5, this.staticHeight / 12 + 20);
		amountLabel.setText("Enter Amount");
		amountLabel.setVisible(true);

		JTextField chemAmount = new JTextField();
		chemAmount.setSize(120, 20);
		chemAmount.setLocation(this.staticWidth / 9 - 15, this.staticHeight / 12 + 40);
		chemAmount.setVisible(true);

		JLabel units = new JLabel();
		units.setSize(60, 20);
		units.setLocation(this.staticWidth / 9 + 110, this.staticHeight / 12 + 40);
		units.setVisible(true);

		JComboBox<Object> chemNameBox = new JComboBox<Object>(chemList.toArray());
		chemNameBox.setSize(150, 20);
		chemNameBox.setLocation(this.staticWidth / 9 - 22, this.staticHeight / 12);
		for (int i = 0; i < completeChemList.size(); i++) {
			if (completeChemList.get(i).equals(chemNameBox.getSelectedItem().toString().split(" ")[0])) {
				units.setText(completeChemList.get(i + 4));
				chemAmount.setText(completeChemList.get(i + 2) + completeChemList.get(i + 4) + " available");
				chemAmount.setForeground(Color.GRAY);
				chemAmount.addFocusListener(new FocusListener() {
					public void focusGained(FocusEvent e) {
						chemAmount.setText("");
						chemAmount.setForeground(Color.BLACK);
					}

					public void focusLost(FocusEvent e) {
					}
				});
			}
		}
		chemNameBox.setVisible(true);
		chemNameBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < completeChemList.size(); i++) {
					if (completeChemList.get(i).equals(chemNameBox.getSelectedItem().toString().split(" ")[0])) {
						units.setText(completeChemList.get(i + 4));
						chemAmount.setText(completeChemList.get(i + 2) + completeChemList.get(i + 4) + " available");
						chemAmount.setForeground(Color.GRAY);
						chemAmount.addFocusListener(new FocusListener() {
							public void focusGained(FocusEvent e) {
								chemAmount.setText("");
								chemAmount.setForeground(Color.BLACK);
							}

							public void focusLost(FocusEvent e) {
							}
						});
					}
				}
			}
		});

		JButton removeButton = new JButton();
		removeButton.setSize(80, 20);
		removeButton.setText("Remove");
		removeButton.setLocation(this.staticWidth / 9 + 5, this.staticHeight / 12 + 65);
		removeButton.setVisible(true);
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (removeButton.isEnabled()) {
					for (int i = 0; i < completeChemList.size(); i++) {
						if (completeChemList.get(i).equals(chemNameBox.getSelectedItem().toString().split(" ")[0])) {
							DecimalFormat format = new DecimalFormat("0.0");
							if(Double.parseDouble(completeChemList.get(i + 2)) - Double.parseDouble(chemAmount.getText()) < 0) {
								JOptionPane.showMessageDialog(editChemFrame, "Removing that much would make negative stock!");
							} else {
								completeChemList.set(i + 2, format.format(Double.parseDouble(completeChemList.get(i + 2))
									- Double.parseDouble(chemAmount.getText())));
								if (completeChemList.get(i + 2).equals("0.0")) {
									completeChemList.remove(i);
									completeChemList.remove(i);
									completeChemList.remove(i);
									completeChemList.remove(i);
									completeChemList.remove(i);
								}
								try (FileWriter fileWriter = new FileWriter(fileName, false);
										BufferedWriter buffWriter = new BufferedWriter(fileWriter);
										PrintWriter printWriter = new PrintWriter(buffWriter)) {
									for (int j = 0; j < completeChemList.size(); j++) {
										printWriter.print(completeChemList.get(j) + " ");
										if (completeChemList.get(j).equals("mg") || completeChemList.get(j).equals("g")
												|| completeChemList.get(j).equals("mL") || completeChemList.get(j).equals("L")) {
											printWriter.println();
										}
									}
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								removeChemFrame.dispose();
							}
						}
					}
					
				}
			}
		});

		removeChemPanel.add(nameLabel);
		removeChemPanel.add(chemNameBox);
		removeChemPanel.add(amountLabel);
		removeChemPanel.add(chemAmount);
		removeChemPanel.add(units);
		removeChemPanel.add(removeButton);
		removeChemFrame.add(removeChemPanel);
		removeChemPanel.setVisible(true);
		removeChemFrame.setVisible(true);
	}

	public void editChemicalNoGUI(File fileName, String chemAmount, int rowPos, int colPos) throws IOException {

		Scanner inputList = new Scanner(fileName);
		ArrayList<String> chemList = new ArrayList<String>();
		ArrayList<String> completeChemList = new ArrayList<String>();
		while (inputList.hasNextLine()) {
			String line = inputList.nextLine();
			String[] lineList = line.split(" ");
			if (lineList[1].equals("0.0")) {
				chemList.add(lineList[0]);
			} else {
				chemList.add(lineList[0] + " " + lineList[1] + "M");
			}
			for (int i = 0; i < lineList.length; i++) {
				completeChemList.add(lineList[i]);
			}
		}
		if(Double.parseDouble(chemAmount) > 0) {
			completeChemList.set(colPos + (rowPos * 5), chemAmount);
		}
		else {
			for (int i = 0; i < 5; i++) {
				completeChemList.remove((colPos + (rowPos * 5)) - 2);
			}
		}
		try (FileWriter fileWriter = new FileWriter(fileName, false);
				BufferedWriter buffWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(buffWriter)) {
			for (int i = 0; i < completeChemList.size(); i++) {
				printWriter.print(completeChemList.get(i) + " ");
				if (completeChemList.get(i).equals("mg") || completeChemList.get(i).equals("g")
						|| completeChemList.get(i).equals("mL") || completeChemList.get(i).equals("L")) {
					printWriter.println();
				}

			}
		}
	}
	
	public void addChemicalTableButton(String tableName, JFrame chemicalFrame) {
		
		JFrame addChemFrame = new JFrame();
		JPanel addChemPanel = new JPanel();

		addChemFrame.setSize(this.staticWidth / 3 - 20, this.staticHeight / 3 - 40);
		addChemFrame.setLocation(new Point(((int) ((super.screenWidth - addChemFrame.getWidth()) / 2)) , ((int) ((super.screenHeight- addChemFrame.getHeight()) / 2))));
		addChemPanel.setSize(this.staticWidth / 3, this.staticHeight / 3);
		addChemPanel.setLayout(null);
		addChemFrame.setResizable(false);

		JLabel nameLabel = new JLabel();
		nameLabel.setSize(180, 20);
		nameLabel.setLocation(this.staticWidth / 9 - 10, this.staticHeight / 24 - 25);
		nameLabel.setText("Name of Chemical");
		nameLabel.setVisible(true);

		JTextField chemName = new JTextField();
		chemName.setSize(150, 20);
		chemName.setLocation(this.staticWidth / 9 - 35, this.staticHeight / 30);
		chemName.setVisible(true);

		JLabel molLabel = new JLabel();
		molLabel.setSize(50, 20);
		molLabel.setLocation(this.staticWidth / 9 + 123, this.staticHeight / 24 - 25);
		molLabel.setText("Molarity");
		molLabel.setVisible(true);

		JTextField molAmount = new JTextField();
		molAmount.setSize(30, 20);
		molAmount.setLocation(this.staticWidth / 9 + 130, this.staticHeight / 30);
		molAmount.setText("0");
		molAmount.setVisible(true);

		JLabel molApplicableLabel = new JLabel();
		molApplicableLabel.setSize(50, 20);
		molApplicableLabel.setLocation(this.staticWidth / 9 + 125, this.staticHeight / 24 + 10);
		molApplicableLabel.setText("0 if N/A");
		molApplicableLabel.setVisible(true);

		JLabel amountLabel = new JLabel();
		amountLabel.setSize(80, 20);
		amountLabel.setLocation(this.staticWidth / 6, this.staticHeight / 15 + 10);
		amountLabel.setText("Enter Amount");
		amountLabel.setVisible(true);

		JTextField chemAmount = new JTextField();
		chemAmount.setSize(80, 20);
		chemAmount.setLocation(this.staticWidth / 6, this.staticHeight / 15 + 30);
		chemAmount.setVisible(true);

		JLabel restockLabel = new JLabel();
		restockLabel.setSize(120, 20);
		restockLabel.setLocation(this.staticWidth / 18 - 15, this.staticHeight / 15 + 10);
		restockLabel.setText("Restock Threshold");
		restockLabel.setVisible(true);

		JTextField restockAmount = new JTextField();
		restockAmount.setSize(80, 20);
		restockAmount.setLocation(this.staticWidth / 18 , this.staticHeight / 15 + 30);
		restockAmount.setVisible(true);

		String[] unitTypes = { "mg", "g", "mL", "L" };
		JComboBox<String> units = new JComboBox<String>(unitTypes);
		units.setSize(50, 20);
		units.setLocation(this.staticWidth / 4 + 5, this.staticHeight / 15 + 30);
		units.setVisible(true);

		JButton addButton = new JButton();
		addButton.setSize(60, 20);
		addButton.setText("Add");
		addButton.setLocation(this.staticWidth / 9 + 10, this.staticHeight / 15 + 55);
		addButton.setVisible(true);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addButton.isEnabled()) {
					Chemicals newChem = new Chemicals(chemName.getText(), Double.parseDouble(molAmount.getText()),
							tableName, Double.parseDouble(chemAmount.getText()),
							Double.parseDouble(restockAmount.getText()), units.getSelectedItem().toString());
					newChem.designate();
					addChemFrame.dispose();
					chemicalFrame.dispose();
					try {
						if(!tableName.equals("Kitchen")) {
							newChem.display(tableName+"s");
						} else {
							newChem.display(tableName);
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		addChemPanel.add(nameLabel);
		addChemPanel.add(chemName);
		addChemPanel.add(molLabel);
		addChemPanel.add(molAmount);
		addChemPanel.add(molApplicableLabel);
		addChemPanel.add(chemAmount);
		addChemPanel.add(amountLabel);
		addChemPanel.add(restockLabel);
		addChemPanel.add(restockAmount);
		addChemPanel.add(units);
		addChemPanel.add(addButton);
		addChemFrame.add(addChemPanel);
		addChemPanel.setVisible(true);
		addChemFrame.setVisible(true);
	}
}
