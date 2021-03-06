package sample.utility;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


//class for generating a confirmBox to exit or not
public class ConfirmBox {
    private boolean exit = false;

    /**
     * displays the confirm box window
     * @return a boolean
     * if it's true the window closes
     * if false the window remains
     */
    public boolean display(){
        Stage window = new Stage();
        window.setResizable(false);
        window.setTitle("EXIT Eldritch Knight?");
        window.initModality(Modality.APPLICATION_MODAL); //to stop response from any other window

        Label message = new Label("Are you sure you want to exit?");

        Button yes = new Button("YES");
        Button no = new Button("NO");

        yes.setOnAction(e ->{
            exit = true;
            window.close();
        });
        no.setOnAction(e ->{
            exit = false;
            window.close();
        });

        HBox hBox = new HBox(20,yes,no);
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(20,message,hBox);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox,200,100);

        window.setScene(scene);
        window.showAndWait();

        return exit;


    }




}
