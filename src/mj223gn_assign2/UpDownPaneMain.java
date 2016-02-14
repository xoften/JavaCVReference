package mj223gn_assign2;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class to create a stage with an UpDownPane scene
 * Created by Michael Johansson(mj223gn) on 2016-02-10.
 */
public class UpDownPaneMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        UpDownPane pane = new UpDownPane();

        primaryStage.setScene(pane.createPane());
        primaryStage.sizeToScene();
        primaryStage.setTitle("Exercise 5, UpDownPane");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
