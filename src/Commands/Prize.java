package Commands;

public class Prize {
    private String[] allPrizes;
    private int currentPrize;
    
    public Prize() {
        allPrizes = new String[]{
            "$0", "$100", "$200", "$300", "$500", "$1,000", "$2,000", "$4,000",
            "$8,000", "$16,000", "$32,000", "$64,000", "$125,000", "$250,000",
            "$500,000", "$1 MILLION"
        };      
        currentPrize = 0;
    }
    
    /**
     * Getter for current prize value
     */
    public String getCurrentPrize() {
        return allPrizes[currentPrize];
    }
    
    /**
     * Increment prize when player gets question correct
     */
    public void increasePrize() {
        currentPrize++;
    }
    
    /**
     * Getter for allPrizes
     */
    public String[] getPrizePool() {
        return allPrizes;
    }
    
    /**
     * Get next prize
     */
    public String getNextPrize(String current) {
        String nextPrize = "";
        for (int i = 0; i < allPrizes.length; i++) {
            if (current.equals(allPrizes[i])) {
                nextPrize = allPrizes[i+1];
            }
        }
        
        return nextPrize;
    } 
}

