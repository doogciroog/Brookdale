/*
Doug Ciraulo
COMP-271-801RL
Assignment #11
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class FindGrade extends Application {

  private Statement stmt;
  private TextField tfFirstName = new TextField();
  private TextField tfLastName = new TextField();
  private TextField tfAge = new TextField();
  private Label lblStatus = new Label();
 
  
  @Override
  public void start(Stage primaryStage) {

    initializeDB();

    Button btShowAge = new Button("Show Age");
    Button btShowAll = new Button("Show All");
    Button btDelete = new Button("Delete Person");
    Button btAdd = new Button("Add Person");
    HBox hBox = new HBox(5);
    hBox.getChildren().addAll(new Label("First Name"), tfFirstName, 
            new Label("Last Name"), tfLastName,
            btShowAge, tfAge, btShowAll, btAdd, btDelete );
    VBox vBox = new VBox(10);
    vBox.getChildren().addAll(hBox, lblStatus);
    
    tfFirstName.setPrefColumnCount(6);
  
    btShowAge.setOnAction(e -> showAge());
    btShowAll.setOnAction(e -> showAll());
    btAdd.setOnAction(e -> addSomeone());
    btDelete.setOnAction(e -> deleteSomeone());
    
    Scene scene = new Scene(vBox, 420, 400);
    primaryStage.setTitle("Find Grade");
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }

  private void initializeDB() {
      
    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded");
      Connection connection = DriverManager.getConnection
        ("jdbc:mysql://localhost/mypeople", "root", "");
      System.out.println("Database connected");
      stmt = connection.createStatement();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    
  }

  private void showAge() throws SQLException {
      
    String fn = tfFirstName.getText();
    int age = 0;
    
    try {
      String queryString =
        "select first_name, last_name, age "
        + "from people "
        + "where first_name = '" + fn + "'";
     
      System.out.println(queryString);
      
      ResultSet rset = stmt.executeQuery(queryString);

      if (rset.next()) {
        boolean notfound = true;
        String output = "";
        
    	while  (rset.next()) {
            String lastName = rset.getString("last_name");
            String firstName = rset.getString("first_name");
            age = rset.getInt("age");
       
            output += firstName + " " + lastName + " " + age + "\n";
        
            notfound = false;
        } 
    	 
    	 if(notfound) {
            lblStatus.setText("Not found");
         }
         else {
            lblStatus.setText(output );
    	 }
       }
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }
    
  }

 private void showAll() throws SQLException {
   
   try {
     String queryString ="select * from people";

     ResultSet rset = stmt.executeQuery(queryString);

     if (rset.next()) {
        boolean notfound = true;
        String output = "";
        
   	while  (rset.next()) {
            int id = rset.getInt("id");
            String lastName = rset.getString("last_name");
            String firstName = rset.getString("first_name");
            int age = rset.getInt("age");
            output += id + " " + firstName + " " + lastName + " " + age + "\n";
            notfound = false;
        } 
   	 
   	 if(notfound) {
            lblStatus.setText("Not found");
         }
         else {
            lblStatus.setText(output );
   	 }
    }
   }
   catch (SQLException ex) {
     ex.printStackTrace();
   }
   
 }

private void deleteSomeone() {
    
    String fn = tfFirstName.getText();
    String ln = tfLastName.getText();
    String age = tfAge.getText();
  
    try {
        String queryString ="delete from people where first_name = '" + fn 
                + "' AND last_name = '" + ln + "'";
     
        stmt.executeUpdate(queryString);

        showAll();
    }
    catch (SQLException ex) {
        ex.printStackTrace();
    }
    
}

private void addSomeone() {
    
    String fn = tfFirstName.getText();
    String ln = tfLastName.getText();
    String age = tfAge.getText();
        
    try {
        String queryString ="insert into people values ("+ln+"','"+fn+"','"+age+")";
            
        stmt.executeUpdate(queryString);
    }
    catch (SQLException ex){
        ex.printStackTrace();
    }
    
}

  public static void main(String[] args) {
    launch(args);
  }
  
}