public class Main {

    public static void main(String[] args) {

        boolean startNewGame = true;
        ChoseMovie choseMovie = new ChoseMovie();

        while(startNewGame) {

            String movie = choseMovie.randomChoseMovie();
            String dashMovie = choseMovie.dashRandomChoseMovie(movie);

            Game game = new Game(movie, dashMovie);

            startNewGame = game.playAgain();

        }

    }
}