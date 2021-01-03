package PasswordGenerator;

public final class PasswordGenerator {
	private static final int ALPHABET_LENGTH = 26;
	private static final int ASCIIVALUE_a = 97;
	private static final int ASCIIVALUE_z = 122;
	
	private PasswordGenerator() { // not meant for constructing
	}
	
	public static boolean isLowerCase(char letter) {
	    int asciiValue = (int) letter;
	    if ((asciiValue <= ASCIIVALUE_z) && (asciiValue >= ASCIIVALUE_a)) {
	      return true;
	    }
	    return false;
	}
	
	public static boolean isLowerCase(String str) {
	    // checks if string is null before anything else
	    if (str == null) {
	      return false;
	    }
	    int stringLength = str.length();
	    // checks every value of str for invalid values
	    for (int i = 0; i < stringLength; i++) {
	      int asciiValue = (int) str.charAt(i);
	      if ((asciiValue > ASCIIVALUE_z) || (asciiValue < ASCIIVALUE_a)) {
	        return false;
	      }
	    }
	    return true;
	}
	
	public static char caesarShiftEncode(char plaintext, char key) {
		// below: checks if input is valid.
		if ((isLowerCase(plaintext) == false) || (isLowerCase(key) == false)) {
		      return plaintext;
		}
	 // below: makes newPlaintext from 0-26
		int newPlaintext = ((int) plaintext) - ASCIIVALUE_a;
		// below: makes newKey from 0-26
		int newKey = ((int) key) - ASCIIVALUE_a;
		/* below: calculates the new encodedChar from adding the two values,
		newPlaintext and newKey and modulo 26 it. Readd ascii value for a (97) to
		get the new ASCIIvalue and the char. */
		char encodedChar = (char) (((newPlaintext + newKey) % ALPHABET_LENGTH)
		                      + ASCIIVALUE_a);
		return encodedChar;
	}
	
	public static char caesarShiftDecode(char ciphertext, char key) {
	    char decodedChar;
	    // below: checks if input is valid
	    if ((isLowerCase(ciphertext) == false) || (isLowerCase(key) == false)) {
	      return ciphertext;
	    }
	    // below: makes newCiphertext from 0-26
	    int newCiphertext = ((int) ciphertext) - ASCIIVALUE_a;
	    // below: makes  newKey from 0-26
	    int newKey = ((int) key) - ASCIIVALUE_a;
	    /* If newCiphertext >= newKey, then adding the two ascii values modulo 26
	    would result in the decoded letter. Adding ascii value for a (97) back to it
	    gives the ascii value for the decoded char.*/
	    if (newCiphertext >= newKey) {
	      decodedChar = (char) (((newCiphertext - newKey) % ALPHABET_LENGTH)
	                  + ASCIIVALUE_a);
	    }
	    /* Otherwise, if newCiphertext <= newKey, then adding the two ascii values
	    modulo 26 would result in a negatie value, which when added to 26 gives
	    the decoded letter. aAdding ascii value for (97) back to it gives the ascii
	    value for the decoded char.*/
	    else {
	      decodedChar = (char) (((newCiphertext - newKey) % ALPHABET_LENGTH)
	                  + ALPHABET_LENGTH + ASCIIVALUE_a);
	    }
	    return decodedChar;
	}
	
	public static String vigenereEncode(String plaintext, String key) {
	    // checks if arguments are valid
	    if ((isLowerCase(plaintext) == false) || (isLowerCase(key) == false)
	        || (key.equals(""))) {
	      return null;
	    }
	    // variable declarations
	    int plaintextLength = plaintext.length();
	    int keyLength = key.length();
	    char eachPlaintextLetter;
	    char eachKeyLetter;
	    char eachEncodedChar;
	    String encodedString = "";

	    /* Runs through every plaintext index and encrypts it with the appropriate
	    key index, i%keyLength */
	    for (int i = 0; i < plaintextLength; i++) {
	        eachPlaintextLetter = plaintext.charAt(i);
	        eachKeyLetter = key.charAt(i % keyLength);
	        eachEncodedChar = caesarShiftEncode(eachPlaintextLetter, eachKeyLetter);
	        encodedString += eachEncodedChar;
	    }
	    return encodedString;
	}	
	
