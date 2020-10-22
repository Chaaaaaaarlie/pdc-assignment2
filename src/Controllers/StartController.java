package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Charlie
 */
public class StartController {
    @FXML
    public Text errorMessage;
    @FXML
    public TextField nameField;
    
    @FXML
    public void enterButtonAction(ActionEvent event) throws IOException {
        if (validName()) {
            Parent layout = FXMLLoader.load(getClass().getResource("/FXML/MainMenuView.fxml"));
            Scene mainMenuScene = new Scene(layout);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(mainMenuScene);
            window.show(); 
        }    
    }  
    
    /**
     * PUT THIS METHOD IN OWN CLASS
     * @return 
     */
    private boolean validName() {
        boolean valid = false;
        String name = nameField.getText();
        
        if (name.equals("")) {
            errorMessage.setText("Name cannot be empty");
            errorMessage.setVisible(true);
        } else {
            valid = true;
        }
                
        return valid;
    }
}
