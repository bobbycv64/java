package us.cv64.javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {

	@FXML
	private PieChart pieChart;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Cars", 13),
				new PieChart.Data("Bikes", 25),
				new PieChart.Data("Buses", 10),
				new PieChart.Data("Cycles", 22));
		
		pieChart.setData(pieChartData);
		pieChart.setStartAngle(90);
	}
}
