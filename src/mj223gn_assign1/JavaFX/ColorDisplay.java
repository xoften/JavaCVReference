package mj223gn_assign1.JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by Michaels on 2016-01-29.
 * This class creates a JavaFX stage that with different values in red,green,blue change the
 * background color of the top panel.
 */
public class ColorDisplay extends Application {

    private int redColor;
    private int greenColor;
    private int blueColor;
    private String hexValue;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Different text objects
        Text error = new Text(25,25,"");
        error.setStyle("-fx-font-size: 30");
        Text colorDisplay = new Text("Color Display");
        colorDisplay.setStyle("-fx-font-size: 40");
        Label red = new Label("Red");
        red.setStyle("-fx-font-size: 24");
        GridPane.setConstraints(red, 0,0);
        Label green = new Label("Green");
        green.setStyle("-fx-font-size: 24");
        GridPane.setConstraints(green, 1,0);
        Label blue = new Label("Blue");
        blue.setStyle("-fx-font-size: 24");
        GridPane.setConstraints(blue, 2, 0);

        //TextField for where to input RGB numbers
        TextField redNumber = new TextField();
        GridPane.setConstraints(redNumber,0,1);
        TextField greenNumber = new TextField();
        GridPane.setConstraints(greenNumber,1,1);
        TextField blueNumber = new TextField();
        GridPane.setConstraints(blueNumber,2,1);

        //vbox for the top box
        VBox display = new VBox();
        display.setPadding(new Insets(5,5,5,5));
        display.setMinSize(400,100);
        display.getChildren().add(colorDisplay);
        display.setAlignment(Pos.CENTER);

        //gridpane for the text and
        GridPane grid = new GridPane();
        grid.setMinSize(400,150);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.getChildren().addAll(red,green,blue,redNumber,greenNumber,blueNumber);

        //Button with actions
        Button displayButton = new Button("Display Color");
        displayButton.setOnAction(e -> {
            redColor = Integer.valueOf(redNumber.getText());
            greenColor = Integer.valueOf(greenNumber.getText());
            blueColor = Integer.valueOf(blueNumber.getText());
            if(valueInsideBounds(redColor,greenColor,blueColor)) {
                //takes RGB values and change it to a hex value
                hexValue = String.format("#%02x%02x%02x", redColor, greenColor, blueColor);
                display.setStyle("-fx-background-color: " + hexValue);
                error.setText("");
            }
            else
                error.setText("Invalid input for RGB colors!");



        });
        //Box that shows the error message
        VBox errorText = new VBox();
        errorText.getChildren().add(error);
        errorText.setAlignment(Pos.TOP_CENTER);

        //vbox for the button
        VBox button = new VBox();
        button.setPadding(new Insets(5,5,5,5));
        button.setMinSize(400,100);
        button.getChildren().add(displayButton);

        //Vbox for the Four boxes
        VBox all = new VBox();
        all.setPadding(new Insets(5,5,5,5));
        all.setMinSize(400,400);
        all.getChildren().addAll(display,grid,errorText,displayButton);
        all.setAlignment(Pos.CENTER);
        Pane root = new Pane();
        root.getChildren().add(all);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Exercise 9, Color Display");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Method to check if the values is in bounds for RGB numbers
     * @param r red number
     * @param g green number
     * @param b blue number
     * @return true if values is in bound, else false
     */
    private boolean valueInsideBounds(int r, int g, int b){
        int valuesInsideBounds = 0;
        if(r <= 255 && r >= 0)
            valuesInsideBounds++;
        if(g <= 255 && g >= 0)
            valuesInsideBounds++;
        if(b <= 255 && b >= 0)
            valuesInsideBounds++;

            return valuesInsideBounds == 3;

    }
}
