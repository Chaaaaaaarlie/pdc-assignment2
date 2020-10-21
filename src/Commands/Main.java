package Commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Charlie
 */
public class Main extends Application {
    private final String questionsFile;
    // private HashMap<String, User> users;
    
    public Main() {
        questionsFile = "questions.txt"; 
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/StartView.fxml"));
        stage.setTitle("Who Wants To Be A Millionaire!");
        Scene scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList();
        
        FileInputStream fIn;
        try {
            fIn = new FileInputStream(questionsFile);
            Scanner fileScanner = new Scanner (fIn);
            
            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] result = line.split("-");
                
                // Save into readable variables
                String question = result[0];
                String correct = result[1];
                String[] options = new String[4];
                for (int i = 0; i < 4; i++) {
                    options[i] = result[i+1];
                }
                
                Question q = new Question(question, correct, options);
                questions.add(q);
            }
                fIn.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return questions;
    }
}
