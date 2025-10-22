package school.sorokin.javacore.exceptions;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Library library = new Library();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu();
                int choice = readChoice(scanner);
                switch (choice) {
                    case 1:
                        getAllBooks();
                        break;
                    case 2:
                        takeBook(scanner);
                        break;
                    case 3:
                        returnBook(scanner);
                        break;
                    case 4:
                        addBook(scanner);
                        break;
                    case 5:
                        System.out.println("Выход из приложения. До свидания!");
                        running = false;
                        break;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Посмотреть список всех доступных книг.");
        System.out.println("2. Выдать (арендовать) книгу, если она есть в наличии.");
        System.out.println("3. Вернуть (освободить) книгу.");
        System.out.println("4. Добавить новую книгу в систему.");
        System.out.println("5. Выйти из приложения.");
        System.out.print("Выберите пункт меню (1-5): ");
    }

    private static int readChoice(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine();
            try {
                int choice = Integer.parseInt(line.trim());
                return choice;
            } catch (NumberFormatException e) {
                System.out.print("Неверный ввод. Введите число от 1 до 5: ");
            }
        }
    }

    private static void getAllBooks() {
        List<Book> books = library.listBooks();
        System.out.println();
        if (books.isEmpty()) {
            System.out.println("Каталог пуст.");
        } else {
            System.out.println("Книги в каталоге:");
            System.out.println(books);
        }
    }

    private static void takeBook(Scanner scanner) {
        System.out.print("Введите название книги для выдачи: ");
        String title = scanner.nextLine();
        try {
            library.takeBook(title);
            System.out.println("Книга выдана.");
        } catch (ItemNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NoAvailableCopiesException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Введите название книги для возврата: ");
        String title = scanner.nextLine();
        if (title.trim().isBlank()) {
            System.out.println("Не может быть пустым");
            return;
        }
        try {
            library.returnBook(title);
            System.out.println("Книга: успешно возвращена.");
        } catch (ItemNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Название книги: ");
        String title = scanner.nextLine();
        if (title.trim().isBlank()) {
            System.out.println("Не может быть пустым");
            return;
        }
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        if (author.trim().isBlank()) {
            System.out.println("Не может быть пустым");
            return;
        }

        int copies = 0;
        while (true) {
            System.out.print("Количество копий: ");
            String line = scanner.nextLine();
            try {
                copies = Integer.parseInt(line.trim());
                if (copies <= 0) {
                    System.out.println("Не верное число. Повторите ввод.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод.");
            }
        }
        library.addBook(title, author, copies);
        System.out.println("Книга добавлена.");
    }
}
