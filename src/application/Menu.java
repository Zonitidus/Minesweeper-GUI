package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Buscaminas;

public class Menu extends Application {

	public static Stage primaryStage;

	@Override
	public void start(Stage stage) throws Exception {

		this.primaryStage = stage;

		Parent root = FXMLLoader.load(getClass().getResource("/application/mainMenu.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setTitle("SELECT A DIFFICULTY");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

	private Stage getPStage() {
		return primaryStage;
	}

}
