// numguesser game 
import java.util.Random;
import java.util.Scanner;

public class NumGuesser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int target = random.nextInt(100) + 1; // random number between 1–100
        int attempts = 10;

        Integer prevGuess = null; // keep track of last guess
        String prevHint = "";     // "high" or "low"

        System.out.println(" Guess the number between 1 and 100!");
        System.out.println("You have " + attempts + " attempts.");

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": Enter your guess: ");
            int guess = scanner.nextInt();

            // Check if correct
            if (guess == target) {
                System.out.println(" Correct! You guessed the number in " + i + " tries.");
                break;
            }

            // Give hints
            if (guess > target) {
                System.out.println("Too high!");
                if (prevGuess != null && prevHint.equals("high") && guess > prevGuess) {
                    System.out.println(" Come on, pay attention dude!");
                }
                prevHint = "high";
            } else {
                System.out.println("Too low!");
                if (prevGuess != null && prevHint.equals("low") && guess < prevGuess) {
                    System.out.println(" Come on, pay attention dude!");
                }
                prevHint = "low";
            }

            prevGuess = guess;

            // If out of attempts
            if (i == attempts) {
                System.out.println(" Sorry, you’ve used all attempts. The number was: " + target);
            }
        }

        scanner.close();
    }
}
    

