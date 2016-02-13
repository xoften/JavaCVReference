package mj223gn_assign2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-12.
 */
public class HistogramGUI extends Application {

    private int minInterval = 1;
    private int maxInterval = 10;
    private final int MIN_INTERVAL = 1;
    private final int MAX_INTERVAL = 100;
    private final int NUMBER_OF_INTERVALS = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Text for GUI
        Text fileName = new Text("Current File: ");

        Text totalNumbers = new Text("Total number of integers: ");
        totalNumbers.setStyle("-fx-font-size: 30");

        Text notInIntervalText = new Text("Integers not in interval 1-100: ");
        notInIntervalText.setStyle("-fx-font-size: 30");
        //text to show the name of the file we check
        TextField file = new TextField();
        file.setEditable(false);
        file.setMaxSize(400, 30);
        file.setMinSize(400, 30);

        //file Menu
        Menu fileMenu = new Menu("File");
        //New file item
        MenuItem newFile = new MenuItem("New...");
        newFile.setDisable(true);
        //Exit item
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> System.exit(0));

        //VBox to hold our chart.
        VBox chartBox = new VBox();

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
        openFile.setOnAction(e -> {

            //Clear all fields with every button push so we get new list, new barchart and new array.
            chartBox.getChildren().clear();
            int[] numberOfIntsInThisInterval = new int[10];
            ArrayList<Integer> integersInInterval = new ArrayList<>();
            int notInInterval = 0;
            notInIntervalText.setText("Integers not in interval 1-100: ");
            totalNumbers.setText("Total number of integers: ");
            file.setText(null);

            FileChooser fileChooser = new FileChooser();
            //filter so can only choose .dat files
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat"));
            //opens dialog to select a file.
            File selectedFile = fileChooser.showOpenDialog(null);
            //if we cancel we dont go in here.
            if (selectedFile != null) {

                //sets the textfield to the absolute path of the selected file.
                file.setText(selectedFile.getAbsolutePath());

                //Scanner with try and catch for FileNotFound
                Scanner reader = null;
                try {
                    reader = new Scanner(selectedFile);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                //BarChart
                CategoryAxis xAxis = new CategoryAxis();
                NumberAxis yAxis = new NumberAxis();
                //new BarChart
                BarChart<String, Number> ints = new BarChart<>(xAxis, yAxis);

                //name of axises
                xAxis.setLabel("Interval");
                yAxis.setLabel("Number of ints in interval");

                //creates a series
                Series<String, Number> interval = new Series<>();
                interval.setName("Integers from file");

                //we add the chart to our box we created outside the event.
                chartBox.getChildren().add(ints);

                while (reader.hasNextInt()) {

                    int number = reader.nextInt();
                    //when we go trough the file we check if the integer is inside interval
                    //if it is we add it to our list else we add one to our notInInterval counter.
                    if (number <= MAX_INTERVAL && number >= MIN_INTERVAL) {
                        integersInInterval.add(number);
                    } else {
                        notInInterval++;
                    }
                }
                //error message
                if (integersInInterval.size() == 0 && notInInterval == 0) {
                    System.err.println("There is no Integers in file!");
                    System.exit(0);
                }
                //we go through our intervals and add a series to the chart. 1-10, 11-20..., 91-100.
                for (int i = 0; i < NUMBER_OF_INTERVALS; i++) {

                    //sets series to string and the number of integers in this interval. calling our method to check.
                    interval.getData().add(new Data<String, Number>(minInterval + "-" + maxInterval, histogram(integersInInterval, minInterval, maxInterval)));
                    //then adding ten so we get the next inteval.
                    minInterval = minInterval + 10;
                    maxInterval = maxInterval + 10;
                }
                //after we are done we set the intervals to the start position.
                minInterval = 1;
                maxInterval = 10;
                //add the series to the chart
                ints.getData().add(interval);
            }
            //set text to how many integers there is in the file and how many that are not in our interval 1-100
            totalNumbers.setText("Total number of integers: "+ (notInInterval+integersInInterval.size()));
            notInIntervalText.setText("Integers not in interval 1-100: " + notInInterval);
        });

        //Items in fileMenu
        fileMenu.getItems().addAll(newFile, openFile, exit);
        //Items in editMenu
        editMenu.getItems().addAll(undo, copy, paste);

        //Create menuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        //Button for opening file;
        Button openFileButton = new Button("Open File");
        openFileButton.setOnAction(e -> {

            //Clear all fields with every button push so we get new list, new barchart and new array.
            chartBox.getChildren().clear();
            int[] numberOfIntsInThisInterval = new int[10];
            ArrayList<Integer> integersInInterval = new ArrayList<>();
            int notInInterval = 0;
            notInIntervalText.setText("Integers not in interval 1-100: ");
            totalNumbers.setText("Total number of integers: ");
            file.setText(null);

            FileChooser fileChooser = new FileChooser();
            //filter so can only choose .dat files
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat"));
            //opens dialog to select a file.
            File selectedFile = fileChooser.showOpenDialog(null);
            //if we cancel we dont go in here.
            if (selectedFile != null) {

                //sets the textfield to the absolute path of the selected file.
                file.setText(selectedFile.getAbsolutePath());

                //Scanner with try and catch for FileNotFound
                Scanner reader = null;
                try {
                    reader = new Scanner(selectedFile);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                //BarChart
                CategoryAxis xAxis = new CategoryAxis();
                NumberAxis yAxis = new NumberAxis();
                //new BarChart
                BarChart<String, Number> ints = new BarChart<>(xAxis, yAxis);

                //name of axises
                xAxis.setLabel("Interval");
                yAxis.setLabel("Number of ints in interval");

                //creates a series
                Series<String, Number> interval = new Series<>();
                interval.setName("Integers from file");

                //we add the chart to our box we created outside the event.
                chartBox.getChildren().add(ints);

                while (reader.hasNextInt()) {

                    int number = reader.nextInt();
                    //when we go trough the file we check if the integer is inside interval
                    //if it is we add it to our list else we add one to our notInInterval counter.
                    if (number <= MAX_INTERVAL && number >= MIN_INTERVAL) {
                        integersInInterval.add(number);
                    } else {
                        notInInterval++;
                    }
                }
                //error message
                if (integersInInterval.size() == 0 && notInInterval == 0) {
                    System.err.println("There is no Integers in file!");
                    System.exit(0);
                }
                //we go through our intervals and add a series to the chart. 1-10, 11-20..., 91-100.
                for (int i = 0; i < NUMBER_OF_INTERVALS; i++) {

                    //sets series to string and the number of integers in this interval. calling our method to check.
                    interval.getData().add(new Data<String, Number>(minInterval + "-" + maxInterval, histogram(integersInInterval, minInterval, maxInterval)));
                    //then adding ten so we get the next inteval.
                    minInterval = minInterval + 10;
                    maxInterval = maxInterval + 10;
                }
                //after we are done we set the intervals to the start position.
                minInterval = 1;
                maxInterval = 10;
                //add the series to the chart
                ints.getData().add(interval);
            }
            //set text to how many integers there is in the file and how many that are not in our interval 1-100
            totalNumbers.setText("Total number of integers: "+ (notInInterval+integersInInterval.size()));
            notInIntervalText.setText("Integers not in interval 1-100: " + notInInterval);
        });

        //top box with button and text that shows what file we check
        HBox fileBox = new HBox();
        fileBox.setAlignment(Pos.CENTER);
        fileBox.getChildren().addAll(fileName, file, openFileButton);

        //middle box
        //holds all the some text, our HBox and BarChart.
        VBox middle = new VBox();
        middle.setAlignment(Pos.CENTER);
        middle.getChildren().addAll(fileBox, chartBox,notInIntervalText,totalNumbers);

        //root pane
        //holds menu in top and the vbox in the center.
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: lightgreen");
        root.setTop(menuBar);
        root.setCenter(middle);

        //Sets the stage
        Scene scene = new Scene(root, 650, 600);
        primaryStage.setTitle("Exercise 7, histogram GUI");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Method to return how many ints there are in a interval.
     * @param ints list with integers
     * @param min startpoint of interval
     * @param max endpoint of interval
     * @return so many integers that are in list that is in the interval.
     */
    private static int histogram(ArrayList<Integer> ints, int min, int max) {

        int count = 0;
        for (int i = 0; i < ints.size(); i++) {
            if (ints.get(i) >= min && ints.get(i) <= max) {
                count++;
            }
        }
        return count;
    }
}


