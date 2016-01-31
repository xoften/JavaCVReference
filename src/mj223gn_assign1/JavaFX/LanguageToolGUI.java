package mj223gn_assign1.JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mj223gn_assign1.LanguageTool.FileReader;

import java.io.File;
import java.io.IOException;

/**
 * Created by Michaels on 2016-01-30.
 * GUI to take in file and using exercise 6, you can open file from the menu on top or by the button.
 *
 */
public class LanguageToolGUI extends Application{


    public static void main(String[] args) {
            launch(args);

    }

    /**
     * Creating a stage.
     * @param primaryStage main stage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Text for GUI
        Text fileName = new Text("Current File: ");

        //text to show the name of the file we check
        TextField file = new TextField();
        file.setEditable(false);
        file.setMaxSize(400,30);
        file.setMinSize(400,30);

        //Texts for our GUI
        Text fileText = new Text(" Text from file ");
        fileText.setStyle("-fx-font-size: 30");
        Text errorText = new Text(" Errors ");
        errorText.setStyle("-fx-font-size: 30");

        //Text Area to show the text we proofreads
        TextArea textFromFile = new TextArea();
        textFromFile.setPadding(new Insets(10,10,10,10));
        textFromFile.setMinSize(500,200);
        textFromFile.setEditable(false);

        //Text area to show errors in the text
        TextArea errors = new TextArea();
        errors.setPadding(new Insets(10,10,10,10));
        errors.setMinSize(500,200);
        errors.setEditable(false);


        //file Menu
        Menu fileMenu = new Menu("File");
            //New file item
            MenuItem newFile = new MenuItem("New...");
            newFile.setDisable(true);
            //Exit item
            MenuItem exit = new MenuItem("Exit");
            exit.setOnAction(e-> System.exit(0));

        //Edit menu
        Menu editMenu = new Menu("Edit");
            //Copy item
            MenuItem copy = new MenuItem("Copy");
            copy.setDisable(true);
            //Paste item
            MenuItem paste = new MenuItem("Paste");
            paste.setDisable(true);
            //Undo item
            MenuItem undo = new MenuItem("Undo");
            undo.setDisable(true);
        //Help menu
        Menu helpMenu = new Menu("Help");


        //Open file item
        MenuItem openFile = new MenuItem("Open File");
        openFile.setOnAction(e -> { FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT files (*.txt)","*.txt"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null){
                try{
                    FileReader reader = new FileReader(selectedFile);
                    file.setText(selectedFile.getAbsolutePath());
                    textFromFile.setText(reader.printFile(selectedFile));
                    errors.setText(reader.proofRead());

                }
                catch (IOException t){
                    System.out.println("Cant read file!");
                }

            }
        });
        //Items in fileMenu
        fileMenu.getItems().addAll(newFile,openFile,exit);
        //Items in editMenu
        editMenu.getItems().addAll(undo,copy,paste);

        //Create menuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        //Button for opening file;
        Button openFileButton = new Button("Open File");
        openFileButton.setOnAction(e -> { FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT files (*.txt)","*.txt"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null){
                try{
                    FileReader reader = new FileReader(selectedFile);
                    file.setText(selectedFile.getAbsolutePath());
                    textFromFile.setText(reader.printFile(selectedFile));
                    errors.setText(reader.proofRead());

                }
                catch (IOException t){
                    System.out.println("Cant read file!");
                }

            }
        });

        //top box with button and text that shows what file we check
        HBox fileBox = new HBox();
        fileBox.setAlignment(Pos.CENTER);
        fileBox.getChildren().addAll(fileName,file, openFileButton);

        //Center box
        VBox middle = new VBox();
        middle.setAlignment(Pos.CENTER);
        middle.getChildren().addAll(fileBox,fileText, textFromFile, errorText, errors);

        //root pane
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: lightgrey");
        root.setTop(menuBar);
        root.setCenter(middle);

        //Sets the stage
        Scene scene = new Scene(root, 650, 600);
        primaryStage.setTitle("Exercise 10, Proofing tool");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
