package de.ausy.bufs.javahappen;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rest {

    void x(){
        Function<Integer, Integer> plusEins = x -> x + 1;

        // Stream::map ist ein Beispiel für eine Methode die eine Function aufnimmt
        Function<Integer, String> kundenNamenGeneration = x -> "Kunde" + x;

        // ?
        Consumer<String> printer = x -> System.out.println(x);

        // ...
        Predicate<String> aSearcher = x -> x.contains("A");
        Function<String, Boolean> aSearcherAsFunction = x -> x.contains("A");

        List<String> kundenNamen = Stream.of(100).map(kundenNamenGeneration).collect(Collectors.toList());
        List<String> kundenNamen1 = Stream.of(100).map(x -> "Kunde" + x).collect(Collectors.toList());

        Stream.of(100).forEach(x -> System.out.println(x));
    }
}
