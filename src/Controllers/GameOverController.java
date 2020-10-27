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
    private Text gameOverText;
    @FXML
    private Text prizeText;
    @FXML
    private Text questionNumText;
    @FXML
    private Text congratzText;
    @FXML
    private Text aMillText;
        
    public void OkButtonAction(ActionEvent event) throws IOException {        
        // Change scenes to MainMenuView
        Parent layout = FXMLLoader.load(getClass().getResource("/FXML/MainMenuView.fxml"));
        Scene mainMenuScene = new Scene(layout);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainMenuScene);
        window.show();
    }
    
    /**
     * Set up game over view
     */
    public void setup(boolean win) {
        if (win) {
            congratzText.setVisible(true);
            aMillText.setVisible(true);
        } else {
            gameOverText.setVisible(true);
            prizeText.setVisible(true);
            questionNumText.setVisible(true);
        }
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
