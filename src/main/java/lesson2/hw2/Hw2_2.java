// Напишите метод, который составит строку, состоящую из 100 повторений слова TEST
// и метод, который запишет эту строку в простой текстовый файл, обработайте исключения.

package lesson2.hw2;

import java.io.IOException;
import java.io.FileOutputStream;

public class Hw2_2 {
    public static void main(String[] args) {
        Hw2_2 hw22 = new Hw2_2();
        hw22.writer();
    }

    public StringBuilder generateString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TEST ".repeat(100));
        return sb;
    }

    public void writer() {
        try {
            FileOutputStream test = new FileOutputStream("test.txt");
            test.write(generateString().toString().getBytes());
            test.close();
        } catch (IOException e) {
            System.out.println("Проблема вывода!");
            e.printStackTrace();
        }
    }
}