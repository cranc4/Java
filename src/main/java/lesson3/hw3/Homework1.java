// Пусть дан произвольный список целых чисел, удалить из него четные числа

package lesson3.hw3;

import java.util.ArrayList;
import java.util.Random;
public class Homework1 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(100);
            list1.add(val);
        }
        System.out.printf("Initial list: %s\n", list1);
        int i = 0;
        while (i < list1.size()) {
            if (list1.get(i) % 2 == 0) {
                list1.remove(i);
            }
            else {
                i++;
            }
        }
        System.out.printf("List without even numbers: %s", list1);
    }
}
