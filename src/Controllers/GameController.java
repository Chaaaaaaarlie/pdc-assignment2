package Controllers;

import Commands.AskTheAudience;
import Commands.FiftyFifty;
import Commands.Game;
import Commands.LifeLine;
import Commands.Main;
import Commands.PhoneAFriend;
import Commands.Question;
import Commands.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameController implements Initializable {
    private Game game;
    
    @FXML 
    private ListView prizeList;
    @FXML
    private Button fiftyFifty;
    @FXML
    private Button phoneAFriend;
    @FXML
    private Button askTheAudience;
    @FXML
    private Button confirmAnswerButton;
    @FXML
    private Text question;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton optionA;
    @FXML
    private RadioButton optionB;
    @FXML
    private RadioButton optionC;
    @FXML
    private RadioButton optionD;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up game by retrieving questions and users then start the game
        Main menu = new Main();
        game = new Game(menu.getQuestions(), new User("Test Name", "Test Score"));
        displayQuestion(); 
        
        // Add listener to ToggleGroup
        group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            if (group.getSelectedToggle() != null) {
                confirmAnswerButton.setDisable(false);
            }
        });
    }
    
    @FXML
    public void fiftyFiftyButtonAction(ActionEvent event) throws IOException {
        fiftyFifty.setDisable(true);
        LifeLine fiftyFifty = new FiftyFifty();
        fiftyFifty.use();
        enableFiftyFifty(fiftyFifty.getAnswer());    
    }
    
    @FXML
    public void phoneAFriendButtonAction(ActionEvent event) throws IOException {
        phoneAFriend.setDisable(true);
        lifelineSetup(new PhoneAFriend());
        
    }
    
    @FXML
    public void askTheAudienceButtonAction(ActionEvent event) throws IOException {
        askTheAudience.setDisable(true);
        lifelineSetup(new AskTheAudience());
    }
    
    @FXML
    public void confirmAnswerButton(ActionEvent event) throws IOException {
        switch (game.questionAnswered(((RadioButton)group.getSelectedToggle()).getText())) {
          case 0:   // Incorrect
              gameOverSetup(event);
            break;
          case 1:   // Correct
            RadioButton selectedRadioButton = (RadioButton)group.getSelectedToggle();
            selectedRadioButton.setSelected(false);
            confirmAnswerButton.setDisable(true);
            displayQuestion();
            break;
          case 2:   // Correct and last question
              System.out.println("Correct and last question");
            break;
        }
    } 
    
    @FXML
    public void quitButtonAction(ActionEvent event) throws IOException {
        // Change scenes to MainMenuView
        Parent layout = FXMLLoader.load(getClass().getResource("/FXML/MainMenuView.fxml"));
        Scene mainMenuScene = new Scene(layout);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainMenuScene);
        window.show();        
    }   
    
    /**
     * Set up first question
     */
    private void displayQuestion() {
        Question q = game.getQuestions().get(game.getQuestionIndex());
        question.setText(q.getQuestion());
        String[] options = game.shuffleOptions(q.getOptions());
        optionA.setText(options[0]);
        optionB.setText(options[1]);
        optionC.setText(options[2]);
        optionD.setText(options[3]);
    }
    
    /**
     * Set up lifeline view
     */
    private void lifelineSetup(LifeLine lifeline) throws IOException {
        // Get reference to LifelineController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LifelineView.fxml"));    
        Parent layout  = loader.load();
        LifelineController lifelineController = loader.getController();
        lifelineController.setLifeline(lifeline);
        lifelineController.setup();
        
        // Change scene to LifelineView in a new window
        Scene lifelineScene = new Scene(layout);
        Stage popUpWindow = new Stage();
        popUpWindow.initModality(Modality.APPLICATION_MODAL);  // Must click pop up first
        popUpWindow.setScene(lifelineScene);
        popUpWindow.showAndWait(); 
    }
    
    /**
     * Active Fifty Fifty lifeline by disabling two random options
     */
    private void enableFiftyFifty(String s) {
        String[] optionsToRemove = s.split("-");
        
        if (optionsToRemove[0].equals("A") || optionsToRemove[1].equals("A")) {
            // Disable A
            optionA.setVisible(false);
        }      
        if (optionsToRemove[0].equals("B") || optionsToRemove[1].equals("B")) {
            // Disable B
            optionB.setVisible(false);
        }       
        if (optionsToRemove[0].equals("C") || optionsToRemove[1].equals("C")) {
            // Disbale C
            optionC.setVisible(false);
        }
        if (optionsToRemove[0].equals("D") || optionsToRemove[1].equals("D")) {
            // Disable D
            optionD.setVisible(false);
        }
    }
    
    /**
     * Set up game over view
     */
    private void gameOverSetup(ActionEvent event) throws IOException {
        // Get reference to GameOverController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/GameOverView.fxml"));    
        Parent layout  = loader.load();
        GameOverController gameOverController = loader.getController();
        gameOverController.setPrizeText("$100");
        gameOverController.setQuestionNumText(game.getQuestionIndex());
        
        // Change scene to GameOverView
        Scene gameOverScene = new Scene(layout);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(gameOverScene);
        window.show();    
    }
}
