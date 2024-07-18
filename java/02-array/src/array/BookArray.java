package array;

public class BookArray {
    public static void main(String[] args) {
        Book[] library = new Book[5];

        for (Book book : library) {
            System.out.println(book);
        }
    }
}
