package org.example.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Words {

    public String countWords(List<String> lines) {
        Map<String, Long> result = lines.stream().flatMap(s -> Arrays.stream(s.split(" "))).map(String::toLowerCase)
                                        .map(s -> s.replaceAll(",", "").replaceAll("\\.", "").replaceAll("\\[", "").replaceAll("\\'", ""))
                                        .filter(s -> s.length() >= 4)
             .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        Map<Long, List<String>> dd = result.entrySet().stream().filter(m -> m.getValue() > 10).sorted(Map.Entry.comparingByKey())
                                           .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        String st = dd.entrySet().stream().sorted(Map.Entry.comparingByKey((l, l1) -> l1.compareTo(l)))
                       .map(e ->  e.getValue().stream().map( v -> v + " - " + e.getKey()).collect(Collectors.joining("\n"))).collect(Collectors.joining("\n"));
        return st;
    }
}
