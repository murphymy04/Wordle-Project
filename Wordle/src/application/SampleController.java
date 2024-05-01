package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class SampleController {
	ShadowData data = new ShadowData();
	SelectWord selector = new SelectWord();
	Log gameLog = new Log();
	String answer;
	boolean isValidWord = true;
	
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
	private Button reset;
	@FXML
	private Button load;
	@FXML
	private Button save;
	
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
	
	ArrayList<Button> buttons = new ArrayList<Button>();
	ArrayList<Label> row1 = new ArrayList<Label>();
	ArrayList<Label> row2 = new ArrayList<Label>();
	ArrayList<Label> row3 = new ArrayList<Label>();
	ArrayList<Label> row4 = new ArrayList<Label>();
	ArrayList<Label> row5 = new ArrayList<Label>();
	ArrayList<Label> row6 = new ArrayList<Label>();
	ArrayList<ArrayList<Label>> board = new ArrayList<ArrayList<Label>>();
	Popup popup = new Popup();
	
	public void initialize() {
		answer = selector.getRandomWord().toUpperCase();
		data.setAnswer(answer);
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
		resetGame(reset);
		save(save);
		load(load);
	}
	
	private void buttonPress(Button b) {
		b.setOnAction(event -> {
			if (gameLog.get_currChar() >= 5) {
				String warning = "Warning: Must be a 5 letter word";
				showPopup(warning);
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
				boolean won = validateGuess(guess, gameLog.get_numGuesses());
				if (isValidWord) {
					gameLog.resetChar();
					gameLog.addGuess();
				}
				if (won || (!won && gameLog.get_numGuesses() == 6)) {
					for (int i=0; i<26; i++) {
						buttons.get(i).setDisable(true);
					}
					EnterKey.setDisable(true);
					BackKey.setDisable(true);
					gameLog.endGame(won, answer);
				}
			}
			else {
				String warning = "Warning: This is not a 5 letter word";
				showPopup(warning);
			}
		});
	}
	
	private void save(Button b) {
		b.setOnAction(event -> {
			// need to save: data in board, answer, currChar, numGuesses
			gameLog.saveGame(answer, board);
		});
	}
	
	public void load(Button b) {
		b.setOnAction(event -> {
			answer = gameLog.loadGame(board);
			data.setAnswer(answer);
			for (int i=0; i<gameLog.get_numGuesses(); i++) {
				String guess = board.get(i).get(0).getText() + board.get(i).get(1).getText() + board.get(i).get(2).getText() + board.get(i).get(3).getText() + board.get(i).get(4).getText();
				boolean won = validateGuess(guess, i);
				if (won) {
					for (int j=0; j<26; j++) {
						buttons.get(j).setDisable(true);
					}
					EnterKey.setDisable(true);
					BackKey.setDisable(true);
				}
			}
		});
	}
	
	private void resetGame(Button b) {
		b.setOnAction(event -> {
			// clear board
			for (int i=0; i<6; i++) {
				for (int j=0; j<5; j++) {
					board.get(i).get(j).setText("");
					board.get(i).get(j).setStyle("-fx-background-color: white;");
				}
			}
			for (int i=0; i<26; i++) {
				buttons.get(i).setDisable(false);
				buttons.get(i).setStyle(null);
			}
			EnterKey.setDisable(false);
			BackKey.setDisable(false);
			
			// fix game log
			gameLog.resetChar();
			gameLog.resetGuesses();
			
			// select new word and set word
			answer = selector.getRandomWord().toUpperCase();
			data.resetData();
			data.setAnswer(answer);
			//System.out.println(answer);
		});
	}
	
	private boolean validateGuess(String guess, int numGuesses) {
		if (!selector.contains(guess)) {
			String warning = "Warning: Guess is not in word list";
			showPopup(warning);
			isValidWord = false; 
			return false;
		}
		boolean correct = true;
		for (int i=0; i<5; i++) {
			int val = data.updateData(guess.charAt(i), i);
			if (val != 2) correct = false;
			
			if (val == 0) {
				board.get(numGuesses).get(i).setStyle("-fx-background-color: grey;");
				for (int j=0; j<26; j++) {
					//System.out.println(board.get(numGuesses).get(i).getText().charAt(0) == buttons.get(j).getId().charAt(0));
					
					if (board.get(numGuesses).get(i).getText().charAt(0) == buttons.get(j).getId().charAt(0)) {
						buttons.get(j).setDisable(true);
						buttons.get(j).setStyle("-fx-background-color: grey;");
					}
				}
			}
			else if (val == 1) {
				board.get(numGuesses).get(i).setStyle("-fx-background-color: yellow;");
				for (int j=0; j<26; j++) {
					if (board.get(numGuesses).get(i).getText().charAt(0) == buttons.get(j).getId().charAt(0)) {
						buttons.get(j).setStyle("-fx-background-color: yellow;");
					}
				}
			}
			else if (val == 2) {
				board.get(numGuesses).get(i).setStyle("-fx-background-color: green;");
				for (int j=0; j<26; j++) {
					if (board.get(numGuesses).get(i).getText().charAt(0) == buttons.get(j).getId().charAt(0)) {
						buttons.get(j).setStyle("-fx-background-color: green;");
					}
				}
			}
		}
		isValidWord = true;
		return correct;
	}
	
	private void showPopup(String warning) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Warning.fxml"));
		WarningController warningController = new WarningController();
		loader.setController(warningController);
		Parent layout;
		try {
            layout = loader.load();
            Scene scene = new Scene(layout);
            Stage popupStage = new Stage();
            warningController.setWarning(warning);
            warningController.setStage(popupStage);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        } 
		catch (Exception e) {
            e.getMessage();
        }
	}
}
