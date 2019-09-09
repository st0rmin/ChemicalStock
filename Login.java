package chemicalstock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends GUI {
	private static final long serialVersionUID = 1L;
	JFrame loginFrame = new JFrame();
	JPanel loginPanel = new JPanel();

	public void loginPanelAdd() {
		loginFrame.setSize(super.frameWidth, super.frameHeight);
		loginPanel.setSize(super.frameWidth, super.frameHeight);
		loginFrame.setLocation(super.frameLoc);
		loginFrame.setDefaultCloseOperation(3);
		loginFrame.setResizable(false);
		loginFrame.setTitle("Chemical Stock");
		guiFrame.setVisible(false);
		loginPanel.setLayout(null);

		ImageIcon flask = new ImageIcon(getClass().getResource("flask.png"));
		JLabel flaskLabel = new JLabel(flask);
		flaskLabel.setLocation((int) (loginFrame.getSize().getWidth() / 2 - 110), 20);
		flaskLabel.setSize(new Dimension(flask.getIconWidth(), flask.getIconHeight()));
		flaskLabel.setVisible(true);

		final JTextField username = new JTextField(20);
		username.setBackground(Color.WHITE);
		username.setSize(new Dimension(150, 20));
		username.setLocation((int) (loginFrame.getSize().getWidth() / 2 - 90), (int) (loginFrame.getSize().getHeight() / 2 + 70));
		username.setVisible(true);

		JLabel usernameLabel = new JLabel();
		usernameLabel.setSize(new Dimension(150, 20));
		usernameLabel.setLocation((int) (loginFrame.getSize().getWidth() / 2 - 45), (int) (loginFrame.getSize().getHeight() / 2 + 50));
		usernameLabel.setText("Username");
		usernameLabel.setVisible(true);

		final JPasswordField password = new JPasswordField(20);
		password.setBackground(Color.WHITE);
		password.setEchoChar('*');
		password.setSize(new Dimension(150, 20));
		password.setLocation((int) (loginFrame.getSize().getWidth() / 2 - 90), (int) (loginFrame.getSize().getHeight() / 2 + 110));
		password.setVisible(true);

		JLabel passwordLabel = new JLabel();
		passwordLabel.setSize(new Dimension(150, 20));
		passwordLabel.setLocation((int) (loginFrame.getSize().getWidth() / 2 - 45), (int) (loginFrame.getSize().getHeight() / 2 + 90));
		passwordLabel.setText("Password");
		passwordLabel.setVisible(true);

		final JButton enter = new JButton();
		enter.setSize(new Dimension(80, 20));
		enter.setText("Enter");
		enter.setLocation((int) (loginFrame.getSize().getWidth() / 2 - 55), (int) (loginFrame.getSize().getHeight() / 2 + 140));
		enter.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (enter.isEnabled()) {
					String actualUsername = "test";
					String actualPassword = "test";
					if ((actualUsername.equals(username.getText())) && (actualPassword.equals(password.getText()))) {
						loginFrame.dispose();
						Chemicals openChem = new Chemicals();
						try {
							openChem.chemPanelAdd();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(loginFrame,
								"The username or password is incorrect. Please check your username and retype your password.");
					}
				}
			}
		});
		enter.setVisible(true);

		loginPanel.add(flaskLabel);
		loginPanel.add(usernameLabel);
		loginPanel.add(username);
		loginPanel.add(password);
		loginPanel.add(passwordLabel);
		loginPanel.add(enter);
		loginFrame.add(loginPanel);

		loginPanel.setVisible(true);
		loginFrame.setVisible(true);
	}
}
