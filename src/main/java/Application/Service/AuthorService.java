package Application.Service;

import Application.Model.Author;
import Application.DAO.AuthorDAO;

import java.util.List;

public class AuthorService {
    private AuthorDAO authorDAO;

    // No-args constructor
    public AuthorService() {
        authorDAO = new AuthorDAO();
    }

    // Constructor for injecting a mock/test DAO
    public AuthorService(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    /**
     * Retrieve all authors from DAO
     */
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    /**
     * Insert new author using DAO
     */
    public Author addAuthor(Author author) {
        return authorDAO.insertAuthor(author);
    }
}
