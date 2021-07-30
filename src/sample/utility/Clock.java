package sample.utility;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.screens.QuizScreen;

public class Clock extends Pane {

    private int tmp = 6;
    QuizScreen screen;
    Label label = new Label("Countdown: 0");
    Timeline animation;

    public Clock(QuizScreen screen) {

        this.screen = screen;
        getChildren().add(label);
        animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> timeLabel()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public void timeLabel() {
        if(tmp<1){
            screen.scoreSetter("");
        }
        tmp--;
        String s = tmp + "";
        label.setText("Countdown: "+s);
    }

    public void resetClock(){
        tmp = 6;
    }

    public  void stopClock(){
        animation.stop();
    }
}