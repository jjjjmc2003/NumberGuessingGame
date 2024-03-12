import java.util.Scanner;
import java.util.Random;
import java.util.Arrays; //Pretty cool right, use it later to make copy of array

public class ArrayGuessing {
    // So instead of a fancy node class with a linked list, we are making a good
    // ole fashioned array
    private int secretNumber;
    private final int MAX_NUMBER = 100;
    private int[] guesses;
    // To keep track of the number of guesses we need two intergers
    // guesses and numGuesses because we have no more nodes
    private int numGuesses;

    public ArrayGuessing() {
    // Here's the array... pretty cool right
    // first using your shell code we come up with the secret numero

        secretNumber = new Random().nextInt(MAX_NUMBER) + 1;
        guesses = new int[10]; // Then we set the initial size of the array because we are no longer dynamic
        numGuesses = 0; // Then we set the initial number of guesses
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int guess;
        do {
            System.out.print("Guess a number between 1 and " + MAX_NUMBER + ": ");
            guess = scanner.nextInt();
            recordGuess(guess);
            if (guess > secretNumber) {
                System.out.println("Too high!");
            } else if (guess < secretNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Correct! The number was " + secretNumber);
                printGuesses();
            }
        } while (guess != secretNumber);
    }

    private void recordGuess(int guess) {
        if (numGuesses == guesses.length) {
            // Since our array is set at 10 we might need to resize the array
            // in case these users are terrible at guessing numbers and need more than
            // 10 tries, do not bring them to the casino
            guesses = Arrays.copyOf(guesses, guesses.length * 2);
        }
        // So with the line above me we've already established they're not very
        // good at this whole guessing thing so we have to resize the array
        // We do that by copying the array we already have and doubling the size
        // we do this because we still need to keep track of the previous guesses
        // but need to make room for their new guesses
        guesses[numGuesses++] = guess;
        // Then we increment the number of guesses so that we can keep
        // track of these new guesses
    }

    private void printGuesses() {
        System.out.println("Your previous guesses:");
        for (int i = 0; i < numGuesses; i++) {
            System.out.println(guesses[i]);
        }
    }
    // So instead of using a while loop to iterate over the node linked list
    // since we have our ole fashioned array we can just for loop it and print it

    public static void main(String[] args) {
        ArrayGuessing game = new ArrayGuessing();
        game.playGame();
    }
}

// Analysis Time

// After dealing with both of these I would definitely say that new is always
// scary and with limited experience with a linked list up until this class
// it was easier for me to write this code in the array version just because of
// my experience with arrays and for loops. However, if I were to do this again
// I would definitely do it in a linked list version simply because it is a lot
// simpler. Build a list that grows as the user guesses is much simpler, cleaner
// and more efficient, which is the whole point of computer science, learn to do it
// then learn to do it better. So Linked List is definitely cooler because it is
// dynamic and does not need an if statement to resize it if the person does indeed
// suck at guessing numbers.