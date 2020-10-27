package Commands;

import java.util.Random;

public class FiftyFifty extends LifeLineAbstract {
    private String[] options;
    private String randLetter;
    private String answerLetter;
    
    public FiftyFifty() {
        options = new String[]{"A", "B", "C", "D"};      
    }

    @Override
    public void use() {
        Random generator = new Random();
        int randLetterInt;
        do {
            randLetterInt = generator.nextInt(options.length);
            randLetter = options[randLetterInt];
        } while (randLetter.equals(answerLetter));
    }
    
    /**
     * Getter for variable options to remove
     */
    @Override
    public String getAnswer() {
        return randLetter;
    }

    @Override
    public String toString() {
        return "Fifty Fifty";
    }
    
    /**
     * Setter for answerLetter
     */
    public void setAnswer(String letter) {
        answerLetter = letter;
    }
}
