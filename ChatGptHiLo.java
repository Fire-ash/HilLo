package def;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChatGptHiLo {
    private static final int EASY_ATTEMPTS = 10;
    private static final int MEDIUM_ATTEMPTS = 7;
    private static final int HARD_ATTEMPTS = 5;

    private static int rangeMin = 1;
    private static int rangeMax = 100;
    private static int maxAttempts = MEDIUM_ATTEMPTS;

    private static int totalGames = 0;
    private static int wins = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("🎉 Welcome to the Enhanced HiLo Game!");
        System.out.println("Try to guess the number I'm thinking of...");

        do {
            selectDifficulty(scan);
            playGame(scan);
            totalGames++;
        } while (askToPlayAgain(scan));

        printStats();
        scan.close();
    }

    private static void selectDifficulty(Scanner scan) {
        System.out.println("\nSelect difficulty level:");
        System.out.println("1. Easy (10 attempts, range 1–50)");
        System.out.println("2. Medium (7 attempts, range 1–100)");
        System.out.println("3. Hard (5 attempts, range 1–200)");

        while (true) {
            System.out.print("Enter 1, 2, or 3: ");
            String input = scan.next();

            switch (input) {
                case "1":
                    rangeMax = 50;
                    maxAttempts = EASY_ATTEMPTS;
                    return;
                case "2":
                    rangeMax = 100;
                    maxAttempts = MEDIUM_ATTEMPTS;
                    return;
                case "3":
                    rangeMax = 200;
                    maxAttempts = HARD_ATTEMPTS;
                    return;
                default:
                    System.out.println("Invalid input. Please choose 1, 2, or 3.");
            }
        }
    }

    private static void playGame(Scanner scan) {
        int targetNumber = (int) (Math.random() * (rangeMax - rangeMin + 1)) + rangeMin;
        int attempts = 0;
        boolean won = false;

        System.out.printf("%n🎯 I have picked a number between %d and %d. You have %d attempts.%n",
                rangeMin, rangeMax, maxAttempts);

        while (attempts < maxAttempts) {
            int guess = getValidGuess(scan, attempts);
            attempts++;

            if (guess == targetNumber) {
                System.out.printf("✅ Correct! You guessed the number in %d attempt%s.%n",
                        attempts, attempts > 1 ? "s" : "");
                wins++;
                won = true;
                break;
            } else if (guess < targetNumber) {
                System.out.printf("⬆️  %d is too low. ", guess);
            } else {
                System.out.printf("⬇️  %d is too high. ", guess);
            }

            System.out.printf("%d attempt%s remaining.%n", maxAttempts - attempts,
                    (maxAttempts - attempts) != 1 ? "s" : "");
        }

        if (!won) {
            System.out.printf("❌ You've used all attempts. The correct number was %d.%n", targetNumber);
        }
    }

    private static int getValidGuess(Scanner scan, int attempt) {
        while (true) {
            System.out.printf("Guess #%d (between %d and %d): ", attempt + 1, rangeMin, rangeMax);
            try {
                int guess = scan.nextInt();
                if (guess >= rangeMin && guess <= rangeMax) {
                    return guess;
                } else {
                    System.out.printf("Please enter a number between %d and %d.%n", rangeMin, rangeMax);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Clear invalid input
            }
        }
    }

    private static boolean askToPlayAgain(Scanner scan) {
        System.out.print("\nWould you like to play again? (y/n): ");
        while (true) {
            String input = scan.next().trim().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.print("Please enter 'y' or 'n': ");
        }
    }

    private static void printStats() {
        System.out.println("\n📊 Game Summary:");
        System.out.printf("Games played: %d%n", totalGames);
        System.out.printf("Games won:    %d%n", wins);
        System.out.printf("Win rate:     %.2f%%%n", totalGames > 0 ? (100.0 * wins / totalGames) : 0.0);
        System.out.println("Thanks for playing HiLo! 👋");
    }
}
