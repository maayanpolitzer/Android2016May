package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Word[] words;
    private int counter = 0;

    public static void main(String[] args) {

	    launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initArray();
        VBox layout = new VBox();
        TextField input = new TextField();
        TextArea output = new TextArea();

        Button btn = new Button("Start");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                input.setText(words[counter].getHebrew());
                output.setText(words[counter].getEnglish());
                counter++;
                if (counter == words.length){
                    counter = 0;
                }
            }
        });
        layout.getChildren().addAll(input, output, btn);
        Scene mainScene = new Scene(layout, 1000, 500);
        primaryStage.setScene(mainScene);


        primaryStage.show();    // will be the last line in start() method.

    }

    public void initArray(){
        words = new Word[]{
                new Word("כלב", "dog"),
                new Word("חתול", "cat"),
                new Word("יום", "day")

        };
    }

}
