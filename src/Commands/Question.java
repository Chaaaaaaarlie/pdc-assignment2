package Commands;

public class Question {
    private String question;
    private String correct;
    private String[] options;
    
    public Question(String question, String correct, String[] options) {
        this.question = question;
        this.correct = correct;
        this.options = options;
    }
    
    /**
     * Get the question
     */
    public String getQuestion() {
        return question;
    }
    
    /**
     * get correct answer for question
     */
    public String correctAnswer() {
        return correct;
    }
    
    /**
     * Get options to question
     */
    public String[] getOptions() {
        return options;
    }
}
