package def;

import java.util.Scanner;

public class GrokHiLo {
    private static final int MAX_ATTEMPTS = 7;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String playAgain;

        System.out.println("Welcome to HiLo! Guess the number between " + RANGE_MIN + " and " + RANGE_MAX + ".");

        do {
            playGame(scan);
            System.out.println("\nWould you like to play again? (y/n)");
            playAgain = getValidPlayAgainInput(scan);
        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Thank you for playing! Goodbye.");
        scan.close();
    }

    private static void playGame(Scanner scan) {
        int theNumber = (int)(Math.random() * (RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN);
        int guessCount = 0;
        boolean hasWon = false;

        while (guessCount < MAX_ATTEMPTS) {
            int guess = getValidGuess(scan, guessCount);
            guessCount++;

            if (guess == theNumber) {
                hasWon = true;
                System.out.printf("Correct! You guessed %d in %d attempts!%n", guess, guessCount);
                break;
            } else if (guess < theNumber) {
                System.out.printf("%d is too low. %d attempts left.%n", guess, MAX_ATTEMPTS - guessCount);
            } else {
                System.out.printf("%d is too high. %d attempts left.%n", guess, MAX_ATTEMPTS - guessCount);
            }
        }

        if (!hasWon) {
            System.out.printf("Sorry, you've run out of attempts! The number was %d.%n", theNumber);
        }
    }

    private static int getValidGuess(Scanner scan, int guessCount) {
        while (true) {
            System.out.printf("Guess #%d (between %d and %d): ", guessCount + 1, RANGE_MIN, RANGE_MAX);
            if (scan.hasNextInt()) {
                int guess = scan.nextInt();
                if (guess >= RANGE_MIN && guess <= RANGE_MAX) {
                    return guess;
                } else {
                    System.out.printf("Please enter a number between %d and %d.%n", RANGE_MIN, RANGE_MAX);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Clear invalid input
            }
        }
    }

    private static String getValidPlayAgainInput(Scanner scan) {
        while (true) {
            String input = scan.next();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                return input;
            }
            System.out.println("Please enter 'y' or 'n':");
        }
    }
}
