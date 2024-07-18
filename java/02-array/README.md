# 배열

## 객체 배열

```java
package array;

public class Book {
    private String bookName;
    private String author;

    public Book() {
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void showBookInfo() {
        System.out.println(bookName + ", " + author);
    }
}
```

```java
package array;

public class BookArray {
    public static void main(String[] args) {
        Book[] library = new Book[5];

        for (Book book : library) {
            System.out.println(book);
        }
    }
}
```

```
null
null
null
null
null
```

```java
package array;

public class BookArray2 {
    public static void main(String[] args) {
        Book[] library = new Book[5];

        library[0] = new Book("책1", "작가1");
        library[1] = new Book("책2", "작가2");
        library[2] = new Book("책3", "작가3");
        library[3] = new Book("책4", "작가4");
        library[4] = new Book("책5", "작가5");

        for (Book book : library) {
            book.showBookInfo();
        }
        for (Book book : library) {
            System.out.println(book);
        }
    }
}
```

```
책1, 작가1
책2, 작가2
책3, 작가3
책4, 작가4
책5, 작가5
array.Book@659e0bfd
array.Book@2a139a55
array.Book@15db9742
array.Book@6d06d69c
array.Book@7852e922
```

## 배열 복사하기

`System.arraycopy(src, srcPos, dest, destPos, length)`

```java
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
```

```
1
10
20
30
40
```

## 객체 배열 복사하기

```java
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
```

```
책1, 작가1
책2, 작가2
책3, 작가3
```

## 얕은 복사

객체 배열을 복사할 때 인스턴스를 따로 생성하는 게 아니라 기존 인스턴스의 주소 값만 복사한다.

```java
package array;

public class ObjectCopy2 {
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

        System.out.println("=== bookArray1 ===");
        bookArray1[0].setBookName("책4");
        bookArray2[0].setAuthor("작가4");
        for (Book book : bookArray1) {
            book.showBookInfo();
        }

        System.out.println("=== bookArray2 ===");
        for (Book book : bookArray2) {
            book.showBookInfo();
        }
    }
}
```

```
책1, 작가1
책2, 작가2
책3, 작가3
=== bookArray1 ===
책4, 작가4
책2, 작가2
책3, 작가3
=== bookArray2 ===
책4, 작가4
책2, 작가2
책3, 작가3
```

## 깊은 복사

직접 인스턴스를 만들고 그 값을 복사한다.

기존 배열의 요소 값이 변경되어도 영향을 받지 않는다.

```java
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
```

```
책1, 작가1
책2, 작가2
책3, 작가3
=== bookArray1 ===
책4, 작가4
책2, 작가2
책3, 작가3
=== bookArray2 ===
책1, 작가1
책2, 작가2
책3, 작가3
```

## 이차원 배열

### 연습하기

알파벳 소문자를 2글자씩 13줄(13행 2열)로 출력하는 프로그램을 이차원 배열로 구현해 보세요.

```java
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
```

```
ab
cd
ef
gh
ij
kl
mn
op
qr
st
uv
wx
yz
```

# 출처

[Do it! 자바 프로그래밍 입문](https://www.yes24.com/Product/Goods/62281686)

2024-07-18 17:51:38