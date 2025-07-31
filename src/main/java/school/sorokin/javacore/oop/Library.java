package school.sorokin.javacore.oop;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Publication> publications;

    public Library() {
        this.publications = new ArrayList<>();
    }

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
            System.out.println(publications); // не красиво
        }
    }
    public void searchByAuthor(String author) {
        boolean searched = false;
        for (Publication pub : publications) {
            if (pub.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(pub);
                searched = true;
            }
        }
        if (!searched) {
            System.out.println("Не найдено.");
        }
    }

}
