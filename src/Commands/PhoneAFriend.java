package Commands;

import java.util.Random;

public class PhoneAFriend extends LifeLine {

    @Override
    public void use() {
        System.out.println("Your friend thinks the answer is: " + randomAnswer());
        active = false;
    }
    
    /**
     * Check if the lifeline is active
     */
    @Override
    public boolean isActive() {
        return active;
    }
    
    /**
     * Choose random answer
     */
    private String randomAnswer() {
        String[] options = {"A", "B", "C", "D"};
        Random generator = new Random();
        int randomIndex = generator.nextInt(options.length);
       
        return options[randomIndex];
    }
}
