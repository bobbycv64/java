// https://www.youtube.com/watch?v=mtdlX2NMy4M
// https://www.youtube.com/watch?v=SpL3EToqaXA

package us.cv64.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// JavaFxTable gets everything from javafx.application.Application
public class JavaFxTable extends Application {

	Stage stage = null;
	TableView<Item> tableView = new TableView<>();
	TextField indexTextField, firstNameTextField, lastNameTextField;
	Button addButton = new Button("Add");
	Button deleteButton = new Button("Delete");
	Button detailsButton = new Button("Details");
	HBox hBox = new HBox();
	VBox vBox = new VBox();

	public static void main(String[] args) {

		// to start JavaFX, which calls the start method
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("JavaFXTable");

		addButton.setOnAction(e -> addButtonClicked());
		deleteButton.setOnAction(e -> deleteButtonClicked());
		detailsButton.setOnAction(e -> detailsButtonClicked());

		// Create Table Columns
		TableColumn<Item, String> indexTableColumn = new TableColumn<>("Index");
		indexTableColumn.setMinWidth(200);
		indexTableColumn.setCellValueFactory(new PropertyValueFactory<>("index"));

		TableColumn<Item, String> firstNameTableColumn = new TableColumn<>("Firstname");
		firstNameTableColumn.setMinWidth(200);
		firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		TableColumn<Item, String> lastNameTableColumn = new TableColumn<>("Lastname");
		lastNameTableColumn.setMinWidth(200);
		lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		indexTextField = new TextField();
		indexTextField.setPromptText("Index");
		indexTextField.setMinWidth(100);

		firstNameTextField = new TextField();
		firstNameTextField.setPromptText("Firstname");
		firstNameTextField.setMinWidth(100);

		lastNameTextField = new TextField();
		lastNameTextField.setPromptText("Lastname");
		lastNameTextField.setMinWidth(100);

		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(indexTextField, firstNameTextField, lastNameTextField, addButton, deleteButton,
				detailsButton);

		tableView.setItems(getItems());
		tableView.getColumns().addAll(indexTableColumn, firstNameTableColumn, lastNameTableColumn);

		vBox.getChildren().addAll(tableView, hBox);

		Scene scene = new Scene(vBox);
		stage.setScene(scene);
		stage.show();
	}

	public ObservableList<Item> getItems() {
		ObservableList<Item> items = FXCollections.observableArrayList();
		items.add(new Item(1, "Bobby", "Estey"));
		items.add(new Item(2, "Ester", "Estey"));
		return items;
	}

	public void addButtonClicked() {
		Item item = new Item();
		item.setIndex(Integer.parseInt(indexTextField.getText()));
		item.setFirstName(firstNameTextField.getText());
		item.setLastName(lastNameTextField.getText());

		tableView.getItems().add(item);
		indexTextField.clear();
		firstNameTextField.clear();
		lastNameTextField.clear();
	}

	public void deleteButtonClicked() {
		ObservableList<Item> itemSelected, allItems;
		allItems = tableView.getItems();
		itemSelected = tableView.getSelectionModel().getSelectedItems();

		// remove all items selected
		itemSelected.forEach(allItems::remove);
	}

	public void detailsButtonClicked() {
		ObservableList<Item> itemSelected, allItems;
		allItems = tableView.getItems();
		itemSelected = tableView.getSelectionModel().getSelectedItems();

		// display item details
		String index = "Index: " + Integer.toString(itemSelected.get(0).getIndex()) + "\n";
		String firstName = "Firstname: " + itemSelected.get(0).getFirstName() + "\n";
		String lastName = "Lastname: " + itemSelected.get(0).getLastName() + "\n";

		AlertBox.display("Alert Box Title", index + firstName + lastName);
	}
}
