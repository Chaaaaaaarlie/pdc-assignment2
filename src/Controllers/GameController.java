package Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController {
    @FXML 
    private ListView prizeList;
    @FXML
    private Button fiftyFifty;
    @FXML
    private Button phoneAFriend;
    @FXML
    private Button askTheAudience;
    @FXML
    private Text question;
    @FXML
    private RadioButton optionA;
    @FXML
    private RadioButton optionB;
    @FXML
    private RadioButton optionC;
    @FXML
    private RadioButton optionD;
    
    @FXML
    public void quitButtonAction(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource("/FXML/MainMenuView.fxml"));
            Scene mainMenuScene = new Scene(layout);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(mainMenuScene);
            window.show(); 
    }    
}
