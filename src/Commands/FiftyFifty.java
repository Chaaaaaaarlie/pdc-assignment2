package Commands;

import java.util.Random;

public class FiftyFifty extends LifeLineAbstract {
    private String[] options;
    private int firstOption;
    private int secondOption;
    
    public FiftyFifty() {
        options = new String[]{"A", "B", "C", "D"};      
    }

    @Override
    public void use() {
        String[] options = {"A", "B", "C", "D"};
        Random generator = new Random();
        firstOption = generator.nextInt(options.length); 
        
        do {
            secondOption = generator.nextInt(options.length);
        } while (firstOption == secondOption);
    }
    
    /**
     * Getter for variable options to remove
     */
    @Override
    public String getAnswer() {
        return options[firstOption] + "-" + options[secondOption];
    }

    @Override
    public String toString() {
        return "Fifty Fifty";
    }
}