	public static String vigenereDecode(String ciphertext, String key) {
	    // checks if the inputs are valid
	    if ((isLowerCase(ciphertext) == false) || (isLowerCase(key) == false)
	        || (key.equals(""))) {
	      return null;
	    }
	    int ciphertextLength = ciphertext.length();
	    int keyLength = key.length();
	    char eachCiphertextLetter;
	    char eachKeyLetter;
	    char eachDecodedChar;
	    String decodedString = "";

	    /* Runs through every letter of the ciphertext and decodes it with the
	    appropriate key index, i%keyLength */
	    for (int i = 0; i < ciphertextLength; i++) {
	        eachCiphertextLetter = ciphertext.charAt(i);
	        eachKeyLetter = key.charAt(i % keyLength);
	        eachDecodedChar = caesarShiftDecode(eachCiphertextLetter,eachKeyLetter);
	        decodedString += eachDecodedChar;
	      }
	    return decodedString;
	}
	
	public static int findLCM(int aVal, int bVal) {
	    int LCD; // least common divisor
	    int LCM; // least common multiple
	    // below: initalizing variables equal to parameter so I can modify them
	    int valueA = aVal;
	    int valueB = bVal;

	    while (valueA != valueB) {
	      if (valueB > valueA) {
	        valueB = valueB - valueA;
	      }
	      else {
	        valueA = valueA - valueB;
	      }
	    }
	    LCD = valueA;
	    LCM = Math.abs(aVal * bVal) / LCD;
	    return LCM;
	 }
	
	public static String computeVernamLongKey(String key1, String key2) {
		// checks for invalid inputs
		if ((key1 == null) || (key2 == null) || (!isLowerCase(key1))
		    || (isLowerCase(key2)) || (key1.equals(""))
		    || (key2.equals(""))) {
		        return null;
		}
		// below: variable declaration
		int key1Length = key1.length();
		int key2Length = key2.length();
		int longkeyLength = findLCM(key1Length, key2Length);
		char eachKey1Letter;
		char eachKey2Letter;
		String longKey = "";
		// below: encodes each key1 index letter with key2 index to make longKey
		for (int i = 0; i < longkeyLength; i++) {
			eachKey1Letter = key1.charAt(i % key1Length);
		    eachKey2Letter = key2.charAt(i % key2Length);
		    longKey += caesarShiftEncode(eachKey1Letter, eachKey2Letter);
		}
		return longKey;
	}
	
	public static String vernamEncode(String plaintext, String key1,
            String key2) {
		// checks for invalid inputs
		if ((key1 == null) || (key2 == null) || (plaintext == null)
				|| (!isLowerCase(plaintext)) || (!isLowerCase(key1))
				|| (!isLowerCase(key2)) || (key1.equals(""))
				|| key2.equals("")) {
			return null;
		}
		// computes longkey using helper method above
		String longKey = computeVernamLongKey(key1, key2);
		// computes encodedString by using vigenereEncode from Cipher.java
		String encodedString = vigenereEncode(plaintext, longKey);
		return encodedString;
	}	
	
	public static String vernamDecode(String ciphertext, String key1,
            String key2) {
		// checks for invalid inputs
		if ((key1 == null) || (key2 == null) || (ciphertext == null)
				|| (!isLowerCase(ciphertext)) || (!isLowerCase(key1))
				|| (!isLowerCase(key2)) || (key1.equals(""))
				|| key2.equals("")) {
			return null;
		}
		// computes longkey using helper method above
		String longKey = computeVernamLongKey(key1, key2);
		// computes decodedString by using vigenereDecode from Cipher.java
		String decodedString = vigenereDecode(ciphertext, longKey);
		return decodedString;
	}
	
	public static String passwordGenerator(int length) {
		
	}
}
