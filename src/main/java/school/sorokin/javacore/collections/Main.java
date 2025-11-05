package school.sorokin.javacore.collections;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactBook contacts = new ContactBook();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    addContact();
                    break;
                case "2":
                    removeContact();
                    break;
                case "3":
                    contacts.printAll();
                    break;
                case "4":
                    searchContact();
                    break;
                case "5":
                    printContactsByGroup();
                    break;
                case "0":
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Неверный пункт меню.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("1 - Добавить контакт.");
        System.out.println("2 - Удалить контакт.");
        System.out.println("3 - Посмотреть контакты.");
        System.out.println("4 - Найт контакт.");
        System.out.println("5 - Посмотреть контакты по группе.");
        System.out.println("0 - Выход.");
    }

    private static String readInput(String text) {
        while (true) {
            System.out.print(text);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Поле пустое.");
        }
    }

    private static void addContact() {
        String name = readInput("Имя: ");
        String phone = readInput("Телефон: ");
        String email = readInput("Email: ");
        String group = readInput("Группа: ");

        if (contacts.add(new Contact(name, phone, email, group))) {
            System.out.println("Контакт добавлен.");
        } else {
            System.out.println("Контакт существует.");
        }
    }

    private static void removeContact() {
        String name = readInput("Имя: ");
        String phone = readInput("Телефон: ");

        if (contacts.remove(name, phone)) {
            System.out.println("Контакт удалён.");
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    private static void searchContact() {
        System.out.println("1 - По имени");
        System.out.println("2 - По телефону");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                String name = readInput("Имя: ");
                List<Contact> results = contacts.findByName(name);

                if (results.isEmpty()) {
                    System.out.println("Не найдено.");
                } else {
                    for (Contact contact : results) {
                        System.out.println(contact);
                    }
                }
                break;

            case "2":
                String phone = readInput("Телефон: ");
                Contact contact = contacts.findByPhone(phone);

                if (contact == null) {
                    System.out.println("Не найдено.");
                } else {
                    System.out.println(contact);
                }
                break;

            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void printContactsByGroup() {
        String group = readInput("Группа: ");
        contacts.printByGroup(group);
    }
}