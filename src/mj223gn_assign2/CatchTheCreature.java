package mj223gn_assign2;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;

/**
 * Main class for catch the creature that constructs a stage we can use
 * Created by Michael Johansson(mj223gn) on 2016-02-11.
 */
public class CatchTheCreature extends Application {

    private int hitCount = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();

        //Text to show how many times we hit the shark
        Text count = new Text("Hit count: " + hitCount);
        count.setStyle("-fx-font-size: 50");
        count.setFill(Color.RED);
        count.setLayoutX(20);
        count.setLayoutY(780);

        //background image
        Image background = new Image(getClass().getResourceAsStream("background.jpg"));
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitHeight(800);
        backgroundView.setFitWidth(1500);

        //create a new creature object
        Creature shark = new Creature();

        //fade transition that we use to move our creature
        FadeTransition fade = new FadeTransition(Duration.millis(1500), shark);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.setByValue(0.5);
        fade.setCycleCount(2);
        fade.setAutoReverse(true);
        setPosition(shark);
        //when the cycles is finished we set a new position and start the transition all over again.
        fade.setOnFinished(e -> {
            setPosition(shark);
            fade.playFromStart();
        });

        //create a pane to hold the background and the creature
        Pane pane = new Pane();
        pane.getChildren().addAll(backgroundView, shark);

        //then add it to the group
        root.getChildren().addAll(pane, count);
        Scene scene = new Scene(root, 1500, 800);

        //when clicked on scene we call the method in creature to tell us if we clicked it.
        scene.setOnMouseClicked(e -> {

            //if creature is hit we add one to our counter
            if (shark.sharkGotHit())
                count.setText("Hit count: " + ++hitCount);
        });

        fade.play();
        primaryStage.setTitle("Exercise 6, Catch the Creature");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Method to set creature on a random position
     * @param shark creature that shall be changed
     */
    public void setPosition(ImageView shark) {
        Random raX = new Random();
        Random raY = new Random();
        shark.setX(raX.nextInt(1500 - 400));
        shark.setY(raY.nextInt(700 - 196));

    }
}
