package application;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Log {
	private int currChar;
	private int numGuesses;
	private boolean onStreak; // line1
	private int currStreak; // line2
	private int maxStreak; // line3
	private int numGames; // line4
	private int numWins; // line5
	private HashMap<Integer, Integer> guessDistr; // line6+
	
	public Log() {
		currChar = 0;
		numGuesses = 0;
		guessDistr = new HashMap<Integer, Integer>();
		try {
			File data = new File("data.txt");
			Scanner sc = new Scanner(data);
			String temp = sc.nextLine(); // 1
			if (temp == "false") onStreak = false;
			else onStreak = true;
			currStreak = Integer.parseInt(sc.nextLine()); // 2
			maxStreak = Integer.parseInt(sc.nextLine()); // 3
			numGames = Integer.parseInt(sc.nextLine()); // 4
			numWins = Integer.parseInt(sc.nextLine()); // 5
			for (int i=1; i<=6; i++) { // 6-11
				guessDistr.put(i, Integer.parseInt(sc.nextLine()));
			}
			sc.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void addChar() {
		currChar += 1;
	}
	
	public void decChar() {
		currChar -= 1;
	}
	
	public void resetChar() {
		currChar = 0;
	}
	
	public int get_currChar() {
		return currChar;
	}
	
	public void addGuess() {
		numGuesses += 1;
	}
	
	public int get_numGuesses() {
		return numGuesses;
	}
	
	public void endGame(boolean won) {
		if (won) {
			onStreak = true;
			currStreak += 1;
			if (currStreak > maxStreak) maxStreak = currStreak;
			numGames += 1;
			numWins += 1;
			int num = guessDistr.get(numGuesses) + 1;
			guessDistr.replace(numGuesses, num);
		}
		else {
			onStreak = false;
			currStreak = 0;
			numGames += 1;
		}
		
		try {
			FileWriter out = new FileWriter("data.txt");
			out.write(Boolean.toString(onStreak) + "\n");
			out.write(Integer.toString(currStreak) + "\n");
			out.write(Integer.toString(maxStreak) + "\n");
			out.write(Integer.toString(numGames) + "\n");
			out.write(Integer.toString(numWins) + "\n");
			for (int i=1; i<=6; i++) {
				out.write(guessDistr.get(i) + "\n");
			}
			out.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		float winRate = (float) (numWins/numGames) * 100;
		System.out.println("Number of Games Played: " + numGames);
		System.out.println("Win Rate: " + winRate + "%");
		System.out.println("Current Streak: " + currStreak);
		System.out.println("Max Streak: " + maxStreak);
		System.out.println("Number of Guesses: " + numGuesses);
	}
	
}
