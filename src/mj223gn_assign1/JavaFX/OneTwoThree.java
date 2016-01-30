package mj223gn_assign1.JavaFX;/**
 * Created by Michael Johansson(mj223gn) on 2016-01-29.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OneTwoThree extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text textOne = new Text("One");
        textOne.setStyle("-fx-font-size: 36");
        Text textTwo = new Text("Two");
        textTwo.setStyle("-fx-font-size: 36");
        Text textThree = new Text("Three");
        textThree.setStyle("-fx-font-size: 36");


        VBox one = new VBox(3);
        one.setStyle("-fx-background-color: yellow");
        one.getChildren().add(textOne);
        one.setAlignment(Pos.TOP_LEFT);
        one.setMinSize(500,100);
        VBox two = new VBox(3);
        two.setStyle("-fx-background-color: red");
        two.getChildren().add(textTwo);
        two.setAlignment(Pos.CENTER);
        two.setMinSize(500,100);
        VBox three = new VBox(3);
        three.setStyle("-fx-background-color: green");
        three.getChildren().add(textThree);
        three.setAlignment(Pos.BOTTOM_RIGHT);
        three.setMinSize(500,100);

        VBox four = new VBox(3);
        four.setStyle("-fx-background-color: black");

        four.getChildren().addAll(one,two,three);

        Scene scene = new Scene(four, 500, 300);
        primaryStage.setTitle("One, Two, Three");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }



}

