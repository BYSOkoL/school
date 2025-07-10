package school.sorokin.javacore.oop;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Publication> publications = new ArrayList<>();
    private boolean searched = false;
    public void addPublication(Publication pub) {
        if (!publications.contains(pub)) {
            publications.add(pub);
            Publication.setPublicationCount(publications.size());
        } else {
            System.out.println("Данная публикация уже внесена.");
        }
    }
    public void listPublications() {
        if (publications.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println(publications.toString()); // не красиво
        }
    }
    public void searchByAuthor(String author) {
        for (Publication pub : publications) {
            if (pub.getAuthor().equals(author)) {
                System.out.println(pub.toString());
                searched = true;
            }
        }
        if (!searched) {
            System.out.println("Не найдено.");
        }
    }

}
