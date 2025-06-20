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
     * Add a new book to the database
     */
    public Book addBook(Book book) {
        return bookDAO.insertBook(book);
    }

    /**
     * Get a book by ISBN
     */
    public Book getBookByIsbn(int isbn) {
        return bookDAO.getBookByIsbn(isbn);
    }
}
