package application;

import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class StatsController {
	@FXML
	private CategoryAxis x;
	@FXML
	private NumberAxis y;
	@FXML
	private BarChart<String, Number> graph;
	@FXML
	private Label gamesPlayed;
	@FXML
	private Label winPercent;
	@FXML
	private Label currentStreak;
	@FXML
	private Label maximumStreak;
	@FXML
	private Label word;
	@FXML
	private Label Status;
	
	private Stage stage = null;
	
	public void initialize() {
		
	}
	
	public void setStage(Stage stage) {
        this.stage = stage;
    }
	
	public void makeGraph(HashMap<Integer, Integer> guessDistr) {
		XYChart.Series<String, Number> series = new XYChart.Series();
		series.getData().add(new XYChart.Data("1", guessDistr.get(1)));
		series.getData().add(new XYChart.Data("2", guessDistr.get(2)));
		series.getData().add(new XYChart.Data("3", guessDistr.get(3)));
		series.getData().add(new XYChart.Data("4", guessDistr.get(4)));
		series.getData().add(new XYChart.Data("5", guessDistr.get(5)));
		series.getData().add(new XYChart.Data("6", guessDistr.get(6)));
		graph.getData().add(series);
	}
	
	public void displayStats(int numGames, float winRate, int currStreak, int maxStreak, boolean status, String answer) {
		gamesPlayed.setText(Integer.toString(numGames));
		winPercent.setText(Float.toString(winRate));
		currentStreak.setText(Integer.toString(currStreak));
		maximumStreak.setText(Integer.toString(maxStreak));
		word.setText(answer);
		if (status) Status.setText("Congratulations!");
		else Status.setText("Better Luck Next Time!");
	}
}
