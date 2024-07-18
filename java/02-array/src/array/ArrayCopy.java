package array;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] array1 = { 10, 20, 30, 40, 50 };
        int[] array2 = { 1, 2, 3, 4, 5 };

        System.arraycopy(array1, 0, array2, 1, 4);
        for (int num : array2) {
            System.out.println(num);
        }
    }
}
