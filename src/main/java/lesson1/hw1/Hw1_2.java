// Дан массив nums = [3,2,2,3] и число val = 3.
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

package lesson1.hw1;

public class Hw1_2 {
    public static void main(String[] args) {
        int val = 3;
        int[] nums = {3, 2, 2, 3};
        int[] arr = nums;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        numToEnd(nums, arr, val);
    }

    public static void numToEnd(int[] a, int[] b, int k) {
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] != k) {
                a[j] = b[i];
                j++;
            }
        }
        for (int i = j; i < a.length; i++) {
            a[i] = k;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
