//Создать список типа ArrayList<String>.
// Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.

package lesson3.hw3;

import java.util.ArrayList;
import java.util.List;

public class Homework4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("string", "6", "hi", "5", "10", "-12", "my_value", "6578", "-361573", "dog", "cat"));
        ArrayList<String> list_new = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            boolean isNum = true;
            isNum = (list.get(i)).matches("-?\\d+");
            if (!isNum ) {
                list_new.add(list.get(i));
            }
        }
        System.out.println(list_new);
    }
}
