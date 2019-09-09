package chemicalstock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Acids.java;
import Chemicals.java;
import EditChemicals.java;
import InorganicSalts.java;
import Kitchen.java;
import Login.java;
import Metals.java;
import Nitrates.java;
import RestockWarning.java;


public class GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame guiFrame = new JFrame();
	JPanel guiPanel = new JPanel();
	JButton loginButton = new JButton();
	int frameWidth = 640;
	int frameHeight = 480;
	int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();;
	Point frameLoc = new Point(((int) ((screenWidth - frameWidth) / 2)) , ((int) ((screenHeight- frameHeight) / 2)));
	

	public GUI() {
		
	}
	
	public void startGUI() {
		guiFrame.setDefaultCloseOperation(3);
		guiFrame.setSize(frameWidth, frameHeight);
		guiFrame.setResizable(false);
	    guiFrame.setLocation(frameLoc);
		guiFrame.setTitle("Chemical Stock");
		
		guiPanel.add(this);
		guiPanel.setVisible(true);

		guiFrame.add(guiPanel);
		guiFrame.add(this);

		loginButton.setText("Login");
		loginButton.setBackground(Color.WHITE);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loginButton.isEnabled()) {
					Login openLogin = new Login();
					openLogin.loginPanelAdd();
					guiFrame.dispose();
				}
			}
		});
		add(loginButton);

		guiFrame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(200, 10, 240, 40);
		loginButton.setBounds(270, 240, 100, 30);
		g.drawString("Mrs. Rushing's Stock Program", 240, 35);
		repaint();
	}
	
	public static void main(String[] args) {
		GUI test = new GUI();
		test.startGUI();
	}
}
