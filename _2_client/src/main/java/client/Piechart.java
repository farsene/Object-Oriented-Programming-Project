package client;

import classes.User;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


public class Piechart {
    /**
     * Declare Vbox.
     */
    static VBox pieChartBox;
    static int foodTotal, transportTotal, electricityTotal;
    static double foodPercent, transportPercent, electricityPercent;

    public static void showPieChart(final User user) {

        Label label = new Label("Track your progress!");

        PieChart.Data data[] = new PieChart.Data[3];

        // string and integer data
        String status[] = {"Food", "Transport",  "Electricity"};

        pieChartBox = new VBox();

        foodTotal = user.getFoodScore();
        System.out.println("foodTotal: " + foodTotal);


        transportTotal = user.getTransportScore();
        System.out.println("transportTotal: " +transportTotal);

        electricityTotal = user.getElectricityScore();
        System.out.println("electricityTotal: " + electricityTotal);
        if(foodTotal == 0 && transportTotal == 0 && electricityTotal == 0){

            transportTotal = 34;
            foodTotal = 33;
            electricityTotal = 33;
            System.out.println("Updated");
            System.out.println("foodTotal: " + foodTotal);
            System.out.println("transportTotal: " +transportTotal);
            System.out.println("electricityTotal: " + electricityTotal);
        }

        int sum = foodTotal + transportTotal + electricityTotal;
        System.out.println("sum: " + sum);

        foodPercent =((double) foodTotal / sum) * 100;
        transportPercent = ((double) transportTotal / sum) * 100;
        electricityPercent =((double)  electricityTotal / sum) * 100;
        System.out.println("foodPercent: " +foodPercent);
        System.out.println("transportPercent: " +transportPercent);
        System.out.println("electricityPercent: " +electricityPercent);

        double values[] = {foodPercent, transportPercent, electricityPercent};

        for (int i = 0; i < 3; i++) {
            data[i] = new PieChart.Data(status[i], values[i]);
        }

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Food", foodPercent),
                        new PieChart.Data("Transport", transportPercent),
                        new PieChart.Data("Electricity", electricityPercent));
        final PieChart chart = new PieChart(pieChartData);

        chart.setTitle("Track your progress!");

        PieChart pie_chart = new PieChart(FXCollections.observableArrayList(data));

        //Group group = new Group(pie_chart);

        pieChartBox.getChildren().addAll(label, pie_chart);
    }


    /**
     * getter for for PicChartVbox.
     */
    public static VBox getPieChartBox() {
        return pieChartBox;
    }
}
