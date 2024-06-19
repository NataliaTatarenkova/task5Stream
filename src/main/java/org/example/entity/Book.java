package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {
    private String name;
    private List<Author> authors;
    private int numberOfPages;

    public Book(String name, int numberOfPages, Supplier createAuthors) {
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.authors = (List<Author>) createAuthors.get();
    }

    public static List<Book> getBooks(int count){
        List<Book> authors = new ArrayList<>();
        Supplier<List<Author>> createAuthors = () -> {
            List<Author> authorList = new ArrayList<>();
            for (int i = 0; i < Math.random() * 6; i++) {
                authorList.add(new Author("author" + i, (short) (Math.random() * 50)));
            }
            return authorList;
        };
        for (int i = 0; i < count; i++) {
            authors.add(new Book("book" + i, (int) (Math.random() * 500), createAuthors));
        }
        return authors;
    }
}
