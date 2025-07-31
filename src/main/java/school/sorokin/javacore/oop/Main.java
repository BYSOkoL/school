package school.sorokin.javacore.oop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int choice;
        while (true) {
            System.out.println("""
                     1. Добавить новую публикацию.
                     2. Вывести список всех публикаций.
                     3. Поиск публикации по автору.
                     4. Вывести общее количество публикаций (используя статический метод).
                     0. Выход.
                    """);
            while (true) {
                System.out.println("Выберите номер необходимого пункта");
                if (!sc.hasNextInt()) {
                    System.out.println("Неверный ввод. Пожалуйста, введите число.");
                    sc.next();
                    continue;
                }
                choice = sc.nextInt();
                // sc.nextLine();
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Выберите тип публикации: 1 - Book, 2 - Magazine, 3 - Newspaper");
                    int type = sc.nextInt();
                    if (type != 1 && type != 2 && type != 3) {
                        System.out.println("Выберите вариант 1, 2 или 3");
                        break;
                    }
                    sc.nextLine();
                    System.out.println("Ведите название :");
                    String title = sc.nextLine();
                    if (title.trim().isBlank()) {
                        System.out.println("Не может быть пустым");
                        break;
                    }
                    System.out.println("Введите автора :");
                    String author = sc.nextLine();
                    if (author.trim().isBlank()) {
                        System.out.println("Не может быть пустым");
                        break;
                    }
                    System.out.println("Введите год :");
                    int year = 0;
                    if (sc.hasNextInt()) {
                        year = sc.nextInt();
                    } else {
                        System.out.println("Введите число");
                        continue;
                    }
                    if (type == 1) {
                        System.out.println("ISBN: ");
                        String isbn = sc.next();
                        Publication publication = new Book(title, author, year, isbn);
                        lib.addPublication(publication);
                    } else if (type == 2) {
                        System.out.println("issueNumber: ");
                        if (sc.hasNextInt()) {
                            int issueNumber = sc.nextInt();
                            sc.nextLine();
                            Publication publication = new Magazine(title, author, year, issueNumber);
                            lib.addPublication(publication);
                        } else {
                            System.out.println("Введите число");
                        }
                    } else if (type == 3) {
                        System.out.println("publicationDay: ");
                        String publicationDay = sc.next();
                        Publication publication = new Newspaper(title, author, year, publicationDay);
                        lib.addPublication(publication);
                    }
                    break;

                case 2: {
                    lib.listPublications();
                    break;
                }
                case 3: {
                    System.out.println("Автор: ");
                    String authorSearch = sc.nextLine();
                    lib.searchByAuthor(authorSearch);
                    break;
                }

                case 4: {
                    if (Publication.getPublicationCount() != 0) {
                        System.out.println(Publication.getPublicationCount());
                    } else {
                        System.out.println("Публикаций нет.");
                    }
                    break;
                }

                case 0:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Неверный пункт меню");
            }
        }
    }
}
