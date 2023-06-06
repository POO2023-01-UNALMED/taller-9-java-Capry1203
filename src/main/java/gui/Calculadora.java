package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Application  {
	
	public static void main(String args[]){ 
	      Application.launch(args); //Cambio Application.launch
	} 
	
	@Override
	public void start(Stage window) throws Exception {
		VBox vb = new VBox(); // cambio VBox
		window.setTitle("Calculadora"); //Cambio "Calculadora"
		
		vb.getChildren().add(new Calculator());
		Scene sc = new Scene(vb, 270, 270); // Cambio vb
		window.setScene(sc); //Cambio (sc)
		window.show(); //Cambio window.
	}
	
}
