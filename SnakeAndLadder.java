import java.util.Random;

/**
 * SnakeAndLadder
 */
public class SnakeAndLadder {
    // UC1 Initilize Starting and Ending Point
    static final int START_POS = 0;
    static final int END_POS = 100;

    public static void RollingDice() {
        // UC2 Rolling the dice to get a number between 1 to 6
        Random random = new Random();
        int DICE = random.nextInt(6) + 1;
        System.out.println("Rolling dice:- " + DICE);
    }

    public static void main(String[] args) {
        RollingDice();
    }

}