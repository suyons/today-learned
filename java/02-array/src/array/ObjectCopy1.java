package array;

public class ObjectCopy1 {
    public static void main(String[] args) {
        Book[] bookArray1 = new Book[3];
        Book[] bookArray2 = new Book[3];

        bookArray1[0] = new Book("책1", "작가1");
        bookArray1[1] = new Book("책2", "작가2");
        bookArray1[2] = new Book("책3", "작가3");
        System.arraycopy(bookArray1, 0, bookArray2, 0, 3);

        for (Book book : bookArray2) {
            book.showBookInfo();
        }
    }
}
