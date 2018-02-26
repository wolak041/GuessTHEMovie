import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Scanner readUserInput;
    private String movie;
    private String dashMovie;
    private ArrayList<Character> wrongCharacters = new ArrayList<>();
    private int mistakes = 0;

    Game(String movie, String dashMovie) {

        readUserInput = new Scanner(System.in);
        String userInput;
        this.movie = movie;
        this.dashMovie = dashMovie;

        System.out.println("Guess title of the movie. You can type single letters and numbers or whole sentences");
        System.out.println("You can make 5 mistakes.");

        do {

            System.out.println("The title of the movie is:");
            System.out.println(this.dashMovie);
            System.out.println("You have made (" + mistakes + "/5) mistakes");
            System.out.println("Wrong characters: " + wrongCharacters);

            userInput = readUserInput.nextLine();

            if (userInput.matches("[a-zA-Z0-9\\s]*")) {
                compareAndChange(userInput.toLowerCase());
            }
            else System.out.println("Only letters and numbers! Try again.");

            if (!containsDash()) break;

        } while(mistakes < 5);

        if(mistakes != 5) System.out.println("You win! The movie is: " + this.movie);
        else System.out.println("You lose! You have made 5 mistakes. The movie is: " + this.movie);

    }

    private void compareAndChange(String userInput){

        int charOccurrence;
        char[] charArrayUserInput = userInput.toCharArray();
        char[] charArrayDashMovie = dashMovie.toCharArray();

        for (char charUserInput : charArrayUserInput) {

            charOccurrence = 0;

            for (int y = 0; y < charArrayDashMovie.length; y++) {

                if (movie.charAt(y) == charUserInput) {
                    charArrayDashMovie[y] = charUserInput;
                    charOccurrence++;

                }

            }

            addWrongCharacters(charOccurrence, charUserInput);
            if (mistakes >= 5) break;

        }

        dashMovie = String.valueOf(charArrayDashMovie);

    }

    private void addWrongCharacters(int charOccurrence, char charUserInput) {
        if (charOccurrence == 0 && !wrongCharacters.contains(charUserInput)) {
            wrongCharacters.add(charUserInput);
            mistakes++;
        }

    }

    private boolean containsDash() {
        return dashMovie.contains("-");

    }

    public boolean playAgain() {

        while(true) {
            readUserInput = new Scanner(System.in);

            try {
                System.out.println("Do you want to play again?");
                System.out.println("1. Yes");
                System.out.println("2. No");

                int userInput = readUserInput.nextInt();

                if (userInput == 1) return true;
                if (userInput == 2) return false;

                System.out.println("Type 1 to play again or 2 to exit.");

            } catch(InputMismatchException e) {
                System.out.println("Type 1 to play again or 2 to exit.");

            }

        }

    }

}
