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

        if(mistakes != 5) System.out.println("You win! The movie is: " + this.movie);
        else System.out.println("You lose! You have made 5 mistakes. The movie is: " + this.movie);

    }

    private void compareAndChange(char userChar){

        int charOccurrence = 0;
        char[] charDashMovie = dashMovie.toCharArray();

        for (int i = 0; i < charDashMovie.length; i++) {
            if (movie.charAt(i) == userChar) {
                charDashMovie[i] = userChar;
                charOccurrence++;
            }

        }

        dashMovie = String.valueOf(charDashMovie);

        addWrongCharacters(charOccurrence, userChar);

    }

    private void addWrongCharacters(int charOccurrence, char userChar) {
        if (charOccurrence == 0 && !wrongCharacters.contains(userChar)) {
            wrongCharacters.add(userChar);
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
