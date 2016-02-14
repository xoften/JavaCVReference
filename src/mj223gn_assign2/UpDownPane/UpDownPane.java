package mj223gn_assign2.UpDownPane;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * UpDownPane class
 * Created by Michael Johansson(mj223gn) on 2016-02-10.
 */
public class UpDownPane{

    private int column;
    private int row;

    public UpDownPane() {

        column = 3;
        row = 3;
    }

    /**
     * Method to create a scene  with our UpDownPane.
     * @return scene with UpDownPane
     */
    public Scene createScene(){

        //gridpane as root pane
        GridPane root = new GridPane();
        root.setPadding(new Insets(5,5,5,5));

        //create 49 VBox and set them into gridpane
        for(int rows = 0; rows < 7; rows++){
            for(int columns = 0; columns < 7; columns++){
                VBox box = new VBox();
                box.setMinSize(80,80);
                root.setHgap(1);
                root.setVgap(1);
                box.setStyle("-fx-background-color: lightslategray");
                root.add(box, rows, columns);
            }
        }

        //create image and put it at the center of gridpane
        Image image = new Image(getClass().getResourceAsStream("blue.png"));
        ImageView view = new ImageView(image);
        root.add(view,column,row);

        //create scene
        Scene scene = new Scene(root, 575  , 575);

        //we move the image when we press up,down,left or right.
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.UP) {
                row = --row;
                //if row is -1 we change row to row 6.
                if(row == -1)
                    row = 6;
                GridPane.setRowIndex(view, row);
            }
            else if (e.getCode() == KeyCode.DOWN){
                row = ++row;
                //if row is 7 we change row to zero
                if(row == 7)
                    row = 0;
                GridPane.setRowIndex(view, row);
            }
            else if (e.getCode() == KeyCode.LEFT){
                column = --column;
                //if column is -1 we change column to column 6.
                if(column == -1)
                    column = 6;
                GridPane.setColumnIndex(view,column);
            }
            else if (e.getCode() == KeyCode.RIGHT){
                column = ++column;
                //if column is 7 we change column to column zero.
                if(column == 7)
                    column = 0;
                GridPane.setColumnIndex(view,column);
            }

        });
        return scene;
    }
}
