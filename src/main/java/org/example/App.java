package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.example.collector.AuthorCollector;
import org.example.entity.Author;
import org.example.entity.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        List<Book> books = Book.getBooks(9);
        List<Author> authors = books.stream().map(Book::getAuthors).collect(AuthorCollector.toList());
        //task1();
    }

    public static void task1() {
        List<Book> books = Book.getBooks(9);
        //проверьте, не содержит ли какая-либо книга (или все книги) более 200 страниц
        System.out.println("Количество книг, которые содеражат больше 200 стр " + books.stream().filter(b -> b.getNumberOfPages() > 200).count());
        //найдите книги с максимальным и минимальным количеством страниц
        Optional<Book> bookOptional =  books.stream().min(Comparator.comparingInt(Book::getNumberOfPages));
        System.out.println(bookOptional.map(book -> "Min " + book.getName() + " " + book.getNumberOfPages()).orElse("Нет минимума"));
        System.out.println("Max " + books.stream().max(Comparator.comparingInt(Book::getNumberOfPages)).get());
        //отфильтруйте книги, в которых указан только один автор
        System.out.println("Книги, в которых один автор " + books.stream().filter(b -> b.getAuthors().size() == 1).map(b -> b.getName()).collect(
                Collectors.toList()));
        //отсортируйте книги по количеству страниц/названию
        //получите список всех названий и выведите их на печать с помощью метода forEach
        System.out.println("Сортировка по количеству страниц/названию: ");
        books.stream().sorted(Comparator.comparingInt(Book::getNumberOfPages)).forEach(b -> System.out.println(b.getName() + " " + b.getNumberOfPages()));
        //получите список всех авторов
        System.out.println("Список всех авторов: ");
        books.stream().peek(b -> System.out.println(b.getName() + ": ")).flatMap(b -> b.getAuthors().stream()).forEach(a -> System.out.println(a.getName()));
    }
}
