package Commands;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Question> questions;
    private Prize prize;
    private FiftyFifty fiftyFifty;
    private LifeLine phoneAFriend;
    private LifeLine askTheAudience;
    private User user;    
    
    /**
     * Constructor when there are only 15 questions to choose from
     * @param questions 
     */
    public Game(List<Question> questions, User u) {      
        this.questions = questions;       
        prize = new Prize();
        fiftyFifty = new FiftyFifty();
        phoneAFriend = new PhoneAFriend();
        askTheAudience = new AskTheAudience();
        user = u;
    }
    
    /**
     * Constructor when there are MORE than 15 questions to choose from
     * @param questions
     * @param numQuestions 
     */
    public Game(List<Question> questions, int numQuestions) {
        this.questions = questions;       
        //this.selectQuestions();
    }
    
    /**
     * Questions asked here
     */
    public void play() {
        String userAnswer = "";
        String realAnswer = "";
        String[] shuffledOptions = null;
        Scanner sc = new Scanner(System.in);
        
        // Each loop asks one question and displays its corresponding options
        for (Question q : questions) {  
            do {
                System.out.println("==========================================================================================\n");  
                displayLifeLine();
                displayPrize();                
                System.out.println("\n" + q.getQuestion());
                        
                shuffledOptions = shuffleOptions(q.getOptions());
                
                // Display options    
                if (!fiftyFifty.isActive() && !fiftyFifty.isShown()) {
                    String[] options = fiftyFifty.getFiftyFifty();
                    
                    for (int i = 0; i < 2; i++) {
                        System.out.println(options[i]);
                    }
                    fiftyFifty.shown();
                } else {                                                           
                    char letter = 'A';
                    for (String s : shuffledOptions) {
                        if (s.equals(q.correctAnswer())) {
                            realAnswer = Character.toString(letter);
                        }

                        System.out.println(letter + ". " + s);
                        letter++;
                    }  
                }
            
                System.out.print("Enter answer here: ");
                userAnswer = sc.nextLine();
                
                System.out.println("==========================================================================================");
                
                // Check if Lifeline is used
                if (userAnswer.equals("1")) {
                    if (!fiftyFifty.isActive()) {
                        System.out.println("Already used fifty fifty");
                    } else {
                        fiftyFifty.getQuestion(q, shuffledOptions, realAnswer);
                        useLifeLine(fiftyFifty);
                    }    
                } else if (userAnswer.equals("2")) {
                    if (!phoneAFriend.isActive()) {
                        System.out.println("Already used phone a friend");
                    } else {     
                        useLifeLine(phoneAFriend);
                    }                    
                } else if (userAnswer.equals("3")) {
                    if (!askTheAudience.isActive()) {
                        System.out.println("Already used ask the audience");
                    } else {                       
                       useLifeLine(askTheAudience); 
                    }                   
                } else {
                    // Check if user input is valid
                    if(userAnswer.toUpperCase().equals("A") || userAnswer.toUpperCase().equals("B") || userAnswer.toUpperCase().equals("C") || userAnswer.toUpperCase().equals("D")) {
                        break;
                    } else {                       
                        System.out.println("ERROR: \"" + userAnswer + "\" is not a valid option.\n");
                    }
                }                       
            } while(true);
            
            // Valid input so check if userAnswer is correct
            if (userAnswer.toUpperCase().equals(realAnswer)) {
                prize.increasePrize();
            } else {
                System.out.println("====================================== Game Over =========================================");
                System.out.println("Answer was:\n" + realAnswer + ". " + q.correctAnswer());
                System.out.println("You win: " + prize.getCurrentPrize());
                System.out.println("Total questions correct: " + questions.indexOf(q));
                break;
            }           
        }
        
        user.setScore(prize.getCurrentPrize());
        endGameMenu();
    }
    
    /**
     * Shuffle options order
     */
    private String[] shuffleOptions(String[] options) {
            List<String> optionsList = Arrays.asList(options);
            Collections.shuffle(optionsList);
            return optionsList.toArray(new String[optionsList.size()]);
    }
    
    /**
     * Display prize list and indicate question number and prize to user
     */
    private void displayPrize() {       
        String[] prizePool = prize.getPrizePool();
        for (int i = prizePool.length-1; i > 0; i--) {
            if (!prize.getCurrentPrize().equals("$1 MILLION")) {
                if (prize.getNextPrize(prize.getCurrentPrize()).equals(prizePool[i])) {
                    System.out.println("\t\t\t\t\t\t\t\t\t" + i + ". " + prizePool[i] + " <");
                } else {
                    System.out.println("\t\t\t\t\t\t\t\t\t" + i + ". " + prizePool[i]); 
                }    
            }
        }
    }
    
    /**
     * Use lifeline
     */
    private void useLifeLine(LifeLine lifeLine) {
        lifeLine.use();
    }
    
    /**
     * Display lifeline
     */
    private void displayLifeLine() {
        if (fiftyFifty.isActive()) {
            System.out.print("1 = Fifty Fifty\t\t");
        } else {
            System.out.print("Fifty Fifty used\t");
        }
        
        if (phoneAFriend.isActive()) {
            System.out.print("2 = Phone A Friend\t");
        } else {
            System.out.print("Phone A Friend used\t");
        }
        
        if (askTheAudience.isActive()) {
            System.out.println("3 = Ask The Audience");
        } else {
            System.out.println("Ask The Audience used");
        }
    }

    /**
     * End of game menu
     */
    private void endGameMenu() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(true) {
            System.out.print("\nPress 1 to return to main menu, or press 2 to exit: ");
            input = scanner.nextLine();  
            
            if (input.equals("1")) {
                break;
            } 
            
            if (input.equals("2")) {
                System.exit(0);
            }  
        }            
    }
}
