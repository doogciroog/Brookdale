/*
Doug Ciraulo
COMP-271-801RL
Assignment #6
 */
package comp271_assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Comp271_Assignment6 extends Application {

    @Override
    public void start(Stage primaryStage){
        
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 
                           17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 
                           31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 
                           45, 46, 47, 48, 49, 50, 51, 52};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        java.util.Collections.shuffle(list);
        
        Pane cardPane = new HBox();
        cardPane.getChildren().add(new ImageView(new Image("cards/"+list.get(0)+".png")));
        cardPane.getChildren().add(new ImageView(new Image("cards/"+list.get(1)+".png")));
        cardPane.getChildren().add(new ImageView(new Image("cards/"+list.get(2)+".png")));
        cardPane.getChildren().add(new ImageView(new Image("cards/"+list.get(3)+".png")));
        
        Button refresh = new Button("Refresh");
        refresh.setOnAction((ActionEvent e) ->{
            cardPane.getChildren().clear();
            java.util.Collections.shuffle(list);
            cardPane.getChildren().add(new ImageView(new Image("cards/"+list.get(0)+".png")));
            cardPane.getChildren().add(new ImageView(new Image("cards/"+list.get(1)+".png")));
            cardPane.getChildren().add(new ImageView(new Image("cards/"+list.get(2)+".png")));
            cardPane.getChildren().add(new ImageView(new Image("cards/"+list.get(3)+".png")));
        });
        
        Pane mainPane = new VBox();
        mainPane.getChildren().add(cardPane);
        mainPane.getChildren().add(refresh);
        Scene scene = new Scene(mainPane);
        primaryStage.setTitle("3 Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
