package javafx;

import javax.swing.JSplitPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FXGUI extends Application {

	JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

	private FlowPane rootNode = new FlowPane(20, 10);
	private RadioButton smallPizza = new RadioButton("Small");
	private RadioButton mediumPizza = new RadioButton("Medium");
	private RadioButton largePizza = new RadioButton("Large");
	private Label shippingMethod = new Label();
	private Label toppinglabel = new Label();
	public CheckBox plain = null;
	public CheckBox cheese = null;
	public CheckBox bacon = null;
	private CheckBox olive = null;
	private ToggleGroup myGroup = new ToggleGroup();
	private Scene scene = new Scene(rootNode, 300, 250);
	private Label total = new Label("Total Owed: "); // add formula after
	private TextField cost = null;

	MyHandler myHandler = new MyHandler();

	public void start(Stage myStage) {

		smallPizza.setToggleGroup(myGroup);
		mediumPizza.setToggleGroup(myGroup);
		largePizza.setToggleGroup(myGroup);

		// when selected
		smallPizza.setOnAction(myHandler);
		mediumPizza.setOnAction(myHandler);
		largePizza.setOnAction(myHandler);
		shippingMethod.setText("Select a pizza Size             ");
		rootNode.setPadding(new Insets(30));

		plain = new CheckBox("Plain");
		bacon = new CheckBox("Bacon");
		cheese = new CheckBox("Cheese");
		olive = new CheckBox("Olives");
		Label mylabels = new Label("Please select your toppings");

		// topping handler
		plain.setSelected(true);
		plain.setOnAction(myHandler);

		bacon.setOnAction(myHandler);
		cheese.setOnAction(myHandler);
		olive.setOnAction(myHandler);

		cost = new TextField("");
		cost.setEditable(false);
		cost.setOnAction(myHandler);

		rootNode.getChildren().addAll(shippingMethod, smallPizza, mediumPizza, largePizza, mylabels, bacon, cheese,
				olive, plain, toppinglabel, total, cost);
		myStage.setScene(scene);
		myStage.show();
	}

	class MyHandler implements EventHandler<ActionEvent> {

		private final static double SMALL = 0.5;
		private final static double MEDIUM = 1.0;
		private final static double LARGE = 1.5;

		private double pizzaCost = 0;
		private int toppings = 0;

		public void handle(ActionEvent actionEvent) {

			if (actionEvent.getSource() == plain) {
				toppings = 0;
				System.out.println("plain: " + toppings);

				plain.setSelected(true);
				bacon.setSelected(false);
				olive.setSelected(false);
				cheese.setSelected(false);
			}

			if (actionEvent.getSource() == cheese) {
				if (cheese.isSelected()) {
					toppings += 1;
				} else {
					toppings -= 1;
				}
				System.out.println("cheese: " + toppings);
			}

			if (actionEvent.getSource() == bacon) {
				if (bacon.isSelected()) {
					toppings += 1;
				} else {
					toppings -= 1;
				}
				System.out.println("bacon: " + toppings);
			}

			if (actionEvent.getSource() == olive) {
				if (olive.isSelected()) {
					toppings += 1;
				} else {
					toppings -= 1;
				}
				System.out.println("olive: " + toppings);
			}

			if (actionEvent.getSource() == smallPizza) {
				pizzaCost = 5 + (toppings * SMALL);
				System.out.println("Small pizza cost $5 with " + toppings + " toppings, cost: $ " + pizzaCost);
			}

			if (actionEvent.getSource() == mediumPizza) {
				pizzaCost = 8 + (toppings * MEDIUM);
				System.out.println("Medium pizza cost $8 with " + toppings + " toppings, cost: $ " + pizzaCost);
			}

			if (actionEvent.getSource() == largePizza) {
				pizzaCost = 12 + (toppings * LARGE);
				System.out.println("Large pizza cost $12 with " + toppings + " toppings, cost: $ " + pizzaCost);
			}

			if (toppings > 0) {
				plain.setSelected(false);
			}

			cost.setText(Double.toString(pizzaCost));
			cost.setVisible(true);
		}
	}
}