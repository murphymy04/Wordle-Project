package application;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
	
	public void resetGuesses() {
		numGuesses = 0;
		
	}

	public void endGame(boolean won, String answer) {
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
		showStats(winRate, won, answer);
	}
	
	public void saveGame(String answer, ArrayList<ArrayList<Label>> data) {
		try {
			FileWriter out = new FileWriter("savedData.txt");
			for (int i=0; i<6; i++) {
				for (int j=0; j<5; j++) {
					out.write(data.get(i).get(j).getText() + "\n");
				}
			}
			out.write(answer + "\n");
			out.write(currChar + "\n");
			out.write(numGuesses + "\n");
			out.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String loadGame(ArrayList<ArrayList<Label>> board) {
		String answer = "";
		try {
			File data = new File("savedData.txt");
			Scanner sc = new Scanner(data);
			for (int i=0; i<6; i++) {
				for (int j=0; j<5; j++) {
					board.get(i).get(j).setText(sc.nextLine());
				}
			}
			answer = sc.nextLine();
			currChar =  Integer.parseInt(sc.nextLine());
			numGuesses = Integer.parseInt(sc.nextLine());
			sc.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return answer;
	}
	
	private void showStats(float winRate, boolean won, String answer) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Stats.fxml"));
		StatsController popupController = new StatsController();
		loader.setController(popupController);
		Parent layout;
		try {
            layout = loader.load();
            Scene scene = new Scene(layout);
            Stage popupStage = new Stage();
            popupController.makeGraph(guessDistr);
            popupController.displayStats(numGames, winRate, currStreak, maxStreak, won, answer);
            popupController.setStage(popupStage);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        } 
		catch (Exception e) {
            e.getMessage();
        }
	}
	
}
