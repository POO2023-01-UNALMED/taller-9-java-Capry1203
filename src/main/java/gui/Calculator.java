package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.*;

public class Calculator extends VBox implements EventHandler<ActionEvent>{ //Cambio ActionEvent
	
	String number1 = "";
	String number2 = "";
	String operator;
	float resultado = 0;
	Text displayText;
	
	public Calculator(){
		super(10);
		this.displayText = new Text("0");
		
		Rectangle rt = new Rectangle(250, 50, Color.TRANSPARENT);
		
		rt.setStroke(Color.GRAY);
		
		StackPane sp =  new StackPane(rt, this.displayText);
		
		sp.setPadding(new Insets(10, 10, 10, 10));
		
		GridPane gd = new GridPane(); //Cambio GridPane
		
		gd.setPadding(new Insets(10, 10, 10, 10));
		gd.setVgap(5);
		gd.setHgap(4);
		
		gd.setAlignment(Pos.CENTER);//Cambio TOP_LEFT
		
		Button b7 = new Button("7"); //Cambio button
		gd.add(b7, 0, 0); //Cambio temporal
		b7.setPrefWidth(50);
		b7.setOnAction(this);
		
		Button b8 = new Button("8"); //Cambio button 
		gd.add(b8, 1, 0);//Cambio temporal
		b8.setPrefWidth(50);
		b8.setOnAction(this);
		
		Button b9 = new Button("9"); //Cambio "9"
		gd.add(b9, 2, 0);//Cambio temporal
		b9.setPrefWidth(50);
		b9.setOnAction(this);
		
		Button div = new Button("/");
		gd.add(div, 3, 0);//Cambio temporal
		div.setPrefWidth(50);
		div.setOnAction(this);//Cambio this
		
		Button b4 = new Button("4"); //Cambio button
		gd.add(b4, 0, 1);
		b4.setPrefWidth(50);
		b4.setOnAction(this);
		
		Button b5 = new Button("5"); //Cambio button 
 		gd.add(b5, 1, 1); //Cambio add
		b5.setPrefWidth(50);
		b5.setOnAction(this);
		
		Button b6 = new Button("6");
		gd.add(b6, 2, 1);//Cambio temporal
		b6.setPrefWidth(50);
		b6.setOnAction(this); //Cambio b6.
		
		Button mul = new Button("*"); //Cambio button
		gd.add(mul, 3, 1);//Cambio temporal
		mul.setPrefWidth(50);
		mul.setOnAction(this);
		
		Button b1 = new Button("1"); //Cambio "1"
		gd.add(b1, 0, 2);//Cambio temporal
		b1.setPrefWidth(50);
		b1.setOnAction(this);
		
		Button b2 = new Button("2"); //Cambio button
		gd.add(b2, 1, 2);//Cambio temporal
		b2.setPrefWidth(50);
		b2.setOnAction(this);
		
		Button b3 = new Button("3"); //Cambio button
		gd.add(b3, 2, 2); //Cambio gd
		b3.setPrefWidth(50);
		b3.setOnAction(this); // Cambio this
		
		Button minus = new Button("-"); //Cambio button
		gd.add(minus, 3, 2);//Cambio temporal
		minus.setPrefWidth(50);
		minus.setOnAction(this);
		
		Button b0 = new Button("0"); //Cambio button
		gd.add(b0, 0, 3, 2, 1);
		b0.setPrefWidth(105);
		b0.setOnAction(this); //Cambio b0.
		
		Button plus = new Button("+");
		gd.add(plus, 2, 3); //Cambio add y //Cambio temporal
		plus.setPrefWidth(50);
		plus.setOnAction(this);
		
		Button equals = new Button("="); //Cambio "="
		gd.add(equals, 3, 3); //Cambio gd
		equals.setPrefWidth(50);
		equals.setOnAction(this);
		
		Button reset = new Button("C"); //Cambio button
		gd.add(reset, 0, 4, 4, 1);//Cambio temporal
		reset.setPrefWidth(215);
		reset.setOnAction(this); //Cambio this
		
		this.getChildren().addAll(sp, gd);
	}

	@Override
	public void handle(ActionEvent event) {
		
		Button b = (Button) event.getSource();
		String value = b.getText();
		
		//***
		//***
		//***
		String[] nums = {"0","1","2","3","4","5","6","7","8","9"};
		List<String> listaNums = Arrays.asList(nums);
		String[] operators = {"+","-","/","*"};
		List<String> listaOperators = Arrays.asList(operators);
		if(displayText.getText().equals("0") && listaNums.contains(value) && operator == null){//!value.equals("0") &&
			displayText.setText(value);
			number1 +=value;
		}else if(!displayText.getText().equals("0") && listaNums.contains(value) && operator ==null){
			
			number1+=value;
			displayText.setText(number1);

		}else if(listaOperators.contains(value)){
			if(operator==null && number1!=""){//&& !number1.equals("")
				operator = value;
				displayText.setText(number1 + operator);
			}else {
				displayText.setText("Syntax ERROR");
				operator = null;
				number1 ="";
				number2="";
			}
		}else if(operator!= null && listaNums.contains(value)){
			number2 += value;
			displayText.setText(number1 + operator + number2);
		}
		 if(value.equals("C")){
			operator = null;
			number1 = "";
			number2 = "";
			displayText.setText("0");
		}else if(value.equals("=")){
			if(operator.equals("+")){
				float num1 = Float.parseFloat(number1), num2 = Float.parseFloat(number2);
				resultado = num1 + num2;
				displayText.setText(Float.toString(resultado));
				operator = null;
				number1 = "";
				number2="";
			}else if(operator.equals("-")){
				float num1 = Float.parseFloat(number1), num2 = Float.parseFloat(number2);
				resultado = num1 - num2;
				displayText.setText(Float.toString(resultado));
				operator = null;
				number1 = "";
				number2="";
			}else if(operator.equals("*")){
				float num1 = Float.parseFloat(number1), num2 = Float.parseFloat(number2);
				resultado = num1 * num2;
				displayText.setText(Float.toString(resultado));
				operator = null;
				number1 = "";
				number2="";
			}else if(operator.equals("/")){
				if(!number2.isEmpty() && !number2.equals("0")){
					float num1 = Float.parseFloat(number1), num2 = Float.parseFloat(number2);
					resultado = num1 / num2;
					displayText.setText(Float.toString(resultado));
					operator = null;
					number1 = "";
					number2="";
					
				}else{
					displayText.setText("Syntax ERROR");
					number1 =""; number2 = "";
					operator = null;
				}
			}
				
		}
	}
}
