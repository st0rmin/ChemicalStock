import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class Chemicals extends GUI {
	private static final long serialVersionUID = 1L;
	JFrame chemFrame = new JFrame();
	JPanel chemPanel = new JPanel();
	int chemFrameWidth = (int) (super.frameWidth * 1.5);
	int chemFrameHeight = (int) (super.frameHeight * 1.2);
	private String name;
	private double molarity;
	private String type;
	private double amount;
	private String unit;
	private double restockAmt;

	public Chemicals() {

	}

	public Chemicals(String name, double mol, String type, double amt, double restock, String unit) {
		this.name = name;
		this.molarity = mol;
		this.type = type;
		this.amount = amt;
		this.restockAmt = restock;
		this.unit = unit;
	}

	public void designate() {
		switch (type) {
		case "Acid":
			Acids newAcid = new Acids(name, molarity, amount, restockAmt, unit);
			break;
		case "Inorganic Salt":
			InorganicSalts newInorg = new InorganicSalts(name, molarity, amount, restockAmt, unit);
			break;
		case "Nitrate":
			Nitrates newNit = new Nitrates(name, molarity, amount, restockAmt, unit);
			break;
		case "Metal":
			Metals newMetal = new Metals(name, molarity, amount, restockAmt, unit);
			break;
		case "Kitchen":
			Kitchen newKitchen = new Kitchen(name, molarity, amount, restockAmt, unit);
			break;
		default:
			break;
		}
	}

	public void store(String fileName, String chemLine) {
		try (FileWriter fileWrite = new FileWriter(fileName, true);
				BufferedWriter buffWrite = new BufferedWriter(fileWrite);
				PrintWriter printWrite = new PrintWriter(buffWrite)) {
			printWrite.println(chemLine);
		} catch (IOException e) {

		}
	}

	public void chemPanelAdd() throws FileNotFoundException {

		chemFrame.setSize(chemFrameWidth, chemFrameHeight);
		chemPanel.setSize(chemFrameWidth, chemFrameHeight);
		chemFrame.setLocation(new Point(((int) ((screenWidth - chemFrame.getWidth()) / 2)),
				((int) ((screenHeight - chemFrame.getHeight()) / 2))));
		chemFrame.setDefaultCloseOperation(3);
		chemFrame.setTitle("Chemical Stock");
		chemFrame.setResizable(false);
		guiFrame.setVisible(false);
		chemPanel.setLayout(null);
		ImageIcon title = new ImageIcon(getClass().getResource("/images/title.png"));
		JLabel titleLabel = new JLabel(title);
		titleLabel.setLocation((chemFrame.getWidth() - title.getIconWidth()) / 2, chemFrame.getHeight() - 550);
		titleLabel.setSize(new Dimension(title.getIconWidth(), title.getIconHeight()));
		titleLabel.setVisible(true);

		final JButton editChem = new JButton();
		editChem.setSize(new Dimension(160, 20));
		editChem.setText("Edit Chemicals");
		editChem.setLocation(chemFrame.getWidth() - 420, chemFrame.getHeight() - 340);
		editChem.setVisible(true);
		editChem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editChem.isEnabled()) {
					EditChemicals openEdit = new EditChemicals();
					openEdit.editChemicalsCreate();
				}
			}
		});
		JButton acidsButton = new JButton();
		acidsButton.setSize(new Dimension(120, 20));
		acidsButton.setText("Acids");
		acidsButton.setLocation(chemFrame.getWidth() - 660, chemFrame.getHeight() - 420);
		acidsButton.setVisible(true);
		acidsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (acidsButton.isEnabled()) {
					Acids acid = new Acids();
					try {
						acid.display();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					chemFrame.dispose();
				}
			}
		});

		JButton inorgButton = new JButton();
		inorgButton.setSize(new Dimension(120, 20));
		inorgButton.setText("Inorganic Salts");
		inorgButton.setLocation(chemFrame.getWidth() - 660, chemFrame.getHeight() - 380);
		inorgButton.setVisible(true);
		inorgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inorgButton.isEnabled()) {
					InorganicSalts inorg = new InorganicSalts();
					try {
						inorg.display();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					chemFrame.dispose();
				}
			}
		});

		JButton nitratesButton = new JButton();
		nitratesButton.setSize(new Dimension(120, 20));
		nitratesButton.setText("Nitrates");
		nitratesButton.setLocation(chemFrame.getWidth() - 660, chemFrame.getHeight() - 340);
		nitratesButton.setVisible(true);
		nitratesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nitratesButton.isEnabled()) {
					Nitrates nitrate = new Nitrates();
					try {
						nitrate.display();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					chemFrame.dispose();
				}
			}
		});

		JButton metalsButton = new JButton();
		metalsButton.setSize(new Dimension(120, 20));
		metalsButton.setText("Metals");
		metalsButton.setLocation(chemFrame.getWidth() - 660, chemFrame.getHeight() - 300);
		metalsButton.setVisible(true);
		metalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (metalsButton.isEnabled()) {
					Metals metal = new Metals();
					try {
						metal.display();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					chemFrame.dispose();
				}
			}
		});

		JButton kitchenButton = new JButton();
		kitchenButton.setSize(new Dimension(120, 20));
		kitchenButton.setText("Kitchen");
		kitchenButton.setLocation(chemFrame.getWidth() - 660, chemFrame.getHeight() - 260);
		kitchenButton.setVisible(true);
		kitchenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kitchenButton.isEnabled()) {
					Kitchen kit = new Kitchen();
					try {
						kit.display();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					chemFrame.dispose();
				}
			}
		});

		JLabel restockLabel = new JLabel();
		restockLabel.setText("Chemicals to Restock");
		restockLabel.setFont((restockLabel.getFont().deriveFont(14.0f)));
		restockLabel.setSize(180, 20);
		restockLabel.setLocation(chemFrame.getWidth() - 248, chemFrame.getHeight() - 317);
		restockLabel.setVisible(true);

		chemPanel.add(restockLabel);
		chemPanel.add(acidsButton);
		chemPanel.add(inorgButton);
		chemPanel.add(nitratesButton);
		chemPanel.add(metalsButton);
		chemPanel.add(kitchenButton);
		chemPanel.add(editChem);
		chemPanel.add(titleLabel);
		chemFrame.add(chemPanel);
		chemPanel.add(new RestockWarning().create());
		chemPanel.setVisible(true);
		chemFrame.setVisible(true);
	}

	public void display(String chemType) throws FileNotFoundException {

		JPanel chemTablePanel = new JPanel();
		JPanel chemTitlePanel = new JPanel();
		String fileName = "";

		switch (chemType) {
		case "Acids":
			fileName = "AcidStock.txt";
			break;
		case "Inorganic Salts":
			fileName = "InorganicSaltStock.txt";
			break;
		case "Nitrates":
			fileName = "NitrateStock.txt";
			break;
		case "Metals":
			fileName = "MetalStock.txt";
			break;
		case "Kitchen":
			fileName = "KitchenStock.txt";
			break;
		default:
			break;
		}

		File stockFile = new File(fileName);
		if(stockFile.exists()) {
			chemFrame.setSize(chemFrameWidth, chemFrameHeight);
			chemPanel.setSize(chemFrameWidth, chemFrameHeight);
			chemFrame.setTitle("Chemical Stock");
			chemFrame.setLocation(new Point(((int) ((screenWidth - chemFrame.getWidth()) / 2)),
					((int) ((screenHeight - chemFrame.getHeight()) / 2))));
			chemTablePanel.setSize(chemFrame.getWidth(), chemFrame.getHeight());
			chemTitlePanel.setSize(chemFrame.getWidth(), chemFrame.getHeight() / 5);
			chemFrame.setDefaultCloseOperation(3);
			chemTitlePanel.setMaximumSize(new Dimension(chemFrame.getWidth(), chemFrame.getHeight() / 5));
			chemTablePanel.setBounds(0, chemTitlePanel.getHeight(), chemFrame.getWidth(), chemFrame.getHeight());
			chemFrame.setResizable(false);
			chemPanel.setLayout(new BoxLayout(chemPanel, BoxLayout.Y_AXIS));
			chemTablePanel.setLayout(new BoxLayout(chemTablePanel, BoxLayout.Y_AXIS));
			chemFrame.setVisible(true);
			chemPanel.setVisible(true);
			chemTitlePanel.setVisible(true);
			chemTablePanel.setVisible(true);

			JLabel title = new JLabel();
			title.setText(chemType);
			title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 48));
			title.setVisible(true);

			File chemStock = new File(fileName);
			Scanner inText = new Scanner(chemStock);
			ArrayList<String> dataList = new ArrayList<String>();
			while (inText.hasNextLine()) {
				dataList.add(inText.nextLine());
			}

			String[] columnTitles;
			String[][] data2D;
			if (chemType.equals("Metals") || chemType.equals("Kitchen")) {
				data2D = new String[dataList.size()][4];
				for (int i = 0; i < data2D.length; i++) {
					for (int j = 0; j < data2D[0].length; j++) {
						if (j <= 1) {
							if (!dataList.get(i).split(" ")[j].equals("0.0")) {
								data2D[i][j] = dataList.get(i).split(" ")[j];
							} else {
								data2D[i][j] = dataList.get(i).split(" ")[j + 1];

							}
						} else if (j > 1) {
							data2D[i][j] = dataList.get(i).split(" ")[j + 1];
						}
					}
				}
				columnTitles = new String[] { "Chemical Name", "Amount", "Restock Threshold", "Unit" };
			} else {
				data2D = new String[dataList.size()][5];
				for (int i = 0; i < data2D.length; i++) {
					for (int j = 0; j < data2D[0].length; j++) {
						data2D[i][j] = dataList.get(i).split(" ")[j];
					}
				}
				columnTitles = new String[] { "Chemical Name", "Molarity", "Amount", "Restock Threshold", "Unit" };
			}

			JTable chemTable = new JTable(data2D, columnTitles) {
				public boolean isCellEditable(int row, int column) {
					if (chemType.equals("Metals") || chemType.equals("Kitchen")) {
						if (column == 1 || column == 2) {
							return true;
						} else {
							return false;
						}
					} else {
						if (column == 2 || column == 3) {
							return true;
						} else {
							return false;
						}
					}
				};
			};
			chemTable.getTableHeader().setReorderingAllowed(false);
			chemTable.setLocation(0, chemTablePanel.getHeight());
			chemTable.getModel().addTableModelListener(new TableModelListener() {
				public void tableChanged(TableModelEvent e) {
					int rowNum = e.getFirstRow();
					int colNum = e.getColumn();
					DecimalFormat format = new DecimalFormat("0.0");
					if (Double.parseDouble((String) chemTable.getValueAt(rowNum, colNum)) < 0) {
						JOptionPane.showMessageDialog(chemFrame, "Value can't be negative!");
					} else {
						String value = (String) format
								.format(Double.parseDouble((String) chemTable.getValueAt(rowNum, colNum)));
						EditChemicals edit = new EditChemicals();
						try {
							if (chemType.equals("Metals") || chemType.equals("Kitchen")) {
								edit.editChemicalNoGUI(stockFile, value, rowNum, colNum + 1);
							} else {
								edit.editChemicalNoGUI(stockFile, value, rowNum, colNum);
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
			JScrollPane scrollPane = new JScrollPane(chemTable);
			scrollPane.setLocation(0, chemTitlePanel.getHeight());
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

			JButton backButton = new JButton();
			backButton.setText("Back");
			backButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
			backButton.setVisible(true);
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (backButton.isEnabled()) {
						chemFrame.dispose();
						Chemicals openChem = new Chemicals();
						try {
							openChem.chemPanelAdd();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

			JButton addButton = new JButton();
			addButton.setText("Add");
			addButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
			addButton.setVisible(true);
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (addButton.isEnabled()) {
						EditChemicals tableEdit = new EditChemicals();
						if (!chemType.equals("Kitchen")) {
							tableEdit.addChemicalTableButton(chemType.substring(0, chemType.length() - 1), chemFrame);
						} else {
							tableEdit.addChemicalTableButton(chemType, chemFrame);
						}
					}
				}
			});

			chemTitlePanel.add(addButton);
			chemTitlePanel.add(title);
			chemTitlePanel.add(backButton);
			chemTablePanel.add(scrollPane);
			chemPanel.add(chemTitlePanel);
			chemPanel.add(chemTablePanel);
			chemFrame.add(chemPanel);
		} else {
			JOptionPane.showMessageDialog(chemFrame,"You must add chemicals in using the Edit Chemicals button before viewing the table!");
			chemPanelAdd();
		}
	}
}
