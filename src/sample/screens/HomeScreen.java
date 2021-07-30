package sample.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HomeScreen {
    public Scene startMenu(){

        Label label1 = new Label("Name:");
        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);

        Button enter = new Button("Enter");
        enter.setOnAction(e->{
            if(!textField.getText().trim().isEmpty()){
                QuizScreen quizScreen = new QuizScreen(textField.getText());
                quizScreen.start();
            }else{
                textField.setPromptText("Please enter a name");
            }

        });


        VBox vBox = new VBox(hb,enter);
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);



        return new Scene(vBox,300,300);

    }
}
