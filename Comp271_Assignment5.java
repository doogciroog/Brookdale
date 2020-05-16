/*
Doug Ciraulo
COMP-271-801RL
Assignment #5
 */
package comp271_assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Comp271_Assignment5 extends Application {

    @Override
    public void start(Stage primaryStage){
        
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 
                           17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 
                           31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 
                           45, 46, 47, 48, 49, 50, 51, 52};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        java.util.Collections.shuffle(list);
        
        Pane pane = new HBox();
        
        pane.getChildren().add(new ImageView(new Image("cards/"+list.get(0)+".png")));
        pane.getChildren().add(new ImageView(new Image("cards/"+list.get(1)+".png")));
        pane.getChildren().add(new ImageView(new Image("cards/"+list.get(2)+".png")));
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("3 Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}