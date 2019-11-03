package controller;

import java.awt.event.MouseListener;
import java.io.IOException;

import com.sun.javafx.scene.control.skin.ButtonSkin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import modelo.Buscaminas;

public class levelController extends Application {

	private Buscaminas tab;

	@FXML
	private Label coordenadas;

	@FXML
	private Pane grid;

	@Override
	public void start(Stage stage) throws Exception {

	}

	public void initialize() {

	}

	public void initializeTable() {
		tab = new Buscaminas(tab.darNivel());
		GridPane theGrid = new GridPane();
		grid.getChildren().add(theGrid);

		int rows = tab.darCasillas().length;
		int cols = tab.darCasillas()[0].length;

		/*
		 * theGrid.setMinHeight(400); theGrid.setMaxHeight(400);
		 * theGrid.setMinWidth(400); theGrid.setMaxWidth(400);
		 * 
		 * for (int i = 0; i < rows; i++) { ColumnConstraints colConst = new
		 * ColumnConstraints(); colConst.setPercentWidth(100.0 / cols);
		 * theGrid.getColumnConstraints().add(colConst); } for (int i = 0; i < cols;
		 * i++) { RowConstraints rowConst = new RowConstraints();
		 * rowConst.setPercentHeight(100.0 / rows);
		 * theGrid.getRowConstraints().add(rowConst); }
		 */
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				Button b = new Button();
				final int i_button = i;
				final int j_button = j;
				b.setMinSize(28, 28);
				b.setOnAction(e -> {

					coordenadas.setText(i_button + "," + j_button);
					
//					Media media = new Media("/resources/boom.mp3");
//					media.setOnError(() -> System.out.println("error media"));
//
//					MediaPlayer player = new MediaPlayer(media);
					
					
					if(true) {
						
						if(!b.getText().equals("|>")) {
							tab.abrirCasilla(i_button, j_button);
							if(!tab.darCasillas()[i_button][j_button].esMina())
								b.setText(Integer.toString(tab.darCasillas()[i_button][j_button].darValor()));
							else {
								b.setText("*");
								Alert a = new Alert(AlertType.INFORMATION, "OH NOOOOO");
								a.setTitle("Perdiste :(");
//								player.play();
								a.showAndWait();
								reiniciar();
							}
						
						}
					}
					else{
						
						if(b.getText().equals("|>")) {
							
							b.setText("");
						}
						else {
							b.setText("|>");
						}
					}
					
					
				});

				theGrid.add(b, j, i);

			}
		}
	}

	public void setTab(Buscaminas ms) {
		this.tab = ms;
	}
	
	public void reiniciar() {
		
		grid.getChildren().clear();
		initializeTable();
	}
	
	public void darPista(ActionEvent eo) {
		
		String pis = tab.darPista();
		
		String p[] = pis.split(",");
		
		if(pis.equals("-")) {
			
			Alert a = new Alert(AlertType.INFORMATION, "No hay más pistas disponibles.");
			a.showAndWait();
		}
		else {

			try {
				
				tab.abrirCasilla(Integer.parseInt(p[0]), Integer.parseInt(p[1]));
				
				
				GridPane kk = (GridPane) grid.getChildren().get(0);
				
				((Button) kk.getChildren().get(1)).setText(Integer.toString(tab.darCasillas()[Integer.parseInt(p[0])-1][Integer.parseInt(p[1])-1].darValor()));
				
			}catch(Exception e) {
				Alert a = new Alert(AlertType.INFORMATION, "No hay más pistas disponibles.");
				a.showAndWait();
			}
		}
			
		
		
	}
	
	public void goBack(ActionEvent ae) {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/mainMenu.fxml"));

		Parent root = new Pane();
		try {
			root = (Parent) loader.load();

		} catch (IOException e) {

			System.out.println("OH NoOoOOooOooOooOOooo");

			e.printStackTrace();
		}

		Stage st = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		st.setScene(new Scene(root));

	}
	
	
	
	

}
