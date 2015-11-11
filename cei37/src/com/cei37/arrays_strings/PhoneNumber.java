package com.cei37.arrays_strings;

public class PhoneNumber {

	/**
	 * @param args
	 */
	private int PHONE_NUMBER_LENGTH;
	private int[] phoneNum;
	private char[] result;

	public static void main(String[] args) {
		PhoneNumber p = new PhoneNumber();
		p.printWords("36");
	}

	public void printWords(String phone) {
		PHONE_NUMBER_LENGTH = phone.length();
		result = new char[PHONE_NUMBER_LENGTH];
		phoneNum = new int[PHONE_NUMBER_LENGTH];
		for (int i=0; i<PHONE_NUMBER_LENGTH; i++) {
			phoneNum[i] = phone.charAt(i)-48;
		}
		printWords(0);
	}

	private void printWords(int curDigit) {
		if (curDigit == PHONE_NUMBER_LENGTH) {
			System.out.println(new String(result));
			return;
		}
		for (int i = 0; i < 3; i++) {
			result[curDigit] = getCharKey(phoneNum[curDigit], i);
			printWords(curDigit + 1);
			if (phoneNum[curDigit] == 0 || phoneNum[curDigit] == 1)
				return;
		}
	}

	public char getCharKey(int number, int pos) {
		switch (number) {
		case 2:
			if (pos == 0)
				return 'A';
			if (pos == 1)
				return 'B';
			if (pos == 2)
				return 'C';
			break;
		case 3:
			if (pos == 0)
				return 'D';
			if (pos == 1)
				return 'E';
			if (pos == 2)
				return 'F';
			break;
		case 4:
			if (pos == 0)
				return 'G';
			if (pos == 1)
				return 'H';
			if (pos == 2)
				return 'I';
			break;
		case 5:
			if (pos == 0)
				return 'J';
			if (pos == 1)
				return 'K';
			if (pos == 2)
				return 'L';
			break;
		case 6:
			if (pos == 0)
				return 'M';
			if (pos == 1)
				return 'N';
			if (pos == 2)
				return 'O';
			break;
		case 7:
			if (pos == 0)
				return 'P';
			if (pos == 1)
				return 'Q';
			if (pos == 2)
				return 'R';
			break;
		case 8:
			if (pos == 0)
				return 'T';
			if (pos == 1)
				return 'U';
			if (pos == 2)
				return 'V';
			break;
		case 9:
			if (pos == 0)
				return 'W';
			if (pos == 1)
				return 'X';
			if (pos == 2)
				return 'Y';
			break;
		default:
			if (number == 0)
				return '0';
			if (number == 1)
				return '1';
		}
		return '*';
	}
}