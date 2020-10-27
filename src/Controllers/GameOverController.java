package Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOverController {
    private Stage gameOverStage;
    
    @FXML
    private Text prizeText;
    @FXML
    private Text questionNumText;
        
    public void OkButtonAction(ActionEvent event) throws IOException {        
        // Change scenes to MainMenuView
        Parent layout = FXMLLoader.load(getClass().getResource("/FXML/MainMenuView.fxml"));
        Scene mainMenuScene = new Scene(layout);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainMenuScene);
        window.show();
    }
    
    /**
     * Get Stage object of this window
     */
    public void setStage(Stage stage) {
        gameOverStage = stage;
    }
    
    /**
     * Setter for prizeText
     */
    public void setPrizeText(String amount) {
        prizeText.setText("You won: " + amount);
    }
    
    /**
     * Setter for questionNumText
     */
    public void setQuestionNumText(int num) {
        questionNumText.setText("Questions correct: " + num);
    }
}
