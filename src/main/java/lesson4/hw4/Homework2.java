//2. Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод, который вернет “перевернутый” список.

package lesson4.hw4;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Homework2 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> randomLinkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            randomLinkedList.add(random.nextInt(100));
        }

        System.out.println("Random LinkedList: " + randomLinkedList.toString());

        List<Integer> RevertLinkedList = new LinkedList<>();

        for (int i = randomLinkedList.size() - 1; i >= 0; i--) {
            RevertLinkedList.add(randomLinkedList.get(i));
        }

        System.out.println("Revert LinkedList: " + RevertLinkedList.toString());

    }
}
