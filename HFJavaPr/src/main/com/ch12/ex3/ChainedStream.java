package main.com.ch12.ex3;

import java.util.List;
import java.util.stream.Collectors;

public class ChainedStream {
    public static void main(String[] args) {

        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        List<String> result = strings.stream()
                                     .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                                     .limit(4)
                                     .collect(Collectors.toList());
        System.out.println(result);

        List<String> result1 = strings.stream()
                                      .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                                      .skip(2)
                                      .limit(4)
                                      .collect(Collectors.toList());
        System.out.println(result1);

    }
}