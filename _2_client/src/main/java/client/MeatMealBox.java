package client;

import classes.Activity;
import classes.Controller;
import classes.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import java.util.LinkedList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MeatMealBox {

    static public void meatMealCalculator(String title, String message, User user){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(500);
        Label label = new Label();
        label.setText(message);

        ChoiceBox<Integer> dropdownGrams= new ChoiceBox<>();

        dropdownGrams.getItems().addAll(50, 100, 150, 200, 250, 300, 350, 400, 450, 500);
        dropdownGrams.getSelectionModel().select(0);

//       LocalDateTime myDateObj = LocalDateTime.now();
//       DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//       String date = myDateObj.format(myFormatObj);
//       new Controller().sendMeal(user, 100);
//       // add a meal in the database
//       Activity activity = new Activity(user.getUsername(), 1, "Meat",
//               100, date);
//       List<Activity> list = new Controller().sendFood(activity);
//       window.close();


        VBox layout = new VBox(10);

        label.setStyle("-fx-font-size: 12pt; -fx-padding: 10;");
        dropdownGrams.setStyle("-fx-padding: 7;");

        layout.getChildren().addAll(label, dropdownGrams);
        layout.setStyle(" -fx-padding: 10px;");
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();
    }
}


