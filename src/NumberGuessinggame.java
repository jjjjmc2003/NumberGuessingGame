import java.util.Scanner;
import java.util.Random;

//This is the Linked List version of the Number Guessing Game
class GuessNode {
    int guess;
    GuessNode next;
// So this code here creates the class GuessNode with the variables guess and next
// which are used to store the guesses and the next node in the linked list
// in other words this is where the stuff is stored dynamically
    public GuessNode(int guess) {
        this.guess = guess;
        this.next = null;
    }
}
//Here we have your shell code
public class NumberGuessinggame {
    private int secretNumber;
    private final int MAX_NUMBER = 100;
    private GuessNode head;

    public NumberGuessinggame() {
        secretNumber = new Random().nextInt(MAX_NUMBER) + 1;
        head = null;
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
        if (head == null) {
            head = new GuessNode(guess);
        } else {
            GuessNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new GuessNode(guess);
        }
    }

//Now we get to part two of the linked list... calling it. So we already identified
// that the class Node was used to store the guesses, so this part is where we go through
// that wonderful dynamic linked list and print out the stuff inside of the list

    private void printGuesses() {
        System.out.println("Here are your guesses in order:"); //Prints guesses out
        GuessNode current = head;
        while (current != null) {
            System.out.println(current.guess);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        NumberGuessinggame game = new NumberGuessinggame();
        game.playGame();
    }
}
