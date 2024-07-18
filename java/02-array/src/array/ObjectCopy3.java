package array;

public class ObjectCopy3 {
    public static void main(String[] args) {
        Book[] bookArray1 = new Book[3];
        Book[] bookArray2 = new Book[3];

        bookArray1[0] = new Book("책1", "작가1");
        bookArray1[1] = new Book("책2", "작가2");
        bookArray1[2] = new Book("책3", "작가3");

        bookArray2[0] = new Book();
        bookArray2[1] = new Book();
        bookArray2[2] = new Book();

        for (int i = 0; i < bookArray1.length; i++) {
            bookArray2[i].setBookName(bookArray1[i].getBookName());
            bookArray2[i].setAuthor(bookArray1[i].getAuthor());
        }

        for (Book book : bookArray2) {
            book.showBookInfo();
        }

        System.out.println("=== bookArray1 ===");
        bookArray1[0].setBookName("책4");
        bookArray1[0].setAuthor("작가4");
        for (Book book : bookArray1) {
            book.showBookInfo();
        }

        System.out.println("=== bookArray2 ===");
        for (Book book : bookArray2) {
            book.showBookInfo();
        }
    }
}
