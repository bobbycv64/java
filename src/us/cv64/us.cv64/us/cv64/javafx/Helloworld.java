package us.cv64.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
// Helloworld gets everything from javafx.application.Application
public class Helloworld extends Application {
    public static void main(String[] args) {
    	
    	// to start JavaFX, which calls the start method
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World Title");
        
        // creates a button
        Button button = new Button();
        button.setText("Hello World Button");
        
        // action event, do the following when the button is pressed
        button.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World Button was Pressed");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
