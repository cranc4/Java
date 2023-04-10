package lesson4;

import java.io.*;
import java.util.*;

public class Main {

    private static Scanner fileScanner;
    private static PrintWriter printWriter;
    private static File file;
    public static void main(String[] args) {
//        ex0();
        ex1();
    }

    private static void ex0() {
        final int SIZE = 100_000;
        Random random = new Random();

        List<Random> linkedList = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(null);
        }
        System.out.println("LinkedList: " + (System.currentTimeMillis() - start));

        List<Random> arrayList = new ArrayList<>(SIZE);
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add( null);
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis() - start));
    }

//    Реализовать консольное приложение, которое:
//    Принимает от пользователя строку вида
//    text~num
//    Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
//    Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

    private static void ex1() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> wordsList = new LinkedList<>();
        Collections.addAll(wordsList, "apple", "orange", "banana", "tomato", "strawberry", "melon");


        while (true) {
            System.out.println();
            System.out.print("Введите строку: ");
            String inputString = in.nextLine();

            if (inputString.trim().length() == 0) {
//            if (inputString.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("каша не вари")) {
                break; // завершение всего цикла
            }
            if (inputString.equalsIgnoreCase("print~all")) {
                printAllNotNullValues(wordsList);
                continue; // IgnoreCase игнорируя регистр
            }
            if (!inputString.contains("~")) {
                System.out.println("Строка не содержит тильду");
                continue;
            }

            String[] parts = inputString.split("\\~"); // проверка на 2 тильды,или не 2 значения

            if (parts.length != 2) {
                System.out.println("Ошибка ввода шаблона. Должно быть \"word~num\". Пример: apple~6");
                continue;
            }

            String word = parts[0];
            int num = 0;

            try {
                num = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Выражение не содержит числа"); // проверка числа после ~
                continue;
            }

            if (num < 1) {
                System.out.println("Введите num более 1");
                continue;
            }

            if (word.equalsIgnoreCase("print")) {
                if (!isNumberInRange(num, wordsList.size()) || valueIsNull(wordsList, num)) {
                    System.out.println("Указанного значения не существует");
                } else {
                    System.out.printf("Под номером %d находится слово: %s%n", num, wordsList.get(num - 1));
                    wordsList.remove(num - 1); // удаляем значение
                }
            } else if (isNumberInRange(num, wordsList.size())) {
                String oldWord = wordsList.get(num - 1);

                if (valueIsNull(wordsList, num)) {
                    printAddMessage(word, num);
                } else {
                    printSetMessage(word, num, oldWord);
                }
                wordsList.set(num - 1, word); // обновляем значение
            } else {
                int nullCount = num - wordsList.size() - 1; // кол-во null
                addNulls(wordsList, nullCount);
                wordsList.add(word);
                printAddMessage(word, num);
            }
        }
    }

    private static void addNulls(LinkedList<String> wordsList, int count) {
        for (int i = 0; i < count; i++) {
            wordsList.add(null);
        }
    }

    private static void printAllNotNullValues(LinkedList<String> wordsList) {
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i) != null) {
                System.out.printf("%d) %s%n", i + 1, wordsList.get(i));
            }
        }
    }

    private static void printSetMessage(String word, int num, String oldWord) {
        System.out.printf("Слово %s заменило на позиции %d слово %s%n", word, num, oldWord);
    }

    private static void printAddMessage(String word, int num) {
        System.out.printf("Слово %s добавлено на позицию %d%n", word, num);
    }

    private static boolean valueIsNull(LinkedList<String> wordsList, int num) {
        return wordsList.get(num - 1) == null;
    }

    private static boolean isNumberInRange(int num, int size) {
        return num >= 1 & num <= size;
    }
}
