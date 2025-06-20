package Application.Service;

import Application.DAO.BookDAO;
import Application.Model.Book;

import java.util.List;

public class BookService {
    private BookDAO bookDAO;

    // No-args constructor
    public BookService() {
        this.bookDAO = new BookDAO();
    }

    // Constructor for testing with mock DAO
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     * Retrieve all books from the DAO
     */
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    /**
     * Retrieve available books (copies_available > 0)
     */
    public List<Book> getAllAvailableBooks() {
        return bookDAO.getBooksWithBookCountOverZero();
    }

    /**
     * Add a new book. Returns null if:
     * - input is invalid,
     * - book with the same ISBN already exists,
     * - or DAO insertion fails.
     */
    public Book addBook(Book book) {
        // Validate input
        if (book == null ||
            book.getIsbn() <= 0 ||
            book.getAuthor_id() <= 0 ||
            book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            return null;
        }

        // Check if book with the same ISBN already exists
        Book existing = bookDAO.getBookByIsbn(book.getIsbn());
        if (existing != null) {
            return null; // Don't insert duplicate
        }

        // Attempt to insert
        return bookDAO.insertBook(book);
    }

    /**
     * Get a book by ISBN
     */
    public Book getBookByIsbn(int isbn) {
        return bookDAO.getBookByIsbn(isbn);
    }
}
