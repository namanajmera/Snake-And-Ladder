import java.util.Random;

/**
 * SnakeAndLadder
 */
public class SnakeAndLadder {
    // UC1 Initilize Starting and Ending Point
    static final int START_POS = 0;
    static final int END_POS = 100;
    static Random random = new Random();
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static String task = null;

    public static int GamePlayed(int current_position, int diceCount) {
        if (current_position < END_POS) {

            int DICE = random.nextInt(6) + 1;

            int action = random.nextInt(3);

            switch (action) {
            case LADDER:
                if (action == LADDER && (current_position + DICE <= END_POS)) {
                    current_position = current_position + DICE;
                    task = "Ladder";
                }
                break;
            case SNAKE:
                if (action == SNAKE && (current_position - DICE >= START_POS)) {
                    current_position = current_position - DICE;
                    task = "Snake";
                }

            default:
                if (action == NO_PLAY) {
                    task = "No Play";
                }
                break;
            }
            System.out.println("| Dice:" + DICE + " " + task + " and Current position:" + current_position + " |");

            if (task == "Ladder" && current_position != END_POS) {
                diceCount = DiceCount(diceCount);
                GamePlayed(current_position, diceCount);
            }

        }
        return current_position;
    }

    public static int DiceCount(int diceCount) {
        diceCount++;
        return diceCount;
    }

    public static void twoPlayers() {
        int Player1Position = START_POS;
        int Player2Position = START_POS;
        int diceCount = START_POS;
        System.out.println("Game started by two Players.");
        while (Player1Position < END_POS && Player2Position < END_POS) {
            System.out.println("Player 1:- ");
            Player1Position = GamePlayed(Player1Position, diceCount);
            diceCount = DiceCount(diceCount);
            System.out.println(
                    "----------------------------------------------------------------------------------------------");
            if (Player1Position == END_POS) {
                break;
            }

            System.out.println("Player 2:- ");
            Player2Position = GamePlayed(Player2Position, diceCount);
            diceCount = DiceCount(diceCount);
            System.out.println(
                    "----------------------------------------------------------------------------------------------");
        }
        if (Player1Position == END_POS) {
            System.out.println();
            System.out.println("Player 1 Win.");
        } else if (Player2Position == END_POS) {
            System.out.println();
            System.out.println("Player 2 Win.");
        }
        System.out.println("Total dice played by both player is:- " + diceCount);
    }

    public static void main(String[] args) {
        twoPlayers();
    }

}