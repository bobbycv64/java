package us.cv64.javafx;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

// class QRCodeSample - writes a QR Code
public class QRCodeSample extends Application {

	private static final int SQUARE_SIZE = 8;
	private static final int MAX_ELEMENTS = 64;
	private static final int STAGE_SIZE = 512;

	private int[][] squareArray = new int[MAX_ELEMENTS][MAX_ELEMENTS];

	@Override
	// JavaFX - start method
	// stage is like a Java JFrame
	public void start(Stage stage) {

		buildArray();
		Scene scene = new Scene(new Group());  // big display
		stage.setTitle("QR Code Sample");
		stage.setWidth(STAGE_SIZE);
		stage.setHeight(STAGE_SIZE);

		displayArray(scene);
		displayBigSquares(scene, 0, 0);
		displayBigSquares(scene, 384, 0);
		displayBigSquares(scene, 0, 384);

		stage.setScene(scene);
		stage.show();
	}

	// method buildArray - randomly sets the colors of the squares and builds the array
	private void buildArray() {

		Random random = new Random();

		for (int i = 0; i < MAX_ELEMENTS; i++) {  // i = row
			for (int j = 0; j < MAX_ELEMENTS; j++) {  // j = columns

				// generate random number 0 (black) or 1 (white)
				squareArray[i][j] = random.nextInt((1 - 0) + 1) + 0;
			}
		}
	}

	// method displayArray - reads the array and sets the squares accordingly by their color
	private void displayArray(Scene scene) {
		
		for (int i = 0; i < MAX_ELEMENTS; i++) {
			for (int j = 0; j < MAX_ELEMENTS; j++) {

				Rectangle rectangle = new Rectangle();

				if (squareArray[i][j] == 0) {
					rectangle.setFill(Color.BLACK);
				} else {
					rectangle.setFill(Color.WHITE);
				}
				rectangle.setX(i * SQUARE_SIZE);
				rectangle.setY(j * SQUARE_SIZE);
				rectangle.setWidth(SQUARE_SIZE);
				rectangle.setHeight(SQUARE_SIZE);

				((Group) scene.getRoot()).getChildren().add(rectangle);
			}
		}
	}
	
	// method displayBigSquares - writes the 3 big general QR Squares
	private void displayBigSquares(Scene scene, int x, int y) {
		
		// draws the large black box
		Rectangle rectangle = new Rectangle();
		rectangle.setFill(Color.BLACK);
		rectangle.setX(x);
		rectangle.setY(y);
		rectangle.setWidth(128);
		rectangle.setHeight(128);
		((Group) scene.getRoot()).getChildren().add(rectangle);
		
		// draws the smaller white box
		Rectangle rectangle2 = new Rectangle();
		rectangle2.setFill(Color.WHITE);
		rectangle2.setX(x + 15);
		rectangle2.setY(y + 15);
		rectangle2.setWidth(98);
		rectangle2.setHeight(98);
		((Group) scene.getRoot()).getChildren().add(rectangle2);

		// draws the smaller black box
		Rectangle rectangle3 = new Rectangle();
		rectangle3.setFill(Color.BLACK);
		rectangle3.setX(x + 30);
		rectangle3.setY(y + 30);
		rectangle3.setWidth(68);
		rectangle3.setHeight(68);
		((Group) scene.getRoot()).getChildren().add(rectangle3);
	}

	public static void main(String[] args) {
		launch(args); // launch JavaFX and call start method
	}
}