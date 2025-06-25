package school.sorokin.javacore.basics;

import java.util.Scanner;

public class ProjectBasics {
    public static void main(String[] args) {
        int maxContactsCount = 100;
        String[] names = new String[maxContactsCount];
        String[] phoneNumbers = new String[maxContactsCount];
        int numberOfContacts = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    -----------------------------------
                    Выберите номер необходимого пункта
                    1. Добавить контакт
                    2. Просмотреть контакты
                    3. Найти контакт
                    4. Удалить контакт
                    5. Выйти
                    -----------------------------------
                    """);
            if (!sc.hasNextInt()) {
                System.out.println("Неверный ввод.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    if (numberOfContacts >= maxContactsCount) {
                        System.out.println("Список контактов заполнен");
                        break;
                    }
                    System.out.println("Введите имя");
                    String name = sc.nextLine();

                    if (name.isBlank()) {
                        System.out.println("Строка пуста");
                        break;
                    }
                    System.out.println("Введите номер");
                    String phoneNumber = sc.nextLine();
                    if (phoneNumber.isBlank()) {
                        System.out.println("Строка пуста");
                        names[numberOfContacts] = null;
                        break;
                    }
                    names[numberOfContacts] = name;
                    phoneNumbers[numberOfContacts] = phoneNumber;
                    System.out.println("Контакт добавлен");
                    numberOfContacts++;
                    break;
                }
                case 2:
                    if (names[0] == null) {
                        System.out.println("контакты отсутствуют");
                        break;
                    }
                    System.out.println("Контакты: ");
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null) {
                            System.out.println(names[i] + " - " + phoneNumbers[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Введите имя контакта для поиска");
                    boolean contactDetected = false;
                    int detectedNumber = 0;
                    String name = sc.nextLine();
                    if (name.isBlank()) {
                        System.out.println("Строка пуста");
                        break;
                    }
                    for (int i = 0; i < names.length; i++) {
                        if (name.equalsIgnoreCase(names[i])) {
                            contactDetected = true;
                            detectedNumber = i;
                            break;
                        }
                    }
                    if (contactDetected) {
                        System.out.println("Телефон " +  names[detectedNumber] + " - " + phoneNumbers[detectedNumber]);
                    } else {
                        System.out.println("Контакт не найден");
                    }
                    break;

                case 4:
                    System.out.println("Введите имя контакта для удаления");
                    String deleteName = sc.nextLine();
                    boolean deleteDetected = false;
                    if (deleteName.isBlank()) {
                        System.out.println("Строка пуста");
                        break;
                    }
                    for (int i = 0; i < names.length; i++) {
                        if (deleteName.equalsIgnoreCase(names[i])) {
                            for (int j = i; j < names.length - 1; j++) {
                                names[j] = names[j + 1];
                                phoneNumbers[j] = phoneNumbers[j + 1];
                            }
                            phoneNumbers[phoneNumbers.length - 1] = null;
                            names[names.length - 1] = null;
                            numberOfContacts--;
                            deleteDetected = true;
                            break;
                        }
                    }
                    if (deleteDetected) {
                        System.out.println("Контакт: " + deleteName + " удалён.");
                    } else {
                        System.out.println("Контакт не найден");
                    }
                    break;
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Неверный пункт меню");
            }
        }
    }
}