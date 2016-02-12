package mj223gn_assign2;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-10.
 */
public class UpDownPane{

    private int column;
    private int row;

    public UpDownPane() {

        column = 3;
        row = 3;
    }

    public Scene createPane(){

        GridPane root = new GridPane();
        root.setPadding(new Insets(5,5,5,5));

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

        Image image = new Image(getClass().getResourceAsStream("linux_logo.png"));
        ImageView view = new ImageView(image);
        root.add(view,column,row);

        Scene scene = new Scene(root, 575  , 575);

        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.UP) {
                row = --row;
                if(row == -1)
                    row = 6;
                GridPane.setRowIndex(view, row);
            }
            else if (e.getCode() == KeyCode.DOWN){
                row = ++row;
                if(row == 7)
                    row = 0;
                GridPane.setRowIndex(view, row);
            }
            else if (e.getCode() == KeyCode.LEFT){
                column = --column;
                if(column == -1)
                    column = 6;
                GridPane.setColumnIndex(view,column);
            }
            else if (e.getCode() == KeyCode.RIGHT){
                column = ++column;
                if(column == 7)
                    column = 0;
                GridPane.setColumnIndex(view,column);
            }

        });
        return scene;
    }
}
