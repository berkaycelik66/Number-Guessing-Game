import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Random rand = new Random();
        int number = rand.nextInt(100);

        int right = 0;
        int guess;
        int[] wrongGuesses = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        while (right < 5) {
            System.out.println("---------------------------");
            System.out.print("Please enter your guess: ");
            guess = input.nextInt();

            if (guess < 0 || guess > 100) {
                System.out.println("\nPlease enter a value between 0-100");

                if (isWrong) {
                    right++;
                    System.out.println("You made too many incorrect entries. Remaining right : " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Your next wrong entry will be deducted from your rights.");
                }
                continue;
            }

            if (guess == number) {
                System.out.println("\nCongratulations, Your guess is correct! Number: " + number);
                isWin = true;
                break;
            } else {
                System.out.println("\nYour guess is incorrect.");

                if (guess > number) {
                    System.out.println(guess + " is greater than the hidden number.");
                } else {
                    System.out.println(guess + " is less than the hidden number.");
                }

                wrongGuesses[right] = guess;
                right++;
                System.out.println("Remaining Right: " + (5 - right));
            }
        }

        if (!isWin) {
            System.out.println("\nYou lost! You did not guess the number correctly.");
            System.out.println("Correct Number is " + number);
            if (!isWrong) {
                System.out.println("Your guesses: " + Arrays.toString(wrongGuesses));
            }
        }
    }
}
