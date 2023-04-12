// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.

package lesson3.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Homework2 {
    public static List<Integer> getRandomList(int size) {

        Random random = new Random();
        List<Integer> randomList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            randomList.add(random.nextInt(100));
        }

        System.out.println(randomList.toString());
        return randomList;
    }
    public static void main(String[] args) {
        getRezult(getRandomList(20));
    }
    public static void getRezult(List<Integer> list) {
        int min = Collections.min(list);
        int max = Collections.max(list);
        int count = list.size();
        int sum = 0;

        for (Integer i : list) {
            sum += i;
        }

        double average = sum / count;

        System.out.printf(" Min value: %d\n Max value: %d\n Average value: %f", min, max, average);

    }



}
