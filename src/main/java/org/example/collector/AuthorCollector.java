package org.example.collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.example.entity.Author;

public class AuthorCollector implements Collector<Author, List<Author>, List<Author>> {
    @Override
    public Supplier<List<Author>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Author>, Author> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<Author>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Author>, List<Author>> finisher() {
        return Collections::unmodifiableList;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED);
    }

    public BiConsumer<List<Author>, Author> toList() {
        return List::add;
    }

}
