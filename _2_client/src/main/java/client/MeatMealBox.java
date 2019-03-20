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

        dropdownGrams.getItems().addAll(100, 200, 300, 400, 500);
        dropdownGrams.getSelectionModel().select(0);

        Button gramsButton= new Button("Submit grams");
        gramsButton.setOnAction(e -> {
            int gramsAdded = dropdownGrams.getValue();

            if (gramsAdded == 100) {
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String date = myDateObj.format(myFormatObj);
                new Controller().sendMeal(user, 100);
                // add a meal in the database
                Activity activity = new Activity(user.getUsername(), 1, "Meat (" + gramsAdded + " grams)",
                        100, date);
                List<Activity> list = new Controller().sendFood(activity);
                window.close();
            }
            if (gramsAdded == 200) {
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String date = myDateObj.format(myFormatObj);
                new Controller().sendMeal(user, 200);
                // add a meal in the database
                Activity activity = new Activity(user.getUsername(), 1, "Meat (" + gramsAdded + " grams)",
                        200, date);
                List<Activity> list = new Controller().sendFood(activity);
                window.close();
            }
            if (gramsAdded == 300) {
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String date = myDateObj.format(myFormatObj);
                new Controller().sendMeal(user, 300);
                // add a meal in the database
                Activity activity = new Activity(user.getUsername(), 1, "Meat (" + gramsAdded +  " grams)",
                        300, date);
                List<Activity> list = new Controller().sendFood(activity);
                window.close();
            }

            if (gramsAdded == 100) {
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String date = myDateObj.format(myFormatObj);
                new Controller().sendMeal(user, 300);
                // add a meal in the database
                Activity activity = new Activity(user.getUsername(), 1, "Meat (" + gramsAdded +  " grams)",
                        300, date);
                List<Activity> list = new Controller().sendFood(activity);
                window.close();
            }
            if (gramsAdded == 400) {
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String date = myDateObj.format(myFormatObj);
                new Controller().sendMeal(user, 400);
                // add a meal in the database
                Activity activity = new Activity(user.getUsername(), 1, "Meat (" + gramsAdded +  " grams)",
                        400, date);
                List<Activity> list = new Controller().sendFood(activity);
                window.close();
            }
            if (gramsAdded == 500) {
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String date = myDateObj.format(myFormatObj);
                new Controller().sendMeal(user, 500);
                // add a meal in the database
                Activity activity = new Activity(user.getUsername(), 1, "Meat (" + gramsAdded +  " grams)",
                        500, date);
                List<Activity> list = new Controller().sendFood(activity);
                window.close();
            }
        });



        VBox layout = new VBox(10);

        label.setStyle("-fx-font-size: 12pt; -fx-padding: 10;");
        dropdownGrams.setStyle("-fx-padding: 7;");
        gramsButton.setStyle("-fx-padding: 7;");

        layout.getChildren().addAll(label, gramsButton, dropdownGrams);
        layout.setStyle(" -fx-padding: 10px;");
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();
    }
}


