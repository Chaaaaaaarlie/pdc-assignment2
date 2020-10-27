package Commands;

import Controllers.GameController;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.fxml.FXMLLoader;

public class Game {
    private List<Question> questions;
    private int questionIndex;
    private Prize prize;
    private FiftyFifty fiftyFifty;
    private LifeLineAbstract phoneAFriend;
    private LifeLineAbstract askTheAudience;
    private User user; 
    private GameController gameController;
    
    public Game(List<Question> questions, User u) {      
        this.questions = questions; 
        questionIndex = 0;
        prize = new Prize();
        fiftyFifty = new FiftyFifty();
        phoneAFriend = new PhoneAFriend();
        askTheAudience = new AskTheAudience();
        user = u;
        setGameController();
    }
    
    /**
     * Check if correct option chosen for question
     */ 
    public int questionAnswered(String answer) {
        int result;
        
        if (answer.equals(questions.get(questionIndex).correctAnswer())) {
            result = 1;
            // Check if correct and last question in list
            if (questionIndex+1 == questions.size()) {
                result = 2;
            } else {
                questionIndex++;
                System.out.println("QuestionIndex: " + questionIndex);
            }           
        } else {
            result = 0;
        }
        System.out.println("Result: " + result);
        return result;
    }
    
    // Getter for variable questions
    public List<Question> getQuestions() {
        return questions;
    }
    
    /**
     * Getter for variable questionIndex
     */
    public int getQuestionIndex() {
        return questionIndex;
    }
    
    /**
     * Setter for GamView controller
     */
    private void setGameController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/GameView.fxml"));
        gameController = loader.getController();
    }
    
    /**
     * Shuffle options order
     */
    public String[] shuffleOptions(String[] options) {
            List<String> optionsList = Arrays.asList(options);
            Collections.shuffle(optionsList);
            return optionsList.toArray(new String[optionsList.size()]);
    }
    
    /**
     * Use lifeline
     */
    private void useLifeLine(LifeLineAbstract lifeLine) {
        lifeLine.use();
    }
}
