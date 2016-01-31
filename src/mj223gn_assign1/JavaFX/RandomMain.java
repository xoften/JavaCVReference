package mj223gn_assign1.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Michaels on 2016-01-29.
 * Creates our GUI that writes out a random number between 1-100 when the button is pressed.
 */
public class RandomMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates an stage with our randomPanel class
     * @param primaryStage main stage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new RandomPanel()));
        primaryStage.setTitle("Exercise 8, Randompanel");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
