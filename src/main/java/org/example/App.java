package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        task3(generateStrings());
    }

    public static void task3(List<String> strings) {
        Map<String, Long> result = strings.stream().flatMap(s -> Arrays.stream(s.split(" "))).map(s -> s.replaceAll(",", "").replaceAll("\\.", "").replaceAll("!", "").replaceAll(":", ""))
                                      //.peek(System.out::println)
                .filter(s -> s.length() > 4).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        result.entrySet().stream().filter(m -> m.getValue() > 5).sorted(Map.Entry.comparingByValue()).forEach(map -> System.out.println(map.getKey() + " - " + map.getValue()));

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

    public static List<String> generateStrings() {
        List<String> strings = new ArrayList<>();
        strings.add("Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик");
        strings.add("Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик, Котик");
        strings.add("Жил-был старик со старухою. Просит старик: «Испеки, старуха, колобок». – «Из чего печь-то? Муки нету». – «Э-эх, старуха! По коробу поскреби, по сусеку помети; авось муки и наберется».");
        strings.add("Взяла старуха крылышко, по коробу поскребла, по сусеку помела, и набралось муки пригоршни с две. Замесила на сметане, изжарила в масле и положила на окошечко постудить.");
        strings.add("Колобок полежал-полежал, да вдруг и покатился – с окна на лавку, с лавки на пол, по полу да к дверям, перепрыгнул через порог в сени, из сеней на крыльцо, с крыльца на двор, со двора за ворота, дальше и дальше.");
        strings.add("Катится колобок по дороге, а навстречу ему заяц: «Колобок, колобок! Я тебя съем». – «Не ешь меня, косой зайчик! Я тебе песенку спою», – сказал колобок и запел:");
        return strings;
    }
}
