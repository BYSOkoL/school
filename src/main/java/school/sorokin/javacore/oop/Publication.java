package school.sorokin.javacore.oop;

import java.util.Objects;

public abstract class Publication implements Printable {
    private String title;
    private String author;
    private int year;
    private static int publicationCount = 0;
    protected Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public abstract String getType();
    public static int getPublicationCount() {
        return publicationCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static void setPublicationCount(int publicationCount) {
        Publication.publicationCount = publicationCount;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return year == that.year && Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
