package Commands;

import java.util.concurrent.ThreadLocalRandom;

public class AskTheAudience extends LifeLineAbstract {
    private String audienceAnswer;
    
    @Override
    public void use() {
        int[] votes = audienceVotes();
        audienceAnswer = "A " + votes[0] + "%-" +
                         "B " + votes[1] + "%-" +
                         "C " + votes[2] + "%-" +
                         "D " + votes[3] + "%-";
    }
    
    /**
     * Getter for variable audienceAnswer
     */
    @Override
    public String getAnswer() {
        return audienceAnswer;
    }
    
    /**
     * Generate random integer 100 times
     */
    private int[] audienceVotes() {
        int rand;
        int[] votes = new int[4];
        
        for (int i = 0; i < 100; i++) {
            rand = ThreadLocalRandom.current().nextInt(1, 5);   // max is exclusive
            switch (rand) {
                case 1:
                    votes[0]++;
                    break;
                case 2:
                    votes[1]++;
                    break;
                case 3:
                    votes[2]++;
                    break;
                default:
                    votes[3]++;
                    break;
            }
        } 
        
        return votes;
    }
    
    @Override
    public String toString() {
        return "Ask The Audience";
    }
}
