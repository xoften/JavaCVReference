package mj223gn_assign1.JavaFX;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Random;


/**
 * Created by Michael Johansson(mj223gn) on 2016-01-29.
 * Class randomPanel that creates an extended version of a borderPane with a button and text that gets a random number
 *
 */
public class RandomPanel extends BorderPane {

    Random number = new Random();

    public RandomPanel() {
        //Text that prints out the random number
        Text numberText = new Text();
        numberText.setStyle("-fx-font-size: 300");
        numberText.setText("");

        //Button that change the text when pressed
        Button random = new Button("New Random");
        random.setOnAction(e -> {numberText.setText((number.nextInt(100)+1) +"");});

        //box that holds the text
        VBox buttonSide = new VBox();
        buttonSide.setStyle("-fx-background-color: cornflowerblue");
        buttonSide.setAlignment(Pos.CENTER);
        buttonSide.getChildren().add(random);
        buttonSide.setMinSize(400, 100);

        //box that holds the button
        VBox textSide = new VBox();
        textSide.setStyle("-fx-background-color: grey");
        textSide.setAlignment(Pos.CENTER);
        textSide.getChildren().add(numberText);
        textSide.setMinSize(400,200);

        //sets a scene
        this.setMinSize(400,300);
        this.setTop(textSide);
        this.setBottom(buttonSide);
        }


}
