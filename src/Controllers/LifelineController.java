package Controllers;

import Commands.LifeLine;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LifelineController {
    private LifeLine lifeline;
    
    @FXML
    public Text lifeLineTitle;
    @FXML
    public Text friendsAnswer;
    
    public void setup() {
        lifeLineTitle.setText(lifeline.toString());
        lifeline.use();
        friendsAnswer.setText(lifeline.getAnswer());
    }
    
    @FXML
    public void okButtonAction(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
    
    public void setLifeline(LifeLine lifeline) {
        this.lifeline = lifeline;  
    }
}
