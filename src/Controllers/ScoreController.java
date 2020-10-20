package Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScoreController {
       
    @FXML
    public void backButtonAction(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource("/FXML/MainMenuView.fxml"));
        Scene mainMenuScene = new Scene(layout);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainMenuScene);
        window.show(); 
    }
}
