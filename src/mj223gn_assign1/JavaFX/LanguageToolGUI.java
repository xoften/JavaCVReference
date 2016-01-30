package mj223gn_assign1.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Michaels on 2016-01-30.
 */
public class LanguageToolGUI extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //file Menu
        Menu fileMenu = new Menu("File");

        //Open file item
        MenuItem openFile = new MenuItem("Open File");
        openFile.setOnAction(e -> { FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT files (*.txt)","*.txt"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null){

            }
        });
        //New file item
        MenuItem newFile = new MenuItem("New...");
        newFile.setDisable(true);
        //Exit item
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e-> System.exit(0));

        fileMenu.getItems().addAll(newFile,openFile,exit);

        //MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

        Button buttonFile = new Button("Choose File: ");
        buttonFile.setOnAction(e -> { FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT files (*.txt)","*.txt"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null){

            }
        });

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setLeft(buttonFile);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
