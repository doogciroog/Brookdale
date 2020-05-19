/*
Doug Ciraulo
COMP-271-801RL
Assignment #7
 */
package comp271_assignment7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Comp271_Assignment7 extends Application {

    double number1;
    double number2;
    double answer;
    
    @Override
    public void start(Stage primaryStage){
        
        HBox numbers = new HBox();
        numbers.setSpacing(10);
        numbers.setAlignment(Pos.CENTER);
        
        Label lblNumber1 = new Label("Number 1: ");
        TextField tfNumber1 = new TextField();
        
        Label lblNumber2 = new Label("Number 2: ");
        TextField tfNumber2 = new TextField();
        
        Label lblResult = new Label("Result: ");
        TextField tfResult = new TextField();
        
        numbers.getChildren().addAll(
                lblNumber1, tfNumber1,
                lblNumber2, tfNumber2,
                lblResult, tfResult);
        
        Button btAdd = new Button("Add");
        btAdd.setOnAction(e ->{
            answer = Double.parseDouble(tfNumber1.getText()) + Double.parseDouble(tfNumber2.getText());
            tfResult.setText(answer + "");
        });
        
        Button btSubtract = new Button("Subtract");
        btSubtract.setOnAction(e ->{
            answer = Double.parseDouble(tfNumber1.getText()) - Double.parseDouble(tfNumber2.getText());
            tfResult.setText(answer + "");
        });
        
        Button btMultiply = new Button ("Multiply");
        btMultiply.setOnAction(e ->{
            answer = Double.parseDouble(tfNumber1.getText()) * Double.parseDouble(tfNumber2.getText());
            tfResult.setText(answer + "");
        });
        
        Button btDivide = new Button ("Divide");
        btDivide.setOnAction(e ->{
            answer = Double.parseDouble(tfNumber1.getText()) / Double.parseDouble(tfNumber2.getText());
            tfResult.setText(answer + ""); 
        });
        
        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);
        
        VBox main = new VBox();
        main.getChildren().addAll(numbers, buttons);
        primaryStage.setScene(new Scene(main));
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
