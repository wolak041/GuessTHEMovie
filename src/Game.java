import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Scanner readUserInput;
    private char[] movie;
    private char[] dashMovie;
    private ArrayList<Character> wrongCharacters = new ArrayList<>();
    private int mistakes = 0;

    Game(char[] movie, char[] dashMovie) {

        readUserInput = new Scanner(System.in);
        String userChar;
        this.movie = movie;
        this.dashMovie = dashMovie;

        System.out.println("Guess title of the movie by typing a letter or a number.");
        System.out.println("You can make 5 mistakes.");

        do {

            System.out.println("The title of the movie is:");
            System.out.println(this.dashMovie);
            System.out.println("You have made (" + mistakes + "/5) mistakes");
            System.out.println("Wrong characters: " + wrongCharacters);

            userChar = readUserInput.next();

            if (userChar.matches("[a-zA-Z0-9]")) {
                char singleChar = Character.toLowerCase(userChar.charAt(0));
                compareAndChange(singleChar);
            }
            else System.out.println("It's not a single letter or digit. Try again.");

            if (!containsDash()) break;

        } while(mistakes < 5);

        if(mistakes != 5) System.out.println("You win! The movie is: " + new String(this.movie));
        else System.out.println("You lose! You have made 5 mistakes. The movie is: " + new String(this.movie));

    }

    private void compareAndChange(char userChar){

        int charOccurrence = 0;

        for (int i = 0; i < movie.length; i++) {

            if (movie[i] == userChar) {
                dashMovie[i] = userChar;
                charOccurrence++;
            }

        }

        addWrongCharacters(charOccurrence, userChar);

    }

    private void addWrongCharacters(int charOccurrence, char userChar) {
        if (charOccurrence == 0 && !wrongCharacters.contains(userChar)) {
            wrongCharacters.add(userChar);
            mistakes++;
        }

    }

    private boolean containsDash() {
        return Arrays.toString(dashMovie).contains("-");

    }

    public boolean playAgain() {

        readUserInput = new Scanner(System.in);
        int userInput;
        boolean playAgain = false;

        System.out.println("Do you want to play again?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        try {
            userInput = readUserInput.nextInt();
            if (userInput == 1) playAgain = true;
            else if (userInput == 2) playAgain = false;
            else {
                System.out.println("Type 1 to play again or 2 to exit.");
                playAgain();
            }

        } catch (InputMismatchException e) {
            System.out.println("Type 1 to play again or 2 to exit.");
            playAgain();
        }

        return playAgain;

    }

}
