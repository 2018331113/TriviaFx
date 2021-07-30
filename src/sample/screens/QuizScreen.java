package sample.screens;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sample.Main;
import sample.QuizBrain;
import sample.QuizModal;
import sample.utility.Clock;
import sample.utility.TimeStampMaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class QuizScreen {
    String playerName;
    int points = 0;
    Label object1;
    Label object2;
    Button choice1;
    Button choice2;
    Button choice3;
    Button choice4;
    Clock clock;
    QuizScreen(String name){
        this.playerName = name;
    }
    List<QuizModal>Quizes = new ArrayList<>();
    void getData() throws FileNotFoundException {
        File file = new File("C:\\Users\\Asus\\IdeaProjects\\TriviaFx\\src\\sample\\files\\input.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){

            String object1;
            String object2;
            String option1;
            String option2;
            String option3;
            String option4;
            object1 = scan.next();
            object2 = scan.next();
            option1 = scan.next();
            option2 = scan.next();
            option3 = scan.next();
            option4 = scan.next();

            Quizes.add(new QuizModal(object1,object2,option1,option2,option3,option4));
            scan.nextLine();


        }
    }
    int idx = 0;
    Label score;
    VBox vBox;
    boolean flag = true;
    VBox timeStamps;

    public void start(){
        try {
            getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clock = new Clock(this);
        Label name = new Label(playerName);
        score = new Label();
        score.setText("Score: 0");

        HBox hBox = new HBox(name,score,clock);
        hBox.setSpacing(200);


        object1 = new Label(Quizes.get(idx).object1);
        Label plus = new Label("+");
        object2 = new Label(Quizes.get(idx).object2);
        HBox row = new HBox(object1,plus,object2);
        row.setSpacing(100);
        row.setAlignment(Pos.CENTER);

        choice1 = new Button(Quizes.get(idx).option1);
        choice2 = new Button(Quizes.get(idx).option2);
        choice3 = new Button(Quizes.get(idx).option3);
        choice4 = new Button(Quizes.get(idx).option4);

        choice1.setOnAction(e -> {
            if(flag){
                scoreSetter(choice1.getText());

            }

        });
        choice2.setOnAction(e -> {
            if(flag){
                scoreSetter(choice2.getText());

            }

        });
        choice3.setOnAction(e -> {
            if(flag){
                scoreSetter(choice3.getText());

            }

        });
        choice4.setOnAction(e -> {
            if(flag){
                scoreSetter(choice4.getText());

            }

        });


        HBox optionRow = new HBox(choice1,choice2,choice3,choice4);
        optionRow.setSpacing(30);
        optionRow.setAlignment(Pos.BASELINE_CENTER);


        vBox = new VBox(hBox,row,optionRow);
        vBox.setSpacing(100);
        timeStamps = new VBox();
        timeStamps.setStyle("-fx-background-color: yellow");
        timeStamps.setMinWidth(150);
        timeStamps.setAlignment(Pos.CENTER_RIGHT);

        HBox background = new HBox(vBox, timeStamps);
        background.setSpacing(20);
        background.setPadding(new Insets(10,10,10,10));

        Button generate = new Button("Generate Report");
        VBox vb = new VBox(background,generate);
        vb.setSpacing(30);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(0,0,20,0));
        Scene scene = new Scene(vb,750,450);
        Main.window.setScene(scene);

    }


    Stack<TimeStampMaker>stack = new Stack<>();
    public void scoreSetter(String answer){
        clock.resetClock();
        QuizBrain brain = new QuizBrain(Quizes.get(idx).object1,Quizes.get(idx).object2);
        TimeStampMaker timeStamp = new TimeStampMaker(idx+1,brain.checker(answer));
        stack.push(timeStamp);
        if(timeStamp.point==1){

            score.setText("Score: " + ++points);
        }
        if(idx== 9){
            flag =false;
            clock.stopClock();
            while(!stack.isEmpty()){
                timeStamps.getChildren().add(new Text(stack.peek().timestamp.toString()+"\nQuestion no: "+stack.peek().questionNo+" points: "+stack.peek().point));
                stack.pop();
            }
        }

        if(idx<9){
            idx++;

            nextQuiz();
        }

    }

    void nextQuiz(){

        this.object1.setText(Quizes.get(idx).object1);
        this.object2.setText(Quizes.get(idx).object2);
        this.choice1.setText(Quizes.get(idx).option1);
        this.choice2.setText(Quizes.get(idx).option2);
        this.choice3.setText(Quizes.get(idx).option3);
        this.choice4.setText(Quizes.get(idx).option4);
    }
}
