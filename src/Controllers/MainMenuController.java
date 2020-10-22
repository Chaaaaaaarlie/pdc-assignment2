package Controllers;

import Commands.Game;
import Commands.Main;
import Commands.Question;
import Commands.User;
import java.io.IOException;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {
    @FXML
    public Button exitButton;
    
    @FXML
    public void playButtonAction(ActionEvent event) throws IOException {    
        // Change scenes to GameView
        Parent layout = FXMLLoader.load(getClass().getResource("/FXML/GameView.fxml"));
        Scene mainMenuScene = new Scene(layout);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainMenuScene);
        window.show();
    }
    
    @FXML
    public void scoreButtonAction(ActionEvent event) throws IOException {
        // Change scenes to ScoreView
        Parent layout = FXMLLoader.load(getClass().getResource("/FXML/ScoreView.fxml"));
        Scene mainMenuScene = new Scene(layout);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainMenuScene);
        window.show(); 
    }
    
    @FXML
    public void exitButtonAction(ActionEvent event) {
        Platform.exit();
    }
}
