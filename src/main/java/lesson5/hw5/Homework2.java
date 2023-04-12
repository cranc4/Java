// Написать программу, которая найдёт и выведет повторяющиеся
// имена с количеством повторений. Отсортировать по убыванию популярности.

package lesson5.hw5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Homework2 {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        String people = "Иван Иванов " +
                "Светлана Петрова " +
                "Кристина Белова " +
                "Анна Мусина " +
                "Анна Крутова " +
                "Иван Юрин " +
                "Петр Лыков " +
                "Павел Чернов " +
                "Петр Чернышов " +
                "Мария Федорова " +
                "Марина Светлова " +
                "Мария Савина " +
                "Мария Рыкова " +
                "Марина Лугова " +
                "Анна Владимирова " +
                "Иван Мечников " +
                "Петр Петин " +
                "Иван Ежов ";

        String[] listName = people.split(" ");
        for (int i = 0; i < listName.length; i += 2) {
            if (nameMap.containsKey(listName[i])) {
                nameMap.replace(listName[i], nameMap.get(listName[i]) + 1);
            } else {
                nameMap.put(listName[i], 1);
            }
        }


        Map<String, Integer> sortedNameMap = new LinkedHashMap<>();
        int max = 1;
        for (int value : nameMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
                String key = entry.getKey();
                if (nameMap.get(key) == i) {
                    sortedNameMap.put(key, nameMap.get(key));
                }
            }
        }
        System.out.println(sortedNameMap);
    }

}
