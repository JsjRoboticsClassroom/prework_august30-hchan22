package nyc.c4q;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean playAgain = true;

        while (playAgain) {
            Hangman hangman = new Hangman();
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }
            System.out.println("Do you want to play again?");

            boolean isValidInput = false;
            do {
                Scanner scanner = new Scanner(System.in);
                String userAnswer = scanner.next();
                userAnswer = userAnswer.toLowerCase();
                if (userAnswer.equals("yes") || userAnswer.equals("y")){
                    break;

                }else if (userAnswer.equals("no") || userAnswer.equals("n")){
                    playAgain = false;

                }else{
                    isValidInput = true;
                    System.out.println("Invalid answer. Try Again");

                }
            } while (isValidInput);


        }
    }
}