package PasswordGenerator;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This file checks for invalid inputs in the textfields for GUI_Frame class.
 * This includes null, character inputs, number inputs, and empty strings.
 */
public class ErrorChecker {
	JFrame errorFrame;
	JLabel errorLabel;
	JPanel errorPanel;
	final static String EMPTY_STRING = "";
	public ErrorChecker() {
		errorFrame = new JFrame();
		errorPanel = new JPanel();
		errorLabel = new JLabel();
		errorFrame.setSize(400,200);
		errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		errorFrame.setTitle("Error");
		errorFrame.setLocationRelativeTo(null);
		errorPanel.setLayout(new GridBagLayout());
		errorPanel.add(errorLabel);
		errorFrame.add(errorPanel);
	}
	
	/*
	 * returns true for valid text
	 * returns false for invalid text
	 */
	public boolean checkPassGenText(String text) {
		if (text == null) {
			errorLabel.setText("Invalid Input: Null");
			errorFrame.setVisible(true);
			return false;
		}
		if (text.length() > 3) {
			errorLabel.setText("Invalid Input: No numbers greater than 3 digits");
			errorFrame.setVisible(true);
			return false;
		}
		if (text.equals(EMPTY_STRING)) {
			errorLabel.setText("Invalid Input: Empty String");
			errorFrame.setVisible(true);
			return false;
		}
		char[] textArr = text.toCharArray();
		for (char i : textArr) {
			if (!Character.isDigit(i)) {
				errorLabel.setText("Invalid Input: No characters");
				errorFrame.setVisible(true);
				return false;
			}
		}
		return true;
	}
	
	
	public boolean checkTexts(String text, String key1, String key2) {
		if (text == null || key1 == null || key2 == null) {
			errorLabel.setText("Invalid Input: Null");
			errorFrame.setVisible(true);
			return false;
		}
		if (text.equals(EMPTY_STRING) || key1.equals(EMPTY_STRING) ||
				key2.equals(EMPTY_STRING)) {
			errorLabel.setText("Invalid Input: Empty String");
			errorFrame.setVisible(true);
			return false;
		}
		char[] textArr = text.toCharArray();
		char[] key1Arr = key1.toCharArray();
		char[] key2Arr = key2.toCharArray();
		for (char i : textArr) {
			if (Character.isDigit(i)) {
				errorLabel.setText("Invalid Input: No numbers");
				errorFrame.setVisible(true);
				return false;
			}
		}
		for (char i : key1Arr) {
			if (Character.isDigit(i)) {
				errorLabel.setText("Invalid Input: No numbers");
				errorFrame.setVisible(true);
				return false;
			}
		}
		for (char i : key2Arr) {
			if (Character.isDigit(i)) {
				errorLabel.setText("Invalid Input: No numbers");
				errorFrame.setVisible(true);
				return false;
			}
		}
		return true;
	}
	
	public boolean checkTexts(String text, String key1) {
		if (text == null || key1 == null) {
			errorLabel.setText("Invalid Input: Null");
			errorFrame.setVisible(true);
			return false;
		}
		if (text.equals(EMPTY_STRING) || key1.equals(EMPTY_STRING)) {
			errorLabel.setText("Invalid Input: Empty String");
			errorFrame.setVisible(true);
			return false;
		}
		char[] textArr = text.toCharArray();
		char[] key1Arr = key1.toCharArray();
		for (char i : textArr) {
			if (Character.isDigit(i)) {
				errorLabel.setText("Invalid Input: No numbers");
				errorFrame.setVisible(true);
				return false;
			}
		}
		for (char i : key1Arr) {
			if (Character.isDigit(i)) {
				errorLabel.setText("Invalid Input: No numbers");
				errorFrame.setVisible(true);
				return false;
			}
		}
		return true;
	}
	
}
