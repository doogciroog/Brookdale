/*
Doug Ciraulo
COMP-271-801RL
Assignment #9
 */
package comp271_assignment9;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Comp271_Assignment9 extends Application {

    private double loanAmount;
    private int numYears;
    private double monthlyInterestRate;
    private double monthlyPayment;
    private double totalPayment;
    
    TextField tfLoan = new TextField();
    TextField tfNumYears = new TextField();
    TextArea taTable = new TextArea();
    
    @Override
    public void start (Stage primaryStage) {
        
        Label lblLoan = new Label("Loan Amount: ");
        Label lblNumYears = new Label("Number of Years: ");
        Button btShow = new Button("Show Table");
        
        HBox inputPane = new HBox();
        inputPane.setSpacing(10);
        inputPane.setAlignment(Pos.CENTER_LEFT);
        inputPane.getChildren().addAll(lblLoan, tfLoan, lblNumYears, tfNumYears, btShow);
        ScrollPane outputPane = new ScrollPane(taTable);
        
        btShow.setOnAction(e -> {
            try{
                showRates();
            }
            catch(Exception ex){
                taTable.setText("Please fill out both fields");
            }
        });
        
        VBox main = new VBox();
        main.getChildren().addAll(inputPane, outputPane);
        primaryStage.setScene(new Scene(main));
        primaryStage.setTitle("Loan Calculator");
        primaryStage.show();
        
    }
    
    public void showRates(){
        
        loanAmount = Double.parseDouble(tfLoan.getText());
        numYears = Integer.parseInt(tfNumYears.getText());
        
        String rates = String.format("%-20s%-20s%-20s\n", "Interest Rate", "Monthly Payment", "Total Payment");

        for (double annualInterestRate = 5.0; annualInterestRate <= 8.0; annualInterestRate += 1.0 / 8) {
            monthlyInterestRate = annualInterestRate / 1200;

            monthlyPayment = loanAmount * monthlyInterestRate /
                (1 - (Math.pow(1 / (1 + monthlyInterestRate), numYears * 12)));
            totalPayment = monthlyPayment * numYears * 12;

            rates += String.format("%5.3f%c %20c%.2f %20c%.2f\n", annualInterestRate, '%', '$', monthlyPayment, '$', totalPayment);
        }
        
        taTable.setText(rates);
        
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}