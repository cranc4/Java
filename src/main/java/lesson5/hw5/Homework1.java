// Реализуйте структуру телефонной книги с помощью HashMap,
// учитывая, что 1 человек может иметь несколько телефонов.

package lesson5.hw5;

import java.util.*;

public class Homework1 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Виктор", List.of("89214562244", "3255634"));
        phoneBook.put("Анатолий", List.of("89119453809"));
        phoneBook.put("Ирина", List.of("89326540855", "89318646789"));
        phoneBook.put("Сергей", List.of("89651236745"));
        phoneBook.put("Артем", List.of("89117583009"));

        menu(phoneBook);
    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static void find(Map<String, List<String>> phoneBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phoneBook.get(name));
    }

    public static void allPhoneBook(Map<String, List<String>> phoneBook) {
        System.out.println(phoneBook);
    }

    public static Map<String, List<String>> add(Map<String, List<String>> phoneBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер:(Для выхода нажмите 'exit') ");
            String phone = scanner();
            if (phone.equals("exit")) {
                break;
            } else {
                number.add(phone);
            }
        }
        phoneBook.put(name, number);
        return phoneBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phoneBook) {
        System.out.println("Для навигации используйте команды: \n" +
                " find - найти контакт\n" +
                " add - добавить контакт\n" +
                " all - показать всю телефонную книгу\n" +
                " exit - выйти\n");
        while (true) {
            String commands = scanner();
            if (commands.equals("exit")) {
                break;
            } else {
                switch (commands) {
                    case "find":
                        find(phoneBook);
                        break;
                    case "add":
                        add(phoneBook);
                        break;
                    case "all":
                        allPhoneBook(phoneBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phoneBook;
    }
}
