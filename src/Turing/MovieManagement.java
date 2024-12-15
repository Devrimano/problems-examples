package Turing;
import java.util.*;


class Movie {
    private String name;
    private double rating;


    public Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{name='" + name + '\'' + ", rating=" + rating + '}';
    }
}

public class MovieManagement {

    private static List<Movie> movies = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1 -> inputMovies();
                case 2 -> displayMovies();
                case 3 -> addMoreMovies();
                case 4 -> showStatistics();
                case 5 -> searchMovie();
                case 6 -> updateMovieRating();
                case 7 -> deleteMovie();
                case 8 -> sortMovies();
                case 0 -> {
                    System.out.println("Exiting program.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Input movies");
        System.out.println("2. Display movies and ratings");
        System.out.println("3. Add more movies");
        System.out.println("4. Show statistics");
        System.out.println("5. Search for a movie");
        System.out.println("6. Update movie ratings");
        System.out.println("7. Delete a movie");
        System.out.println("8. Sort movies by ratings");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void inputMovies() {
        movies.clear();
        System.out.println("Enter details for 3 movies:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter movie name: ");
            String name = scanner.nextLine();
            System.out.print("Enter movie rating: ");
            double rating = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            movies.add(new Movie(name, rating));
        }
    }

    private static void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies and their ratings:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    private static void addMoreMovies() {
        System.out.print("How many additional movies do you want to add? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < count; i++) {
            System.out.print("Enter movie name: ");
            String name = scanner.nextLine();
            System.out.print("Enter movie rating: ");
            double rating = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            movies.add(new Movie(name, rating));
        }
    }

    private static void showStatistics() {
        if (movies.isEmpty()) {
            System.out.println("No movies to analyze.");
            return;
        }
        double sum = 0;
        Movie maxRated = movies.get(0);
        Movie minRated = movies.get(0);

        for (Movie movie : movies) {
            sum += movie.getRating();
            if (movie.getRating() > maxRated.getRating()) maxRated = movie;
            if (movie.getRating() < minRated.getRating()) minRated = movie;
        }

        double average = sum / movies.size();
        System.out.println("Average Rating: " + average);
        System.out.println("Highest Rated Movie: " + maxRated);
        System.out.println("Lowest Rated Movie: " + minRated);
    }

    private static void searchMovie() {
        System.out.print("Enter the name of the movie to search: ");
        String name = scanner.nextLine();
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                System.out.println("Found movie: " + movie);
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    private static void updateMovieRating() {
        System.out.print("Enter the name of the movie to update rating: ");
        String name = scanner.nextLine();
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new rating: ");
                double newRating = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                movie.setRating(newRating);
                System.out.println("Rating updated.");
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    private static void deleteMovie() {
        System.out.print("Enter the name of the movie to delete: ");
        String name = scanner.nextLine();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equalsIgnoreCase(name)) {
                movies.remove(i);
                System.out.println("Movie deleted.");
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    private static void sortMovies() {
        movies.sort(Comparator.comparingDouble(Movie::getRating));
        System.out.println("Movies sorted by ratings:");
        displayMovies();
    }
}
