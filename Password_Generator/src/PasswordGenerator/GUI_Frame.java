package PasswordGenerator;

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

public class GUI_Frame extends JFrame implements ActionListener {
	JComboBox comboBox;
	JLabel label;
	JPanel panel;
	JButton button;
	
	public GUI_Frame() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Password Generator");
		//this.setLayout(null);
		
		String[] passwordOptions = {"Generator", "Encryption", "Decryption"};
		GridBagConstraints gbc = new GridBagConstraints();
		comboBox = new JComboBox(passwordOptions);
		label = new JLabel("Choose password option: ");
		panel = new JPanel();
		button = new JButton("Enter");
		panel.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		panel.add(label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		panel.add(comboBox, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5, 100, 5, 5); // gaps from top, left, right, bottom
		panel.add(button, gbc);
		
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,10,10));
		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
