import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int maxNumber = 100;
        int tries = 5;
        int numberToGuess = 0;
        Boolean gameFinished = false;

        System.out.println("\nWelcome to 'GUESS THE NUMBER' game!");
        System.out.println("I will think of a number between 0 and 99 and you have to guess it.");
        System.out.println("You have 5 tries. Good luck and have fun!");

        while (tries > 0)
        {
            if (tries == 5) {
                numberToGuess = new Random().nextInt(maxNumber);
            }

            System.out.println("\nPlease enter a number:");
            int userNumber = new Scanner(System.in).nextInt();
            tries--;

            if (userNumber == numberToGuess)
            {
                System.out.println("BRAVO! You guessed it! My number was indeed " + numberToGuess + ".");
                gameFinished = true;
            }

            if (tries == 0)
            {
                System.out.println("Unfortunately, you have run out of tries. My number was " + numberToGuess + ".");
                gameFinished = true;
            }

            if (!gameFinished) {
                printHint(tries, userNumber > numberToGuess ? "high" : "low");
                continue;
            }

            System.out.println("\nDo you want to play again (1 - yes / 0 - no)?");
            int usrAction = new Scanner(System.in).nextInt();
            if (usrAction != 0) {
                System.out.println("Starting new game...");
                tries = 5;
            }
        }
        System.out.println("\nThank you for playing, I hope you had fun. See you next time!");
    }

    public static void printHint(int tries, String hint)
    {
        System.out.println("Your number is too " + hint + "! Try again (tries left: " + tries + ").");
    }
}