import java.util.*;

// Movie class to represent each movie
class Movie {
    private String title;
    private int availableSeats;

    public Movie(String title, int availableSeats) {
        this.title = title;
        this.availableSeats = availableSeats;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int numSeats) {
        if (numSeats > availableSeats) {
            System.out.println("Sorry, not enough seats available.");
        } else {
            availableSeats -= numSeats;
            System.out.println("Seats booked successfully for " + title);
        }
    }
}

// MovieTicketBookingSystem class to manage the booking system
public class MovieTicketBookingSystem {
    private List<Movie> movies;

    public MovieTicketBookingSystem() {
        movies = new ArrayList<>();
        // Adding some dummy movies for demonstration
        movies.add(new Movie("Avengers: Endgame", 100));
        movies.add(new Movie("The Dark Knight", 80));
        movies.add(new Movie("Inception", 120));
    }

    public void displayMovies() {
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getTitle());
        }
    }

    public void bookTickets(int movieIndex, int numSeats) {
        if (movieIndex >= 0 && movieIndex < movies.size()) {
            Movie selectedMovie = movies.get(movieIndex);
            selectedMovie.bookSeats(numSeats);
        } else {
            System.out.println("Invalid movie selection.");
        }
    }

    public static void main(String[] args) {
        MovieTicketBookingSystem bookingSystem = new MovieTicketBookingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Movie Ticket Booking System");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookingSystem.displayMovies();
                    break;
                case 2:
                    bookingSystem.displayMovies();
                    System.out.print("Enter movie index: ");
                    int movieIndex = scanner.nextInt() - 1;
                    System.out.print("Enter number of seats to book: ");
                    int numSeats = scanner.nextInt();
                    bookingSystem.bookTickets(movieIndex, numSeats);
                    break;
                case 3:
                    System.out.println("Thank you for using the Movie Ticket Booking System.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
