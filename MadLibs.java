package def;
import java.util.Scanner;
public class MadLibs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Asking the user for words
        System.out.println("Enter an adjective: ");
        String adjective = scanner.nextLine();

        System.out.println("Enter a noun: ");
        String noun = scanner.nextLine();

        System.out.println("Enter a verb (past tense): ");
        String verbPastTense = scanner.nextLine();

        System.out.println("Enter an adverb: ");
        String adverb = scanner.nextLine();

        System.out.println("Enter another adjective: ");
        String adjective2 = scanner.nextLine();

        System.out.println("Enter another noun: ");
        String noun2 = scanner.nextLine();

        System.out.println("Enter another noun: ");
        String noun3 = scanner.nextLine();

        System.out.println("Enter another verb (past tense): ");
        String verbPastTense2 = scanner.nextLine();

        System.out.println("Enter another adverb: ");
        String adverb2 = scanner.nextLine();

        // The story
        System.out.println("\n--- Your Mad Libs Story ---");
        System.out.println("Today I went to the zoo. I saw a(n) " + adjective + " " + noun + 
                           " jumping up and down in its tree\r\n It " + verbPastTense + " " + adverb + 
                           " through the large tunnel that led to its " + adjective2 + " " + noun2 + 
                           ".\r\n I got some peanuts and passed them through the cage to a gigantic " + noun3 + 
                           " that " + verbPastTense2 + " " + adverb2 + ".\r\n It was a fun day!");

        scanner.close();
    }

	}

