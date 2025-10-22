package school.sorokin.javacore.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> catalog = new ArrayList<Book>();

    public void addBook(String title, String author, int copies) {
        Book existing = findBook(title, author);
        if (existing != null) {
            existing.addCopies(copies);
        } else {
            Book book = new Book(title, author, copies);
            catalog.add(book);
        }
    }

    public void takeBook(String title) throws ItemNotFoundException, NoAvailableCopiesException {
        Book book = findBookByTitle(title);
        if (book == null) {
            throw new ItemNotFoundException("Книга не найдена в каталоге.");
        }
        if (book.getAvailableCopies() == 0) {
            throw new NoAvailableCopiesException("Нет доступных экземпляров книги");
        }
        book.decrementCopies();
    }

    public void returnBook(String title) throws ItemNotFoundException {
        Book book = findBookByTitle(title);
        if (book == null) {
            throw new ItemNotFoundException("Книга не найдена в каталоге.");
        }
        book.incrementCopies();
    }

    public List<Book> listBooks() {
        return catalog; //или копию?
    }

    private Book findBook(String title, String author) {
        for (Book b : catalog) {
            if (b.getTitle().equalsIgnoreCase(title.trim()) &&
                    b.getAuthor().equalsIgnoreCase(author.trim())) {
                return b;
            }
        }
        return null;
    }

    private Book findBookByTitle(String title) {
        for (Book b : catalog) {
            if (b.getTitle().equalsIgnoreCase(title.trim())) {
                return b;
            }
        }
        return null;
    }
}