import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        int maxNumber = 100;
        int numberToGuess;
        int tries;
        int usrAction;
        int usrNumber;

        System.out.println("\nWelcome to 'GUESS THE NUMBER' game!");
        System.out.println("I will think of a number between 0 and 99 and you have to guess it.");
        System.out.println("You have 5 tries. Good luck and have fun!");
        while (true)
        {
            numberToGuess = new Random().nextInt(maxNumber);
            tries = 5;
            while (tries > 0)
            {
                System.out.println("\nPlease enter a number:");
                usrNumber = new Scanner(System.in).nextInt();
                if (usrNumber < 0 || usrNumber > 99)
                {
                    System.out.println("The number must be between 0 and 99!");
                }
                else
                {
                    if (usrNumber > numberToGuess)
                    {
                        tries = decrementTries(tries, numberToGuess, "high");
                    }
                    else if (usrNumber < numberToGuess)
                    {
                        tries = decrementTries(tries, numberToGuess, "low");
                    }
                    else
                    {
                        System.out.println("BRAVO! You guessed it! My number was indeed " + numberToGuess + ".");
                        break;
                    }
                }
            }
            System.out.println("\nDo you want to play again (1 - yes / 0 - no)?");
            usrAction = new Scanner(System.in).nextInt();
            if (usrAction == 0)
            {
                break;
            }
        }
        System.out.println("Thank you for playing, I hope you had fun. See you next time!");
    }

    private static int decrementTries(int tries, int number, String hiLow)
    {
        String tryOpt;
        tries--;
        if (tries == 0)
        {
            System.out.println("Unfortunately, you have run out of tries. My number was " + number + ".");
        }
        else
        {
            if (tries == 1)
            {
                tryOpt = "try";
            }
            else
            {
                tryOpt = "tries";
            }
            System.out.println("Your number is too " + hiLow + "! Try again, you still have " + tries + " " + tryOpt + ".");
        }
        return tries;
    }
}