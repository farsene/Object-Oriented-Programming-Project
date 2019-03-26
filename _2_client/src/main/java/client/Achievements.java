package client;

import classes.Activity;
import classes.Controller;
import classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import classes.Activity;
import classes.Controller;
import classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.List;

public class Achievements {

    public static void showBadges(GridPane grid, Scene scene, User user) {

        int polarUnlock = 10;

        Label myAchievements = new Label("My Achievements!");
        myAchievements.setFont(Font.font("Amble CN", FontWeight.BOLD, 35));
        VBox achievements = new VBox(myAchievements);
        achievements.setStyle("-fx-padding: 5;");
        achievements.setSpacing(10);
        achievements.setAlignment(Pos.CENTER);
        GridPane.setConstraints(achievements, 0, 0);

        /**
         * Polar score badges
         */
        HBox polarHbox = new HBox();
        polarHbox.setSpacing(1);
        polarHbox.setStyle("-fx-padding: 1;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 5;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: #6dfff3;");

        Button polarBadge_1 = new Button();
        Button polarBadge_2 = new Button();
        Button polarBadge_3 = new Button();
        Button polarBadge_4 = new Button();
        Button polarBadge_5 = new Button();
        Button polarBadge_6 = new Button();
        Button polarBadge_7 = new Button();
        Button polarBadge_8 = new Button();
        Button polarBadge_9 = new Button();
        Button polarBadge_10 = new Button();

        CSSbadge2.setPolar1(polarBadge_1, polarUnlock);
        CSSbadge2.setPolar2(polarBadge_2, polarUnlock);
        CSSbadge2.setPolar3(polarBadge_3, polarUnlock);
        CSSbadge2.setPolar4(polarBadge_4, polarUnlock);
        CSSbadge2.setPolar5(polarBadge_5, polarUnlock);
        CSSbadge2.setPolar6(polarBadge_6, polarUnlock);
        CSSbadge2.setPolar7(polarBadge_7, polarUnlock);
        CSSbadge2.setPolar8(polarBadge_8, polarUnlock);
        CSSbadge2.setPolar9(polarBadge_9, polarUnlock);
        CSSbadge2.setPolar10(polarBadge_10, polarUnlock);

        Label polarLabel = new Label("POLAR");
        polarLabel.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        HBox polarAchievements = new HBox(polarLabel);
        polarAchievements.setStyle("-fx-padding: 5;");
        polarAchievements.setSpacing(10);
        polarAchievements.setAlignment(Pos.CENTER_LEFT);
        VBox polar_1 = new VBox(polarBadge_1);
        VBox polar_2 = new VBox(polarBadge_2);
        VBox polar_3 = new VBox(polarBadge_3);
        VBox polar_4 = new VBox(polarBadge_4);
        VBox polar_5 = new VBox(polarBadge_5);
        VBox polar_6 = new VBox(polarBadge_6);
        VBox polar_7 = new VBox(polarBadge_7);
        VBox polar_8 = new VBox(polarBadge_8);
        VBox polar_9 = new VBox(polarBadge_9);
        VBox polar_10 = new VBox(polarBadge_10);
        polarHbox.getChildren().addAll(polarAchievements, polar_1, polar_2, polar_3, polar_4, polar_5, polar_6, polar_7, polar_8, polar_9, polar_10);
        GridPane.setConstraints(polarHbox, 0, 2);

        /**
         * Food score badges
         */
        HBox foodHbox = new HBox();
        foodHbox.setSpacing(1);
        foodHbox.setStyle("-fx-padding: 1;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 5;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: #44ff8e;");

        Button foodBadge_1 = new Button();
        Button foodBadge_2 = new Button();
        Button foodBadge_3 = new Button();
        Button foodBadge_4 = new Button();
        Button foodBadge_5 = new Button();
        Button foodBadge_6 = new Button();
        Button foodBadge_7 = new Button();
        Button foodBadge_8 = new Button();
        Button foodBadge_9 = new Button();
        Button foodBadge_10 = new Button();

        CSSbadge2.setPolar1(foodBadge_1, polarUnlock);
        CSSbadge2.setPolar2(foodBadge_2, polarUnlock);
        CSSbadge2.setPolar3(foodBadge_3, polarUnlock);
        CSSbadge2.setPolar4(foodBadge_4, polarUnlock);
        CSSbadge2.setPolar5(foodBadge_5, polarUnlock);
        CSSbadge2.setPolar6(foodBadge_6, polarUnlock);
        CSSbadge2.setPolar7(foodBadge_7, polarUnlock);
        CSSbadge2.setPolar8(foodBadge_8, polarUnlock);
        CSSbadge2.setPolar9(foodBadge_9, polarUnlock);
        CSSbadge2.setPolar10(foodBadge_10, polarUnlock);

        Label foodLabel = new Label("FOOD");
        foodLabel.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        HBox foodAchievements = new HBox(foodLabel);
        foodAchievements.setStyle("-fx-padding: 5;");
        foodAchievements.setSpacing(10);
        foodAchievements.setAlignment(Pos.CENTER_LEFT);

        VBox food_1 = new VBox(foodBadge_1);
        VBox food_2 = new VBox(foodBadge_2);
        VBox food_3 = new VBox(foodBadge_3);
        VBox food_4 = new VBox(foodBadge_4);
        VBox food_5 = new VBox(foodBadge_5);
        VBox food_6 = new VBox(foodBadge_6);
        VBox food_7 = new VBox(foodBadge_7);
        VBox food_8 = new VBox(foodBadge_8);
        VBox food_9 = new VBox(foodBadge_9);
        VBox food_10 = new VBox(foodBadge_10);
        foodHbox.getChildren().addAll(foodAchievements, food_1, food_2, food_3, food_4, food_5, food_6, food_7, food_8, food_9, food_10);
        GridPane.setConstraints(foodHbox, 0, 4);

        /**
         * transport score badges
         */
        HBox transportHbox = new HBox();
        transportHbox.setSpacing(1);
        transportHbox.setStyle("-fx-padding: 1;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 5;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: #ff362c;");

        Button transportBadge_1 = new Button();
        Button transportBadge_2 = new Button();
        Button transportBadge_3 = new Button();
        Button transportBadge_4 = new Button();
        Button transportBadge_5 = new Button();
        Button transportBadge_6 = new Button();
        Button transportBadge_7 = new Button();
        Button transportBadge_8 = new Button();
        Button transportBadge_9 = new Button();
        Button transportBadge_10 = new Button();

        CSSbadge2.setPolar1(transportBadge_1, polarUnlock);
        CSSbadge2.setPolar2(transportBadge_2, polarUnlock);
        CSSbadge2.setPolar3(transportBadge_3, polarUnlock);
        CSSbadge2.setPolar4(transportBadge_4, polarUnlock);
        CSSbadge2.setPolar5(transportBadge_5, polarUnlock);
        CSSbadge2.setPolar6(transportBadge_6, polarUnlock);
        CSSbadge2.setPolar7(transportBadge_7, polarUnlock);
        CSSbadge2.setPolar8(transportBadge_8, polarUnlock);
        CSSbadge2.setPolar9(transportBadge_9, polarUnlock);
        CSSbadge2.setPolar10(transportBadge_10, polarUnlock);

        Label transportLabel = new Label("TRANSPORT");
        transportLabel.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        HBox transportAchievements = new HBox(transportLabel);
        transportAchievements.setStyle("-fx-padding: 5;");
        transportAchievements.setSpacing(10);
        transportAchievements.setAlignment(Pos.CENTER_LEFT);

        VBox transport_1 = new VBox(transportBadge_1);
        VBox transport_2 = new VBox(transportBadge_2);
        VBox transport_3 = new VBox(transportBadge_3);
        VBox transport_4 = new VBox(transportBadge_4);
        VBox transport_5 = new VBox(transportBadge_5);
        VBox transport_6 = new VBox(transportBadge_6);
        VBox transport_7 = new VBox(transportBadge_7);
        VBox transport_8 = new VBox(transportBadge_8);
        VBox transport_9 = new VBox(transportBadge_9);
        VBox transport_10 = new VBox(transportBadge_10);
        transportHbox.getChildren().addAll(transportAchievements, transport_1, transport_2, transport_3, transport_4, transport_5, transport_6, transport_7, transport_8, transport_9, transport_10);
        GridPane.setConstraints(transportHbox, 0, 8);



/**
 * electricity score badges
 */
        HBox electricityHbox = new HBox();
        electricityHbox.setSpacing(1);
        electricityHbox.setStyle("-fx-padding: 1;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 5;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: #f7ff28;");

        Button electricityBadge_1 = new Button();
        Button electricityBadge_2 = new Button();
        Button electricityBadge_3 = new Button();
        Button electricityBadge_4 = new Button();
        Button electricityBadge_5 = new Button();
        Button electricityBadge_6 = new Button();
        Button electricityBadge_7 = new Button();
        Button electricityBadge_8 = new Button();
        Button electricityBadge_9 = new Button();
        Button electricityBadge_10 = new Button();

        CSSbadge2.setPolar1(electricityBadge_1, polarUnlock);
        CSSbadge2.setPolar2(electricityBadge_2, polarUnlock);
        CSSbadge2.setPolar3(electricityBadge_3, polarUnlock);
        CSSbadge2.setPolar4(electricityBadge_4, polarUnlock);
        CSSbadge2.setPolar5(electricityBadge_5, polarUnlock);
        CSSbadge2.setPolar6(electricityBadge_6, polarUnlock);
        CSSbadge2.setPolar7(electricityBadge_7, polarUnlock);
        CSSbadge2.setPolar8(electricityBadge_8, polarUnlock);
        CSSbadge2.setPolar9(electricityBadge_9, polarUnlock);
        CSSbadge2.setPolar10(electricityBadge_10, polarUnlock);

        Label electricityLabel = new Label("ELECTRICITY");
        electricityLabel.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        HBox electricityAchievements = new HBox(electricityLabel);
        electricityAchievements.setStyle("-fx-padding: 5;");
        electricityAchievements.setSpacing(10);
        electricityAchievements.setAlignment(Pos.CENTER_LEFT);

        VBox electricity_1 = new VBox(electricityBadge_1);
        VBox electricity_2 = new VBox(electricityBadge_2);
        VBox electricity_3 = new VBox(electricityBadge_3);
        VBox electricity_4 = new VBox(electricityBadge_4);
        VBox electricity_5 = new VBox(electricityBadge_5);
        VBox electricity_6 = new VBox(electricityBadge_6);
        VBox electricity_7 = new VBox(electricityBadge_7);
        VBox electricity_8 = new VBox(electricityBadge_8);
        VBox electricity_9 = new VBox(electricityBadge_9);
        VBox electricity_10 = new VBox(electricityBadge_10);
        electricityHbox.getChildren().addAll(electricityAchievements, electricity_1, electricity_2, electricity_3, electricity_4, electricity_5, electricity_6, electricity_7, electricity_8, electricity_9, electricity_10);
        GridPane.setConstraints(electricityHbox, 0, 10);

        grid.getChildren().addAll(achievements, polarHbox, foodHbox, transportHbox, electricityHbox);

        grid.setMinWidth(1500);
        grid.setStyle("-fx-font-size: 18pt; -fx-padding: 10px;");

    }
}


