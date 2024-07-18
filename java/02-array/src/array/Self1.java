package array;

public class Self1 {
    public static void main(String[] args) {
        char[][] arr = new char[13][2];

        for (byte i = 0; i < arr.length; i++) {
            for (byte j = 0; j < arr[i].length; j++) {
                arr[i][j] = (char) ('a' + 2 * i + j);
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
