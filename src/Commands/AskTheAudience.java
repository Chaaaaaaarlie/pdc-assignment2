package Commands;

import java.util.concurrent.ThreadLocalRandom;

public class AskTheAudience extends LifeLineAbstract {

    @Override
    public void use() {
        int[] votes = audienceVotes();
        System.out.println("The audience votes: ");
        System.out.println("A = " + votes[0] + "%");
        System.out.println("B = " + votes[1] + "%");
        System.out.println("C = " + votes[2] + "%");
        System.out.println("D = " + votes[3] + "%");
        active = false;
    }
    
    /**
     * Getter for
     */
    @Override
    public String getAnswer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
