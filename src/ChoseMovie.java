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

    public String randomChoseMovie() {
        return listOfMovies.get((int) (Math.random() * listOfMovies.size()));

    }

    public String dashRandomChoseMovie(String randomChoseMovie) {
        return randomChoseMovie.replaceAll("[a-zA-Z0-9]", "-");

    }

}
