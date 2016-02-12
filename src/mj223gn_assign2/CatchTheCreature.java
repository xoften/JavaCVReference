package mj223gn_assign2;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-11.
 */
public class CatchTheCreature extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private int hitCount = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();

        Text count = new Text("Hit count: " + hitCount);
        count.setStyle("-fx-font-size: 50");
        count.setFill(Color.RED);
        count.setLayoutX(20);
        count.setLayoutY(780);

        Image background = new Image(getClass().getResourceAsStream("background.jpg"));
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitHeight(800);
        backgroundView.setFitWidth(1500);

        Creature shark = new Creature();

        FadeTransition fade= new FadeTransition(Duration.millis(1000), shark);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.setByValue(0.3);
        fade.setCycleCount(2);
        fade.setAutoReverse(true);
        setPosition(shark);
        fade.setOnFinished(e -> {
            setPosition(shark);
            fade.playFromStart();
        });

        Pane pane = new Pane();

        pane.getChildren().addAll(backgroundView,shark);
        root.getChildren().addAll(pane,count);
        Scene scene = new Scene(root, 1500, 800);

        scene.setOnMouseClicked(e ->{

            if(shark.sharkGotHit())
                count.setText("Hit count: " + ++hitCount);
        });

        fade.play();
        primaryStage.setScene(scene);
        primaryStage.show();


    }
       public void setPosition(ImageView shark){
        Random raX = new Random();
        Random raY = new Random();
        shark.setX(raX.nextInt(1500-400));
        shark.setY(raY.nextInt(700-196));

    }
}
