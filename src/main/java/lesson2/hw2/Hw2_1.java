// Напишите метод, который принимает на вход строку (String) и
// определяет является ли строка палиндромом (возвращает boolean значение).

package lesson2.hw2;

import java.util.Scanner;

public class Hw2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(isPalindrome(str));
    }
    private static boolean isPalindrome(String str) {
        String newString = str.toLowerCase().replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        String reversed =new StringBuffer(newString).reverse().toString();
        return reversed.equals(newString);
    }
}
