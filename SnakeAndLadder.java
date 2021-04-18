import java.util.Random;

/**
 * SnakeAndLadder
 */
public class SnakeAndLadder {
    // UC1 Initilize Starting and Ending Point
    static final int START_POS = 0;
    static final int END_POS = 100;

    // UC3 User chekcs for plays
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;

    public static void GamePlayed() {
        // UC2 Rolling the dice to get a number between 1 to 6
        Random random = new Random();
        int current_position = START_POS;

        // UC4 Loop until reaches to Ending Position
        while (current_position < END_POS) {

            int DICE = random.nextInt(6) + 1;
            // System.out.println("Rolling dice: " + DICE);

            int action = random.nextInt(3);
            // System.out.println("Action dice: " + action);

            // UC3 Check the play.

            if (action == LADDER && (current_position + DICE <= END_POS)) {

                current_position = current_position + DICE;
                // System.out.println("Current position is: " + current_position);

            } else if (action == SNAKE && (current_position - DICE >= START_POS)) {

                current_position = current_position - DICE;
                // System.out.println("Current position is: " + current_position);

            } else if (action == NO_PLAY) {
                // System.out.println("No Play");
            }
            System.out.print(current_position + " ");
        }
        // UC5 The player gets excat wining
        System.out.println();
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        System.out.println("Congratulation");
        System.out.println("You win the game. ");
        System.out.println("Your Position is: " + current_position);
    }

    public static void main(String[] args) {
        GamePlayed();
    }
}