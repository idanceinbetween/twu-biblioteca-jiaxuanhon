package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("sunFall");
        String title = book.getTitle();
        System.out.println(title);
    }
}
