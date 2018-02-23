public class Main {

    public static void main(String[] args) {

        boolean playAgain;

        do {
            ChoseMovie choseMovie = new ChoseMovie();

            char[] movie = choseMovie.randomChoseMovie();
            char[] dashMovie = choseMovie.dashRandomChoseMovie(movie);

            Game game = new Game(movie, dashMovie);

            playAgain = game.playAgain();

        } while(playAgain);

    }
}