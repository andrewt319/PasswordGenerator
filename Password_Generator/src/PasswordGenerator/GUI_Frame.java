package PasswordGenerator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_Frame extends JFrame implements ActionListener {
	JComboBox comboBox;
	JLabel promptLabel;
	JLabel popUpLabel;
	JLabel key1Label;
	JLabel key2Label;
	JPanel panel;
	JButton enterButton;
	JButton submitButton;
	JFrame popUpFrame;
	JTextField passwordText;
	JTextField key1Text;
	JTextField key2Text;
	JPanel popUpPanel;
	
	public GUI_Frame() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Password Generator");
		this.setLocationRelativeTo(null);
		
		String[] passwordOptions = {"Generator", "Vernam Encryption", "Vigenere Encryption", 
									"Vernam Decryption", "Vigenere Decryption"};
		GridBagConstraints gbc = new GridBagConstraints();
		comboBox = new JComboBox(passwordOptions);
		promptLabel = new JLabel("Choose password option: ");
		panel = new JPanel();
		enterButton = new JButton("Enter");
		enterButton.setPreferredSize(new Dimension(65,20));
		enterButton.addActionListener(this);
		panel.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		panel.add(promptLabel, gbc);
		
		gbc.gridx = 1;
		gbc.insets = new Insets(0,-20,0,0);
		
		panel.add(comboBox, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(10, 125, 5, 5); // gaps from top, left, bottom, right
		panel.add(enterButton, gbc);
		
		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enterButton) {
			GridBagConstraints gbc = new GridBagConstraints();
			popUpFrame = new JFrame();
			popUpPanel = new JPanel();
			passwordText = new JTextField();
			popUpLabel = new JLabel();
			submitButton = new JButton("Submit");
			submitButton.addActionListener(this);
			popUpFrame.setSize(500,200);
			popUpFrame.setLocationRelativeTo(null);
			popUpPanel.setLayout(new GridBagLayout());
			
			passwordText.setPreferredSize(new Dimension(150, 20));
			
			switch ((String) comboBox.getSelectedItem()) {
				case "Generator":
					popUpFrame.setTitle("Password Generator");
					popUpLabel.setText("Enter number of characters: ");
					generatorFrame(gbc);
					break;
				case "Vernam Encryption":
					popUpFrame.setTitle("Vernam Encryption");
					popUpLabel.setText("Enter password to encrypt (vernam): ");
					twoKeyFrames(gbc);
					break;
				case "Vigenere Encryption":
					popUpFrame.setTitle("Vigenere Encryption: ");
					popUpLabel.setText("Enter password to encrypt (vigenere): ");
					oneKeyFrame(gbc);
					break;
				case "Vernam Decryption":
					popUpFrame.setTitle("Vernam Decryption");
					popUpLabel.setText("Enter password to decrypt (vernam): ");
					twoKeyFrames(gbc);
					break;
				case "Vigenere Decryption":
					popUpFrame.setTitle("Vigenere Decryption");
					popUpLabel.setText("Enter password to decrypt (decrypt): ");
					oneKeyFrame(gbc);
					break;
			}
			popUpFrame.add(popUpPanel);
			popUpFrame.setVisible(true);
		}
		
		if (e.getSource() == submitButton) {
			System.out.println("hello");
		}
		
	}
	
	private boolean twoKeyFrames(GridBagConstraints gbc) {
		key1Text = new JTextField();
		key2Text = new JTextField();
		key1Text.setPreferredSize(new Dimension(150,20));
		key2Text.setPreferredSize(new Dimension(150,20));
		key1Label = new JLabel("Enter key #1: ");
		key2Label = new JLabel("Enter key #2: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,0,0,0);
		popUpPanel.add(popUpLabel, gbc); // 0,0
		gbc.gridx = 1; 
		popUpPanel.add(passwordText, gbc); // 1,0
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.insets = new Insets(10,0,0,0);
		popUpPanel.add(key1Label, gbc); // 0,1
		gbc.gridx = 1;
		popUpPanel.add(key1Text, gbc); // 1,1
		
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.insets = new Insets(10,0,0,0);
		popUpPanel.add(key2Label, gbc); // 0 ,2
		gbc.gridx = 1;
		gbc.insets = new Insets(10,0,0,0);
		popUpPanel.add(key2Text, gbc); // 1,2
		
		gbc.insets = new Insets(10,0,0,0);
		gbc.gridy = 3;
		gbc.insets = new Insets(10,0,0,0);
		popUpPanel.add(submitButton, gbc);
		return true;
	}
	
	private boolean oneKeyFrame(GridBagConstraints gbc) {
		key1Text = new JTextField();
		key1Text.setPreferredSize(new Dimension(150,20));
		key1Label = new JLabel("Enter key #1: ");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,0,0,0);
		popUpPanel.add(popUpLabel, gbc); // 0,0
		gbc.gridx = 1; 
		popUpPanel.add(passwordText, gbc); // 1,0
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.insets = new Insets(10,0,0,0);
		popUpPanel.add(key1Label, gbc); // 0,1
		gbc.gridx = 1;
		popUpPanel.add(key1Text, gbc); // 1,1
		
		gbc.insets = new Insets(10,0,0,0);
		gbc.gridy = 2;
		gbc.insets = new Insets(10,0,0,0);
		popUpPanel.add(submitButton, gbc);
		return true;
	}
	
	private boolean generatorFrame(GridBagConstraints gbc) {
		gbc.gridx = 0;
		gbc.gridy = 0;
		popUpPanel.add(popUpLabel, gbc);
		
		gbc.gridx = 1;
		popUpPanel.add(passwordText, gbc);
		
		gbc.gridy = 2;
		gbc.insets = new Insets(10,0,0,0);
		popUpPanel.add(submitButton, gbc);
		return true;
	}
}
