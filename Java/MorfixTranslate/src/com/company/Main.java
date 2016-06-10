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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
	    launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField input = new TextField();
        TextArea output = new TextArea();
        Button btn = new Button("TRANSLATE!!!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = input.getText();
                String newText = translate(text);
                output.setText(newText);
            }
        });
        VBox layout = new VBox();
        layout.getChildren().addAll(input, output, btn);
        Scene mainScene = new Scene(layout, 400, 400);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private String translate(String text){
        try {
            String validatedText = text.replace(' ', '+');
            URL url = new URL("http://www.morfix.co.il/" + validatedText);
            InputStreamReader in = new InputStreamReader(url.openStream());
            BufferedReader reader = new BufferedReader(in);
            String line;
            while((line = reader.readLine()) != null){
                if (line.contains("<div class=\"translation translation_he heTrans\">") ||
                      line.contains("<div class=\"default_trans\" style=\"display:block\">")){
                    String start = ">";
                    String end = "</";
                    String translate = line.substring(line.indexOf(start) + 1, line.indexOf(end));
                    return translate;
                }


            }
            return "no translation for: " + text;
        } catch (MalformedURLException e) {
            return "not good developer!!! (url problem)";
        } catch (IOException e) {
            return "No internet...";
        }

    }
}
