package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WarningController {
	@FXML
	private Label popupLabel;
	private Stage stage = null;
	
	public void initialize() {
		
	}
	
	public void setStage(Stage stage) {
        this.stage = stage;
    }
	
	public void setWarning(String warning) {
		popupLabel.setText(warning);
	}
}
