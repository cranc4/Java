package lesson1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        inputNameAndPrint(); // название метода
        size2();
    }

    private static void inputNameAndPrint() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.printf("Hello, %s!", name);
        scanner.close();
    }

    //    2. Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.
    private static void size2() {
        int[] arr = new int[]{1, 1, 0, 1, 1, 1};
        int k = 0;
        int kmax = 0;
        for (int num : arr) {
            if (num == 1) {
                k++;
                if (k > kmax) {
                    kmax = k; //счетчик
                }
            } else {
                k = 0;
            }
        }
        System.out.printf("Большая последовательность: %s", kmax);
    }
}
