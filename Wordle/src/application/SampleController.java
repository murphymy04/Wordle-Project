package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Arrays;

public class SampleController {
	ShadowData data = new ShadowData();
	SelectWord selector = new SelectWord();
	Log gameLog = new Log();
	
	@FXML
	private Button A;
	@FXML
	private Button B;
	@FXML
	private Button C;
	@FXML
	private Button D;
	@FXML
	private Button E;
	@FXML
	private Button F;
	@FXML
	private Button G;
	@FXML
	private Button H;
	@FXML
	private Button I;
	@FXML
	private Button J;
	@FXML
	private Button K;
	@FXML
	private Button L;
	@FXML
	private Button M;
	@FXML
	private Button N;
	@FXML
	private Button O;
	@FXML
	private Button P;
	@FXML
	private Button Q;
	@FXML
	private Button R;
	@FXML
	private Button S;
	@FXML
	private Button T;
	@FXML
	private Button U;
	@FXML
	private Button V;
	@FXML
	private Button W;
	@FXML
	private Button X;
	@FXML
	private Button Y;
	@FXML
	private Button Z;
	@FXML
	private Button EnterKey;
	@FXML
	private Button BackKey;
	
	@FXML
	private Label L1;
	@FXML
	private Label L2;
	@FXML
	private Label L3;
	@FXML
	private Label L4;
	@FXML
	private Label L5;
	@FXML
	private Label L6;
	@FXML
	private Label L7;
	@FXML
	private Label L8;
	@FXML
	private Label L9;
	@FXML
	private Label L10;
	@FXML
	private Label L11;
	@FXML
	private Label L12;
	@FXML
	private Label L13;
	@FXML
	private Label L14;
	@FXML
	private Label L15;
	@FXML
	private Label L16;
	@FXML
	private Label L17;
	@FXML
	private Label L18;
	@FXML
	private Label L19;
	@FXML
	private Label L20;
	@FXML
	private Label L21;
	@FXML
	private Label L22;
	@FXML
	private Label L23;
	@FXML
	private Label L24;
	@FXML
	private Label L25;
	@FXML
	private Label L26;
	@FXML
	private Label L27;
	@FXML
	private Label L28;
	@FXML
	private Label L29;
	@FXML
	private Label L30;
	@FXML
	private Label L31;
	
	ArrayList<Button> buttons = new ArrayList<Button>();
	ArrayList<Label> row1 = new ArrayList<Label>();
	ArrayList<Label> row2 = new ArrayList<Label>();
	ArrayList<Label> row3 = new ArrayList<Label>();
	ArrayList<Label> row4 = new ArrayList<Label>();
	ArrayList<Label> row5 = new ArrayList<Label>();
	ArrayList<Label> row6 = new ArrayList<Label>();
	ArrayList<ArrayList<Label>> board = new ArrayList<ArrayList<Label>>();
	
	
	
	public void initialize() {
		String answer = selector.getRandomWord().toUpperCase();
		data.setAnswer(answer);
		System.out.println(answer);
		buttons.addAll(Arrays.asList(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z));
		row1.add(L1);
		row1.add(L2);
		row1.add(L3);
		row1.add(L4);
		row1.add(L5);
		
		row2.add(L6);
		row2.add(L7);
		row2.add(L8);
		row2.add(L9);
		row2.add(L10);
		
		row3.add(L11);
		row3.add(L12);
		row3.add(L13);
		row3.add(L14);
		row3.add(L15);
		
		row4.add(L16);
		row4.add(L17);
		row4.add(L18);
		row4.add(L19);
		row4.add(L20);
		
		row5.add(L21);
		row5.add(L22);
		row5.add(L23);
		row5.add(L24);
		row5.add(L25);
		
		row6.add(L26);
		row6.add(L27);
		row6.add(L28);
		row6.add(L29);
		row6.add(L30);
		
		board.add(row1);
		board.add(row2);
		board.add(row3);
		board.add(row4);
		board.add(row5);
		board.add(row6);

		buttonPress(A);
		buttonPress(B);
		buttonPress(C);
		buttonPress(D);
		buttonPress(E);
		buttonPress(F);
		buttonPress(G);
		buttonPress(H);
		buttonPress(I);
		buttonPress(J);
		buttonPress(K);
		buttonPress(L);
		buttonPress(M);
		buttonPress(N);
		buttonPress(O);
		buttonPress(P);
		buttonPress(Q);
		buttonPress(R);
		buttonPress(S);
		buttonPress(T);
		buttonPress(U);
		buttonPress(V);
		buttonPress(W);
		buttonPress(X);
		buttonPress(Y);
		buttonPress(Z);
		enter(EnterKey);
		backSpace(BackKey);
	}
	
	private void buttonPress(Button b) {
		b.setOnAction(event -> {
			if (gameLog.get_currChar() >= 5) {
				System.out.println("Warning: Must be a 5 letter word");
			}
			else {
				board.get(gameLog.get_numGuesses()).get(gameLog.get_currChar()).setText(b.getId());
				gameLog.addChar();
			}
		});
	}
	
	private void backSpace(Button b) {
		b.setOnAction(event -> {
			if (gameLog.get_currChar() > 0) { 
				gameLog.decChar();
				board.get(gameLog.get_numGuesses()).get(gameLog.get_currChar()).setText("");
			}
			else {
				board.get(gameLog.get_numGuesses()).get(gameLog.get_currChar()).setText("");
			}
		});
	}
	
	private void enter(Button b) {
		b.setOnAction(event -> {
			if (gameLog.get_currChar() > 4) {
				String guess = board.get(gameLog.get_numGuesses()).get(0).getText() + board.get(gameLog.get_numGuesses()).get(1).getText() + board.get(gameLog.get_numGuesses()).get(2).getText() + board.get(gameLog.get_numGuesses()).get(3).getText() + board.get(gameLog.get_numGuesses()).get(4).getText();
				boolean won = validateGuess(guess);
				gameLog.resetChar();
				gameLog.addGuess();
				if (won) {
					System.out.println("You Won!");
					for (int i=0; i<26; i++) {
						buttons.get(i).setDisable(true);
					}
					EnterKey.setDisable(true);
					BackKey.setDisable(true);
					gameLog.endGame(won);
				}
				
			}
			else {
				System.out.println("Warning: This is not a 5 letter word");
			}
		});
	}
	
	private boolean validateGuess(String guess) {
		if (!selector.contains(guess)) System.out.println("Warning: Guess is not in word list");
		boolean correct = true;
		for (int i=0; i<5; i++) {
			int val = data.updateData(guess.charAt(i), i);
			if (val != 2) correct = false;
			
			if (val == 0) {
				board.get(gameLog.get_numGuesses()).get(i).setStyle("-fx-background-color: red;");
				for (int j=0; j<26; j++) {
					if (board.get(gameLog.get_numGuesses()).get(i).getText() == buttons.get(j).getId()) buttons.get(j).setDisable(true);
				}
			}
			else if (val == 1) {
				board.get(gameLog.get_numGuesses()).get(i).setStyle("-fx-background-color: yellow;");
			}
			else if (val == 2) {
				board.get(gameLog.get_numGuesses()).get(i).setStyle("-fx-background-color: green;");
			}
		}
		
		return correct;
	}
	
	
	/* TODO:
	 -make log class which include: # of wins, win rate, streak, max streak, guess distribution
	 -disable all rows besides row 1 initially, and enable each one by one on enter
	 -make button keyboard
	 -reset button
	 -load and save feature
	 -add warnings, see docs for details
	 -make ui nicer
	 */
}
