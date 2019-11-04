package controller;

import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import com.sun.javafx.scene.control.skin.ButtonSkin;
import com.sun.media.jfxmedia.AudioClip;

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
import javafx.scene.input.MouseButton;
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

	private MediaPlayer mp;

	@FXML
	private Label coordenadas;

	@FXML
	private Pane grid;


	@Override
	public void start(Stage stage) throws Exception {

	}

	public void initialize() {

	}

	public void initializeTable(Buscaminas t) {
		if (t == null)
			tab = new Buscaminas(tab.darNivel());
		else {
			tab = t;
		}

		GridPane theGrid = new GridPane();
		grid.getChildren().add(theGrid);

		int rows = tab.darCasillas().length;
		int cols = tab.darCasillas()[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				Button b = new Button(tab.darCasillas()[i][j].mostrarValorCasilla());
				final int i_button = i;
				final int j_button = j;
				b.setMinSize(40, 40);
				b.setOnMouseClicked(e -> {

					coordenadas.setText(i_button + "," + j_button);

					if (e.getButton() == MouseButton.PRIMARY) {

						if (!b.getText().equals("|>")) {
							tab.abrirCasilla(i_button, j_button);
							if (!tab.darCasillas()[i_button][j_button].esMina()) {
								b.setText(Integer.toString(tab.darCasillas()[i_button][j_button].darValor()));

								if (tab.gano()) {
									winner();
								}
							} else {
								b.setText("*");
								BOOM();
								Alert a = new Alert(AlertType.INFORMATION, "OH NOOOOO");
								a.setTitle("Mission failed, we'll get em next time");
								a.showAndWait();
								reiniciar();
							}

						}
					} else {

						if (b.getText().equals("|>")) {

							b.setText("");
						} else {
							b.setText("|>");
						}
					}

				});

				theGrid.add(b, j, i);

			}
		}
		
		
		if(tab.gano())
			winner();
	}

	public void setTab(Buscaminas ms) {
		this.tab = ms;
	}

	public void reiniciar() {

		grid.getChildren().clear();
		initializeTable(null);
	}

	public void darPista(ActionEvent eo) {

		String pis = tab.darPista();
		String p[] = pis.split(",");

		if (pis.equals("-")) {

			Alert a = new Alert(AlertType.INFORMATION, "No hay más pistas disponibles.");
			a.showAndWait();
		} else {

			tab.abrirCasilla(Integer.parseInt(p[0]) - 1, Integer.parseInt(p[1]) - 1);
			initializeTable(tab);
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

	public void BOOM() {

		String path = "src//resources//boom.mp3";

		Media media = new Media(new File(path).toURI().toString());

		mp = new MediaPlayer(media);
		mp.play();
	}

	public void winner() {

		String path = "src//resources//winner.mp3";

		Media media = new Media(new File(path).toURI().toString());

		mp = new MediaPlayer(media);
		mp.play();
		
		Alert a = new Alert(AlertType.INFORMATION, "Very impresisve");
		a.setTitle(":)");
		a.showAndWait();
		reiniciar();

	}
	
	public void resolve(ActionEvent eo) {
		
		tab.resolver();
		initializeTable(tab);
	}

}
