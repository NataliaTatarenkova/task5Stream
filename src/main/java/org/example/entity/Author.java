package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Author {
    private String name;
    private short age;
    private List<Book> books;
    public Author(String name, short age){
        this.age = age;
        this.name = name;
    }

    /*public static List<Author> getAuthors(int count){
        List<Author> authors = new ArrayList<>();
        Supplier<List<Book>> createBooks = () -> {
            List<Book> books1 = new ArrayList<>();
            for (int i = 0; i < Math.random() * 6; i++) {
                books1.add(new Book("book" + i, (int) (Math.random() * 500)));
            }
            return books1;
        };
        for (int i = 0; i < count; i++) {
         authors.add(new Author("author" + i, (short) (Math.random() * 50), createBooks));
        }
        return authors;
    }*/
}

