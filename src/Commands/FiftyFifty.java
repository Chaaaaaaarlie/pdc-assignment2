package Commands;

import java.util.Random;

public class FiftyFifty extends LifeLine {
    private boolean shown = false;
    private Question q;
    private String letter;
    private String[] options;
    private String[] chosenOptions;
    
    public FiftyFifty() {
        chosenOptions = new String[2];
    }

    @Override
    public void use() {
        String randLetter = randomOption();
        String randOption = "";
        int index = 0;
        
        if (randLetter.equals("A")) {
            randOption = options[0];
        } else if (randLetter.equals("B")) {
            randOption = options[1];
        } else if (randLetter.equals("C")) {
            randOption = options[2];
        } else {
            randOption = options[3];
        }        
        
        for (int i = 0; i < 4; i++) {
            if (options[i].equals(q.correctAnswer())) {
               chosenOptions[index] = letter + ". " + q.correctAnswer();
               index++;
            } else if (options[i].equals(randOption)) {
               chosenOptions[index] = randLetter + ". " + randOption;
               index++;
            }
        }
        
        active = false;
    }

    @Override
    public boolean isActive() {
        return active;
    }
    
    /**
     * Get question info
     */
    public void getQuestion(Question q, String[] options, String letter) {
        this.q = q;
        this.letter = letter;
        this.options = options;
    }
    
    /**
     * Select random option
     */
    private String randomOption() {
        String[] options = {"A", "B", "C", "D"};
        
        Random generator = new Random();
        int randomIndex = generator.nextInt(options.length);
       
        return options[randomIndex];
    }
    
    /**
     * Return shown variable
     */
    public boolean isShown() {
        return shown;
    }
    
    /**
     * Set shown variable
     */
    public void shown() {
        shown = true;
    }
    
    /**
     * Return answer and random option in correct order
     */
    public String[] getFiftyFifty() {
        return chosenOptions;
    }
}
