package Controllers;

import Commands.Game;
import Commands.Main;
import Commands.Question;
import Commands.User;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.text.Text;
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
    private Text question;
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
    }
    
    @FXML
    public void confirmAnswerButton(ActionEvent event) throws IOException {
        switch (game.questionAnswered("Test Answer")) {
          case 0:   // Incorrect
              System.out.println("Wrong");
            break;
          case 1:   // Correct
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
}
