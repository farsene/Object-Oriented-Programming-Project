package client;

import classes.FriendRequest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * add friend box class.
 */
public class BoxAddFriend {

    /**
     * Variable answer.
     */
    static int answer;

    /**
     * Dsiplay box method.
     *
     * @param title         title parameter.
     * @param friendRequest friendRequest parameter.
     * @return answer.
     */
    public static int display(final String title, final FriendRequest friendRequest) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        final Label label = new Label(friendRequest.getSender() + " wants to add you");
        Button yesButton = new Button("Accept");
        Button noButton = new Button("Decline");
        window.setOnCloseRequest(e -> {
            answer = 3;
        });


        yesButton.setOnAction(e -> {
            answer = 1;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = 2;
            window.close();
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }

}
