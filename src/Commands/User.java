package Commands;

public class User {
    private String username;
    private String score;
    
    public User(String u, String s) {
        username = u;
        score = s;
    }
    
    /**
     * Get username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Get score
     */
    public String getScore() {
        return score;
    }
    
    /**
     * Set score
     */
    public void setScore(String s) {
        score = s;
    }
}
