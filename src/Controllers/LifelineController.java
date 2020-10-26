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
    public Text friendHeader;
    @FXML
    public Text friendsAnswer;
    @FXML
    public Text aResult;
    @FXML
    public Text bResult;
    @FXML
    public Text cResult;
    @FXML
    public Text dResult;
    
    /**
     * Display info based on life line selected
     */
    public void setup() {
        lifeLineTitle.setText(lifeline.toString());
        lifeline.use();
        String result = lifeline.getAnswer();
        
        // Display answer based on which lifeline used
        if (lifeline.toString().equals("Phone A Friend")) {
            friendHeader.setVisible(true);
            friendsAnswer.setVisible(true);
            friendsAnswer.setText(result);
        } else {
            String[] splitResult = result.split("-");
            aResult.setText(splitResult[0]);
            bResult.setText(splitResult[1]);
            cResult.setText(splitResult[2]);
            dResult.setText(splitResult[3]);
            
            aResult.setVisible(true);
            bResult.setVisible(true);
            cResult.setVisible(true);
            dResult.setVisible(true);
        }
        
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
