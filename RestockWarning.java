package chemicalstock;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RestockWarning extends Chemicals {

	public RestockWarning() {

	}

	public JPanel create() throws FileNotFoundException {

		JPanel restockPanel = new JPanel();
		restockPanel.setSize(350, 300);
		restockPanel.setLocation(super.chemFrameWidth - 350, super.chemFrameHeight - 300);
		restockPanel.setVisible(true);
		restockPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

		JPanel restockDataPanel = new JPanel();
		restockDataPanel.setLocation(super.chemFrameWidth - 350, super.chemFrameHeight - 300);
		restockDataPanel.setVisible(true);
		restockDataPanel.setLayout(new BoxLayout(restockDataPanel, BoxLayout.Y_AXIS));

		ArrayList<String> acidList = displayRestockChem("AcidStock.txt");
		if (acidList.size() > 0) {
			JLabel acidTitle = new JLabel();
			acidTitle.setText("Acids");
			acidTitle.setFont((acidTitle.getFont().deriveFont(14.0f)));
			restockDataPanel.add(acidTitle);
			for (int i = 0; i < acidList.size(); i++) {
				JLabel acid = new JLabel();
				acid.setText("        " + acidList.get(i));
				restockDataPanel.add(acid);
			}
		}

		ArrayList<String> inorgList = displayRestockChem("InorganicSaltStock.txt");
		if (inorgList.size() > 0) {
			JLabel inorgTitle = new JLabel();
			inorgTitle.setText("Inorganic Salts");
			inorgTitle.setFont((inorgTitle.getFont().deriveFont(14.0f)));
			restockDataPanel.add(inorgTitle);
			for (int i = 0; i < inorgList.size(); i++) {
				JLabel inorg = new JLabel();
				inorg.setText("        " + inorgList.get(i));
				restockDataPanel.add(inorg);
			}
		}

		ArrayList<String> nitList = displayRestockChem("NitrateStock.txt");
		if (nitList.size() > 0) {
			JLabel nitTitle = new JLabel();
			nitTitle.setText("Nitrates");
			nitTitle.setFont((nitTitle.getFont().deriveFont(14.0f)));
			restockDataPanel.add(nitTitle);
			for (int i = 0; i < nitList.size(); i++) {
				JLabel nit = new JLabel();
				nit.setText("        " + nitList.get(i));
				restockDataPanel.add(nit);
			}
		}

		ArrayList<String> metList = displayRestockChem("MetalStock.txt");
		if (metList.size() > 0) {
			JLabel metTitle = new JLabel();
			metTitle.setText("Metals");
			metTitle.setFont((metTitle.getFont().deriveFont(14.0f)));
			restockDataPanel.add(metTitle);
			for (int i = 0; i < metList.size(); i++) {
				JLabel met = new JLabel();
				met.setText("        " + metList.get(i));
				restockDataPanel.add(met);
			}
		}

		ArrayList<String> kitList = displayRestockChem("KitchenStock.txt");
		if (kitList.size() > 0) {
			JLabel kitTitle = new JLabel();
			kitTitle.setText("Kitchen");
			kitTitle.setFont((kitTitle.getFont().deriveFont(14.0f)));
			restockDataPanel.add(kitTitle);
			for (int i = 0; i < kitList.size(); i++) {
				JLabel kit = new JLabel();
				kit.setText("        " + kitList.get(i));
				restockDataPanel.add(kit);
			}
		}

		JScrollPane restockScrollPane = new JScrollPane(restockDataPanel);
		restockScrollPane.setPreferredSize(new Dimension(restockPanel.getWidth() - 10, restockPanel.getHeight() - 40));
		restockScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		restockScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		restockScrollPane.setBorder(null);

		restockPanel.add(restockScrollPane);

		return restockPanel;
	}

	public ArrayList<String> displayRestockChem(String fileName) throws FileNotFoundException {

		File chemFile = new File(fileName);
		ArrayList<String> chemList = new ArrayList<String>();
		List<List<String>> completeChemList = new ArrayList<List<String>>();
		if (chemFile.exists()) {
			Scanner inputList = new Scanner(chemFile);
			while (inputList.hasNextLine()) {
				String line = inputList.nextLine();
				String[] lineList = line.split(" ");
				List<String> lineArrayList = Arrays.asList(lineList);
				completeChemList.add(lineArrayList);
			}
			for (int i = 0; i < completeChemList.size(); i++) {
				for (int j = 0; j < completeChemList.get(i).size(); j++) {
					if (j == 3) {
						if (Double.parseDouble(completeChemList.get(i).get(j)) >= Double
								.parseDouble(completeChemList.get(i).get(j - 1))) {
							if (Double.parseDouble(completeChemList.get(i).get(j - 2)) != 0) {
								chemList.add(completeChemList.get(i).get(j - 3) + " "
										+ completeChemList.get(i).get(j - 2) + " M");
							} else {
								chemList.add(completeChemList.get(i).get(j - 3));
							}
						}
					}
				}
			}
		}
		return chemList;
	}
}
