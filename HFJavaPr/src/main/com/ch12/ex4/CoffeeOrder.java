package main.com.ch12.ex4;

import java.util.List;
import java.util.stream.Collectors;

/*
    p. 428 코드 자석 문제
 */
public class CoffeeOrder {
    public static void main(String[] args) {
        List<String> coffees = List.of("Cappuccino", "Americano", "Espresso", "Cortado", "Mocha", "Cappuccino", "Flat White", "Latte");

        List<String> coffeesEndingIn0 = coffees.stream()
                                               .filter(s -> s.endsWith("o"))
                                               .sorted()
                                               .distinct()
                                               .collect(Collectors.toList());

        System.out.println(coffeesEndingIn0);
    }
}
