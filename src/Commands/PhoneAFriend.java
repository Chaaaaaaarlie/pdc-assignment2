package Commands;

import java.util.Random;

public class PhoneAFriend extends LifeLineAbstract {
    private String friendsAnswer;

    @Override
    public void use() {
        String[] options = {"A", "B", "C", "D"};
        Random generator = new Random();
        int randomIndex = generator.nextInt(options.length);  
        friendsAnswer = options[randomIndex];
    }
    
    /**
     * Getter for variable friendsAnswer
     */
    @Override
    public String getAnswer() {
       return friendsAnswer;
    }
    
    @Override
    public String toString() {
        return "Phone A Friend";
    }
}
