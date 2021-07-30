package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.screens.HomeScreen;
import sample.utility.ConfirmBox;

public class Main extends Application {

    public static Stage window = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        window.setOnCloseRequest(e ->{
            e.consume(); //for consuming the event
            exitWindow();
        });
        window.setTitle("TriviaFx");


        window.setScene(new HomeScreen().startMenu());
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    ConfirmBox confirmBox = new ConfirmBox();
    public void exitWindow(){
        if(confirmBox.display()){
            window.close();
        }

    }
}
