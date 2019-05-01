package javafx;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartSample extends Application {

	// define percentage for pie chart
	private static NumberFormat percentage = NumberFormat.getPercentInstance();

	@Override
	// JavaFX - start method
	// stage is like a Java JFrame
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setTitle("Student Class Analysis");
		stage.setWidth(500);
		stage.setHeight(500);

		// build data for pie chart
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Freshman", 0.18), new PieChart.Data("Sophomore", 0.36),
				new PieChart.Data("Junior", 0.09), new PieChart.Data("Senior", 0.14),
				new PieChart.Data("Graduate", 0.23));

		// pass data into pie chart
		final PieChart chart = new PieChart(pieChartData);

		chart.setTitle("Percent of Students by Class");

		// concatenate the percentage with class year
		pieChartData.forEach(data -> data.nameProperty()
				.bind(Bindings.concat(percentage.format((data.getPieValue())), "-", data.getName())));

		// add chart to scene and stage
		((Group) scene.getRoot()).getChildren().add(chart);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args); // call JavaFX call start method
	}
}