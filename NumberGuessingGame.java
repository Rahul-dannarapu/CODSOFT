import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static int score = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (scanner) {
            System.out.println("Welcome to the Number Guessing Game!");
            boolean playAgain;
            
            do {
                playRound();
                System.out.println("Current Score: " + score);
                System.out.print("Do you want to play another round? (yes/no): ");
                playAgain = scanner.next().equalsIgnoreCase("yes");
            } while (playAgain);
            
            System.out.println("Thank you for playing! Final Score: " + score);
        }
    }

    private static void playRound() {
        Random random = new Random();
        int numberToGuess = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("\nGuess the number between " + MIN_NUMBER + " and " + MAX_NUMBER + ". You have " + MAX_ATTEMPTS + " attempts.");

        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                guessedCorrectly = true;
                score += (MAX_ATTEMPTS - attempts + 1);  // Score based on attempts left
                System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
        }
    }
}
