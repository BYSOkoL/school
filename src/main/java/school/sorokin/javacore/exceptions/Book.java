package school.sorokin.javacore.exceptions;

public class Book {
    private final String title;
    private final String author;
    private int availableCopies;

    public Book(String title, String author, int availableCopies) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void incrementCopies() {
        availableCopies++;
    }

    public void addCopies(int count) {
        if (count > 0) {
            availableCopies += count;
        }
    }

    public void decrementCopies() {
        if (availableCopies > 0) {
            availableCopies--;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", availableCopies=" + availableCopies +
                '}';
    }
}