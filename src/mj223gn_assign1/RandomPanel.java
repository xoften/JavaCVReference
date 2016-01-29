package mj223gn_assign1;


import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Random;


/**
 * Created by Michael Johansson(mj223gn) on 2016-01-29.
 */
public class RandomPanel extends BorderPane {
    Random number = new Random();

    public void RandomPanel(){
        Button random = new Button("New Random");
        Text randomNumber = new Text();

        random.setOnAction(event -> {randomNumber.setText("" + number.nextInt(100)+1);});
        HBox one = new HBox();
        one.setPrefSize(200,200);
        one.getChildren().add(random);

        HBox two = new HBox();
        two.setPrefSize(200, 200);
        two.getChildren().add(randomNumber);

        VBox root = new VBox();
        root.getChildren().addAll(one, two);

    }
}
