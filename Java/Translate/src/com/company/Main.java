package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements DelayListener {

    private Word[] words;
    private int counter = 0;
    private TextField input;
    private TextArea output;
    private MyThread m = new MyThread(this);

    public static void main(String[] args) {



	    launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //MyThread m = new MyThread(this);  // move to class field...
        initArray();
        VBox layout = new VBox();
        input = new TextField();
        output = new TextArea();
        Button btn = new Button("Start");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (m.isRunning()){ // THREAD IS RUNNING???
                    // stop....
                    m.shutDown();
                    btn.setText("START");
                }else{
                    // start...
                    startRunning();
                    m.start();  // can't call run() method more than once.
                    btn.setText("STOP");
                }
            }
        });
        layout.getChildren().addAll(input, output, btn);
        Scene mainScene = new Scene(layout, 1000, 500);
        primaryStage.setScene(mainScene);


        primaryStage.show();    // will be the last line in start() method.

    }

    public void startRunning(){
        m = new MyThread(this);
    }



    public void initArray(){
        words = new Word[]{
                new Word("כלב", "dog"),
                new Word("חתול", "cat"),
                new Word("יום", "day")

        };
    }

    @Override
    public void changeText() {
        // if a call a method from another thread
        // and it should change the UI, IT WON'T WORK!!!
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                input.setText(words[counter].getHebrew());
                output.setText(words[counter].getEnglish());
                counter++;
                if (counter == words.length){
                    counter = 0;
                }
            }
        });

    }
}
