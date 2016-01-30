package mj223gn_assign1.JavaFX;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Random;


/**
 * Created by Michael Johansson(mj223gn) on 2016-01-29.
 */
public class RandomPanel extends BorderPane {

    Random number = new Random();

    public RandomPanel() {

        Text numberText = new Text();
        numberText.setStyle("-fx-font-size: 300");
        numberText.wrappingWidthProperty();
        numberText.setText("");

        Button random = new Button("New Random");
        random.setOnAction(e -> {numberText.setText((number.nextInt(100)+1) +"");});

        VBox buttonSide = new VBox();
        buttonSide.setStyle("-fx-background-color: cornflowerblue");
        buttonSide.setAlignment(Pos.CENTER);
        buttonSide.getChildren().add(random);
        buttonSide.setMinSize(400, 100);

        VBox textSide = new VBox();
        textSide.setStyle("-fx-background-color: grey");
        textSide.setAlignment(Pos.CENTER);
        textSide.getChildren().add(numberText);
        textSide.setMinSize(400,200);

        this.setMinSize(400,300);
        this.setTop(textSide);
        this.setBottom(buttonSide);
        }


}
