package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class SelectWord {
	
	private String[] wordList;
	
	public String getRandomWord() {
	    try {
	      // get words and used words
	      File words = new File("wordList.txt");
	      Scanner sc = new Scanner(words);
	      wordList = new String[2400];
	      int i = 0;
	      while (sc.hasNextLine()) {
	         wordList[i] = sc.nextLine();
	         i += 1;
	      }
	      sc.close();

	      i = 0;
	      String[] usedWord = new String[2400];
	      File usedWords = new File("usedWordList.txt");
	      sc = new Scanner(usedWords);
	      while (sc.hasNextLine()) {
	         usedWord[i] = sc.nextLine();
	         i += 1;
	      }
	      sc.close();

	      // generate random index
	      Random rand = new Random();
	      int randIndex = rand.nextInt(2308);
	      String word = wordList[randIndex];
	      List<String> usedWordList = Arrays.asList(usedWord);
	      while (usedWordList.contains(word)) {
	         randIndex = rand.nextInt(2308);
	         word = wordList[randIndex];
	      }

	      FileWriter out = new FileWriter("usedWordList.txt", true);
	      out.append(word + "\n");
	      out.close();
	      return word;
	    }
	    catch (IOException e) {
	      System.out.println(e.getMessage());
	    }

	    return "";
	   } 
	
	public boolean contains(String word) {
		return Arrays.asList(wordList).contains(word.toLowerCase());
	}
}
