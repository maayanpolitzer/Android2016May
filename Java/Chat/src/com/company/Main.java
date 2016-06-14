package com.company;

import com.company.threads.GetMessagesThread;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

public class Main extends Application {

    private Stage window;   // external screen;
    private final double WIDTH = 500;
    private final double HEIGHT = 500;
    private final String MY_NAME = "Maayan";
    private Button sendBtn;
    private TextField input;
    private TextArea chatView;
    private ArrayList<String> messages;
    private GetMessagesThread getMessagesThread;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        createUI(); // display.
        addActionsToWidgets();  // behaviour
        messages = new ArrayList<>();
        getMessagesThread = new GetMessagesThread(messages.size());
        getMessagesThread.start();

    }

    private void addActionsToWidgets(){
        //sendBtn.setOnAction(e -> sendMessage());
        sendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sendMessage();
                input.requestFocus();
            }
        });

        input.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    sendMessage();
                }
            }
        });
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                // stop threads and stuff...
                getMessagesThread.shutDown();
            }
        });
    }

    private void sendMessage(){
        String message = input.getText().trim();
        if (!message.isEmpty()){
            chatView.appendText(MY_NAME + ": " + message + "\n");
            input.clear();
        }
    }

    private void createUI(){
        VBox mainLayout = new VBox();
        chatView = new TextArea();
        chatView.setPrefSize(WIDTH, HEIGHT - 100);
        chatView.setEditable(false);    //  prevent from typing in...
        HBox userView = new HBox();
        input = new TextField();
        input.setPrefSize(WIDTH - 100, 100);
        sendBtn = new Button("SEND");
        sendBtn.setPrefSize(100, 100);

        userView.getChildren().addAll(input, sendBtn);
        mainLayout.getChildren().addAll(chatView, userView);

        Scene scene = new Scene(mainLayout, WIDTH, HEIGHT);

        window.setScene(scene);
        window.setTitle("צ\'ט כיתת אננס");
        window.show();
        input.requestFocus();
    }

    public static void main(String[] args) {
        launch(null);
    }


}
