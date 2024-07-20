package A4;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Library {
    // Add the missing implementation to this class

    private String Address;
    private static final int StartTime = 9;
    private static final int CloseTime = 5;
    private List<Book> Books;

    public Library(String address) {
        Address = address;
        Books = new ArrayList<Book>();
    }

    public void printAddress() {
        System.out.println(Address);
    }

    private void addBook(Book NewBook) {
        Books.add(NewBook);
    }

    private void borrowBook(String BookName) {
        for (Book book : Books) {
            String name = book.getTitle();

            /* Find the book */
            if (Objects.equals(BookName, name)) {
                /* The book is not borrowed */
                if (!book.isBorrowed()) {
                    book.borrowed();
                    System.out.println("You successfully borrowed " + BookName);
                } else {
                    System.out.println("Sorry, the book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Sorry, the book is not in our catalog.");
    }

    public void printAvailableBooks() {
        int count = 0;
        for (Book book : Books) {
            if (!book.isBorrowed()) {
                System.out.println(book.getTitle());
                count++;
            }
        }
        /* Print extra info if not book is available */
        if (count == 0) {
            System.out.println("No book in catalog");
        }
    }

    private void returnBook(String BookName) {
        for (Book book : Books) {
            String name = book.getTitle();

            if (Objects.equals(BookName, name) || book.isBorrowed()) {
                book.returned();
                System.out.println("You successfully returned " + BookName);
                return;
            }
        }
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from " + StartTime + "am to " + CloseTime + "pm.");
    }

    

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 