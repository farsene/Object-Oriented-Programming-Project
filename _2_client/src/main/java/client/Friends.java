package client;
import classes.*;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public class Friends {
    static TableView friendsTable = new TableView();
    static TableView pendingTable = new TableView();


    public static void showOptions(GridPane grid, Scene scene, User user){


       //CLEARING THE GRID FROM PREVIOUS ADDITIONS
        grid.getChildren().clear();

       //Creating Labels for addition
        Label  friendsL= new Label("My Friend List");
        Label  friendsP= new Label("Pending friend Requests");
        TextField addaFriend = new TextField();
        Button addaFriendB=new Button("Add A Friend");
        Label FriendsLabel = new Label("FRIENDS");

        //Making of Vboxes and Hboxes in order to show the tables on screen
        HBox Vbox= new HBox(addaFriend,addaFriendB);
        VBox  Vbox1 = new VBox(friendsL,Vbox,friendsTable);
        VBox Vbox2= new VBox(friendsP,pendingTable);
        Vbox1.setStyle("-fx-padding:15;");
        Vbox2.setStyle("-fx-padding:15;");
        Vbox1.setSpacing(20);
        Vbox2.setSpacing(20);

        Vbox1.setAlignment(Pos.CENTER_LEFT);
        Vbox2.setAlignment(Pos.CENTER_RIGHT);
       // GridPane.setConstraints(Vbox1,0,0);
      //  GridPane.setConstraints(Vbox2,7,0);
        //ADDING THE COLLUMNS TO THE TABLES
        TableColumn Col1 = new TableColumn("Username");
        Col1.setCellValueFactory(new PropertyValueFactory<>("username"));
        TableColumn Col2 = new TableColumn("Score");
        Col2.setCellValueFactory(new PropertyValueFactory<>("score"));

        friendsTable.getColumns().setAll(Col1,Col2);


        TableColumn Col3 = new TableColumn("Username");
        Col3.setCellValueFactory(new PropertyValueFactory<>("sender"));
     //   TableColumn Col4 = new TableColumn("Accept/Decline");
      //  Col4.setCellValueFactory(new PropertyValueFactory<>("accept/decline"));

        pendingTable.getColumns().setAll(Col3);
        Col1.setMinWidth(300);
        Col2.setMinWidth(300);
        Col3.setMinWidth(300);
     //   Col4.setMinWidth(300);



        //Lastly creating 2 different
        //Hboxes so we can add everything to the grid

        HBox toplayer = new HBox();
        HBox middleLayer = new HBox();
        toplayer.getChildren().addAll(FriendsLabel);
        middleLayer.getChildren().addAll(Vbox1,Vbox2);
       GridPane.setConstraints(toplayer,5,0);
        GridPane.setConstraints(middleLayer,5,30);
        toplayer.setAlignment(Pos.TOP_CENTER);
        middleLayer.setAlignment(Pos.CENTER);
        grid.getChildren().addAll(toplayer,middleLayer);

        grid.setMinWidth(1500);
        grid.setStyle("-fx-font-size: 18pt; -fx-padding: 10px;");


        addaFriendB.setOnAction(e ->{
            classes.FriendRequest friendRequest= new classes.FriendRequest(user.getUsername(),addaFriend.getText());
            addaFriend.clear();
        });


    //ON CLICKING ON A ROW YOU CHOOSE WHAT TOU WANT TO DO WITH THE FRIEND REQUEST
        pendingTable.setRowFactory(tv -> {
            TableRow<FriendRequest> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    FriendRequest clickedRow = row.getItem();
                    boolean answer = AddFriendBox.display("Add A friend",clickedRow);
                    if (answer== false){
                        pendingTable.getItems().remove(clickedRow);
                    }
                    else{
                        //SOMETHING ELSE
                    }
                }
            });
            return row ;

        });







    }

    public static ObservableList<User> addFriend(User user){
        ObservableList<User> Friend= FXCollections.observableArrayList();
        List<User> FriendList = new RestfulClient().getAllFriends(user.getUsername());
        for(User a : FriendList){
             Friend.add(a);
        }
    return  Friend;
    }




    public static ObservableList<FriendRequest> addFriendRequests(User user){
        ObservableList<FriendRequest> friendRequests= FXCollections.observableArrayList();
       List<FriendRequest> friendRequestList = new  RestfulClient().getAllFriendRequests(user.getUsername());
        for(FriendRequest a : friendRequestList){
             friendRequests.add(a);
        }
    return  friendRequests;
    }







}
