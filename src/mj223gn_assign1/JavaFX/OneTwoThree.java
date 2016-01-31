package mj223gn_assign1.JavaFX;

/**
 * Created by Michael Johansson(mj223gn) on 2016-01-29.
 * Create a JavaFX application that shows 3 panels with different colors and different text
 *
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OneTwoThree extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Text to show in panels
        Text textOne = new Text("One");
        textOne.setStyle("-fx-font-size: 36");
        Text textTwo = new Text("Two");
        textTwo.setStyle("-fx-font-size: 36");
        Text textThree = new Text("Three");
        textThree.setStyle("-fx-font-size: 36");

        //first box
        VBox one = new VBox(3);
        one.setStyle("-fx-background-color: yellow");
        one.getChildren().add(textOne);
        //alignment for the text
        one.setAlignment(Pos.TOP_LEFT);
        one.setMinSize(500,100);

        //second box
        VBox two = new VBox(3);
        two.setStyle("-fx-background-color: red");
        two.getChildren().add(textTwo);
        two.setAlignment(Pos.CENTER);
        two.setMinSize(500,100);

        //three box
        VBox three = new VBox(3);
        three.setStyle("-fx-background-color: green");
        three.getChildren().add(textThree);
        three.setAlignment(Pos.BOTTOM_RIGHT);
        three.setMinSize(500,100);

        //Vertical box to store the three boxes
        VBox four = new VBox(3);
        four.setStyle("-fx-background-color: black");

        //add the three children to the parent
        four.getChildren().addAll(one,two,three);

        //Create the stage
        Scene scene = new Scene(four, 500, 300);
        primaryStage.setTitle("Exercise 7, One, Two, Three");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }



}

