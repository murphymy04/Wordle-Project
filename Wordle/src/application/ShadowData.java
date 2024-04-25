package application;

import java.util.HashMap;

public class ShadowData {
	private String answer;
	private HashMap<Character, Integer> data;
	
	public ShadowData() {
		answer = null;
		data = new HashMap<>();
		for (char c='A'; c <='Z'; c++) {
			data.put(c, -1);
		}
	}
	
	public ShadowData(String a) {
		answer = a;
		data = new HashMap<>();
		for (char c='A'; c <='Z'; c++) {
			data.put(c, -1);
		}
	}
	
	public void resetData() {
		for (char c='A'; c <= 'Z'; c++) {
			data.replace(c, -1);
		}	
	}
	
	public int updateData(char entry, int index) {
		int flag = -1; 
		if (entry == answer.charAt(index)) {
			data.replace(entry, 2); // character is in answer and in correct place
			flag = 2;
		}
		else if (answer.contains(Character.toString(entry))) {
			data.replace(entry, 1); // character is in answer but not in correct place
			flag = 1;
		}
		else {
			data.replace(entry, 0); // character is not in answer
			flag = 0;
		}
		return flag;
	}
	
	public int getValue(char c) {
		return data.get(c);
	}
	
	public void setAnswer(String a) {
		answer = a;
	}
}
