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
        Map<Long, List<String>> result = lines.stream()
                                       .map(String::toLowerCase)
                                       .flatMap(s -> Arrays.stream(s.split("[^a-zа-я]+")))
                                       .filter(s -> s.length() >= 4)
                                              .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                                              .entrySet().stream()
                                              .filter(m -> m.getValue() >= 10).sorted(Map.Entry.comparingByKey())
                                              .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        return result.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                     .map(e ->  e.getValue().stream().map( v -> v + " - " + e.getKey()).collect(Collectors.joining("\n"))).collect(Collectors.joining("\n"));
    }
}
