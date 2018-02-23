import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChoseMovie {

    private ArrayList<String> listOfMovies = new ArrayList<>();

    ChoseMovie() {

        try {
            File moviesFile = new File("movies.txt");
            Scanner readMoviesFile = new Scanner(moviesFile);

            while (readMoviesFile.hasNextLine()){
                listOfMovies.add(readMoviesFile.nextLine());
            }

            readMoviesFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("An internal error occurred! Please try again later.");
        }

    }

    public char[] randomChoseMovie() {
        return listOfMovies.get((int) (Math.random() * listOfMovies.size())).toCharArray();

    }

    public char[] dashRandomChoseMovie(char[] RandomChoseMovie) {
        char[] dashChosenMovie = RandomChoseMovie.clone();

        for (int i = 0; i < RandomChoseMovie.length; i++) {
            if (Character.toString(dashChosenMovie[i]).matches("[a-zA-Z0-9]")) {
                dashChosenMovie[i] = '-';
            }
        }

        return dashChosenMovie;

    }

}
