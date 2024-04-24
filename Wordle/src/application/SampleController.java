package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Arrays;

public class SampleController {
	ShadowData data = new ShadowData();
	@FXML
	private TextField B1;
	@FXML
	private TextField B2;
	@FXML
	private TextField B3;
	@FXML
	private TextField B4;
	@FXML
	private TextField B5;
	@FXML
	private TextField B6;
	@FXML
	private TextField B7;
	@FXML
	private TextField B8;
	@FXML
	private TextField B9;
	@FXML
	private TextField B10;
	@FXML
	private TextField B11;
	
	
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
	
	private ArrayList<Button> keyboard = new ArrayList<Button>(Arrays.asList(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z));
	
	
	public void initialize() {
		SelectWord selector = new SelectWord();
		String answer = selector.getRandomWord().toUpperCase();
		data.setAnswer(answer);
		System.out.println(answer);
		
		// row 1
		B1.textProperty().addListener(new ValidateListener(B1));
		B2.textProperty().addListener(new ValidateListener(B2));
		B3.textProperty().addListener(new ValidateListener(B3));
		B4.textProperty().addListener(new ValidateListener(B4));
		B5.textProperty().addListener(new ValidateListener(B5));
		pressKey(B1, B2, B1);
		pressKey(B2, B3, B1);
		pressKey(B3, B4, B2);
		pressKey(B4, B5, B3);
		enter(B5, B6, B4, B3, B2, B1);
		buttonPress(A, B1, B2);
		buttonPress(B, B2, B3);
		
		// row 2
		B6.textProperty().addListener(new ValidateListener(B6));
		B7.textProperty().addListener(new ValidateListener(B7));
		B8.textProperty().addListener(new ValidateListener(B8));
		B9.textProperty().addListener(new ValidateListener(B9));
		B10.textProperty().addListener(new ValidateListener(B10));
		pressKey(B6, B7, B6);
		pressKey(B7, B8, B6);
		pressKey(B8, B9, B7);
		pressKey(B9, B10, B8);
		enter(B10, B11, B9, B8, B7, B6);
		
		// row 3
		
		
	}
	
	private void pressKey(TextField current, TextField next, TextField prev) {
		current.setOnKeyReleased(event -> {
			String text = current.getText();
			char textChar = '0';
			try {
				textChar = text.charAt(0);
			}
			catch (Exception e) {}
			
			if (Character.isAlphabetic(textChar)) {
				next.requestFocus();
			}
			else if (event.getCode() == KeyCode.BACK_SPACE || event.getCode() == KeyCode.DELETE) {
				prev.requestFocus();
			}
		});
	}
	
	private void buttonPress(Button b, TextField current, TextField next) {
		b.setOnAction(event -> {
			current.requestFocus();
			current.setText(b.getId());
			next.requestFocus();
		});
	}
	
	private void enter(TextField current, TextField next, TextField prev, TextField B3, TextField B2, TextField B1) {
		current.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				next.requestFocus();
				String guess = B1.getText() + B2.getText() + B3.getText() + prev.getText() + current.getText();
				boolean won = validateGuess(guess, B1, B2, B3, prev, current);
				if (won) System.out.println("You Won!");
			}
			else if (event.getCode() == KeyCode.BACK_SPACE || event.getCode() == KeyCode.DELETE) {
				prev.requestFocus();
			}
		});
	}
	
	private boolean validateGuess(String guess, TextField B1, TextField B2, TextField B3, TextField B4, TextField B5) {
		boolean correct = true;
		for (int i=0; i<5; i++) {
			int val = data.updateData(guess.charAt(i), i);
			if (val != 2) correct = false;
			
			if (val == 0) {
				if (i == 0) B1.setStyle("-fx-background-color: red;");
				else if (i == 1) B2.setStyle("-fx-background-color: red;");
				else if (i == 2) B3.setStyle("-fx-background-color: red;");
				else if (i == 3) B4.setStyle("-fx-background-color: red;");
				else if (i == 4) B5.setStyle("-fx-background-color: red;");
			}
			else if (val == 1) {
				if (i == 0) B1.setStyle("-fx-background-color: yellow;");
				else if (i == 1) B2.setStyle("-fx-background-color: yellow;");
				else if (i == 2) B3.setStyle("-fx-background-color: yellow;");
				else if (i == 3) B4.setStyle("-fx-background-color: yellow;");
				else if (i == 4) B5.setStyle("-fx-background-color: yellow;");
			}
			else if (val == 2) {
				if (i == 0) B1.setStyle("-fx-background-color: green;");
				else if (i == 1) B2.setStyle("-fx-background-color: green;");
				else if (i == 2) B3.setStyle("-fx-background-color: green;");
				else if (i == 3) B4.setStyle("-fx-background-color: green;");
				else if (i == 4) B5.setStyle("-fx-background-color: green;");
			}
		}
		
		// disable row from being changed
		B1.setEditable(false);
		B2.setEditable(false);
		B3.setEditable(false);
		B4.setEditable(false);
		B5.setEditable(false);
		return correct;
	}
	
	
	private static class ValidateListener implements ChangeListener<String> {
		private final TextField textField;
		
		public ValidateListener(TextField textField) {
			this.textField = textField;
		}
		
		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			char newChar = '0';
			try {
				newChar = newValue.charAt(0);
			}
			catch(Exception e) {}
			
			if (!Character.isAlphabetic(newChar)) {
				textField.setText("");
			}
			
			else if (newValue.length() > 1) {
				textField.setText(oldValue);
			}
			
			else {
				textField.setText(newValue.toUpperCase());
			}
		}
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
