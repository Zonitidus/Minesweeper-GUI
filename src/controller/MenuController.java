package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Buscaminas;
import application.*;

public class MenuController implements Initializable {

	private Buscaminas tab;
	
	@FXML private Button noobie;
	@FXML private Button medium;
	@FXML private Button hard;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}

	public void selectDifficulty(ActionEvent ae) {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/minesweeperGrid.fxml"));

		Parent root;
		
		int lX = 0;
		int lY = 0;
		int minH = 0;
		int maxH = 0;
		int minW = 0;
		int maxW = 0;
		
		int dif = 0;
		
		if(ae.getSource().equals(noobie))
			dif = Buscaminas.PRINCIPIANTE;
		else if(ae.getSource().equals(medium))
			dif = Buscaminas.INTERMEDIO;
		else 
			dif = Buscaminas.EXPERTO;
		
		this.tab = new Buscaminas(dif);
		try {
			root = (Parent) loader.load();
			Pane p = (Pane) root;

			GridPane tab = new GridPane();

			tab.setLayoutX(lX);
			tab.setLayoutY(lY);

			p.getChildren().add(tab);

			levelController l = loader.getController();
			l.setTab(this.tab);
			l.initializeTable();
			
			Stage st = (Stage) ((Node) ae.getSource()).getScene().getWindow();
			st.setScene(new Scene(root));

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
}
