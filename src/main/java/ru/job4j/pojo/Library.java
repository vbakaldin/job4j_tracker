package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("The Old Man and the Sea", 127);
        books[1] = new Book("Eleanor Oliphant Is Completely Fine", 336);
        books[2] = new Book("Clean code", 500);
        books[3] = new Book("Atomic Habits", 320);

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPageCount());
        }

        Book book = books[0];
        books[0] = books[3];
        books[3] = book;

        for (int index = 0; index < books.length; index++) {
            book = books[index];
            if (book.getName() == "Clean code") {
                System.out.println(book.getName() + " - " + book.getPageCount());
            }
        }
    }
}
