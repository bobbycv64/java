package us.cv64.javafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	public static void display(String title, String message) {
		
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(250);

		Label label = new Label();
		label.setText(message);

		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> stage.close());

		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(label, closeButton);
		vbox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
