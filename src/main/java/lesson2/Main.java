package lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
//            test();
//        ex1();
//        ex2_1();
//        ex2_2();
        ex5("C:\\Users\\Doctor\\Documents\\GeekBrains\\java_projects\\untitled");

    }

    private static void test() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append("i: ").append(i).append(" -> ").append((char) i).append(System.lineSeparator());
        }
        System.out.println(sb);
    }


    private static void ex1() {
        char firstSymbol = 'A';
        char secondSymbol = 'B';
        StringBuilder sb = new StringBuilder();
        int n = 7;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb.append(firstSymbol);
            } else {
                sb.append(secondSymbol);
            }
        }
        System.out.println(sb);
    }

    //    Напишите метод, который сжимает строку.
//    Пример: вход aaaabbbcdd.
    private static void ex2_1() {
        String longString = "aaaabbbcdd";
        StringBuilder shortStringSB = new StringBuilder();
        char prev = longString.charAt(0);
        char curr = prev;
        int counter = 1;

        for (int i = 1; i < longString.length(); i++) {
            prev = longString.charAt(i - 1);
            curr = longString.charAt(i);
            if (prev != curr) {
                shortStringSB.append(prev);
                shortStringSB.append((counter > 1) ? counter : "");
                counter = 0;
            }
            counter++;
        }
        shortStringSB.append(curr);
        shortStringSB.append((counter > 1) ? counter : "");

        System.out.printf("%s -> %s%n", longString, shortStringSB);
    }

    private static void ex2_2() {
        String longString = "aaaabbbcdd";
        StringBuilder shortStringSB = new StringBuilder();
        char[] charStringArr = longString.toCharArray();
        char curr = 0;
        char next = 0;
        int counter = 0;

        for (int i = 0; i < charStringArr.length - 1; i++) {
            counter++;
            curr = charStringArr[i];
            next = charStringArr[i + 1];
            if (curr != next) {
                shortStringSB.append(curr);
                shortStringSB.append((counter > 1) ? counter : ""); //тернарный опертор ? если : то
                counter = 0;

            }
        }
        shortStringSB.append(next);
        shortStringSB.append((counter >= 1) ? counter + 1 : "");


        System.out.printf("%s -> %s%n", longString, shortStringSB);
    }


    private static void ex5(String PathDir) {
        File file = new File(PathDir);
        if (!file.isDirectory()) {
            return; // Метод вернет содержимое папки в виде массива строк
        }

        String[] dirListNames = file.list();

        StringBuilder sb = new StringBuilder();
        for (String fileName : dirListNames) {
            sb.append(fileName).append(System.lineSeparator());
        }
        try(PrintWriter pw = new PrintWriter("src/main/resources/files/output.txt")) {
            pw.print(sb);
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

};