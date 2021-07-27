package de.ausy.bufs.javahappen;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemoizerTest {

    private final Memoizer<Double, Double> underTest = new Memoizer<>();

    @Test
    public void memoizedFunctionIsFasterForFahrenheitToCelsius() {
        // Arrange
        // Fahrenheit ->  Celsius
        Function<Double, Double> fahrenheitToCelsius
                = x -> (x - 32) * 5/9;
        Function<Double, Double> fahrenheitToCelsiusMemoized = underTest.memoize(fahrenheitToCelsius);

        Stream<Double> fahrenheits0 = Stream.iterate(0, n -> n + 1).limit(200000).map(x -> x.doubleValue()/1000);
        Stream<Double> fahrenheits1 = Stream.iterate(0, n -> n + 1).limit(200000).map(x -> x.doubleValue()/1000);
        Stream<Double> fahrenheits2 = Stream.iterate(0, n -> n + 1).limit(200000).map(x -> x.doubleValue()/1000);
        Stream<Double> fahrenheits3 = Stream.iterate(0, n -> n + 1).limit(200000).map(x -> x.doubleValue()/1000);

        // Act
        LocalDateTime begin = LocalDateTime.now();
        List<Double> l0 = fahrenheits0.map(fahrenheitToCelsiusMemoized).collect(Collectors.toList());
        LocalDateTime end = LocalDateTime.now();

        LocalDateTime begin1 = LocalDateTime.now();
        List<Double> l1 = fahrenheits1.map(fahrenheitToCelsiusMemoized).collect(Collectors.toList());
        LocalDateTime end1 = LocalDateTime.now();

        LocalDateTime begin2 = LocalDateTime.now();
        List<Double> l2 = fahrenheits2.map(fahrenheitToCelsius).collect(Collectors.toList());
        LocalDateTime end2 = LocalDateTime.now();

        LocalDateTime begin3 = LocalDateTime.now();
        List<Double> l3 = fahrenheits3.map(fahrenheitToCelsius).collect(Collectors.toList());
        LocalDateTime end3 = LocalDateTime.now();

        // Assert
        long firstMemoized = Duration.between(begin, end).getNano();
        long secondMemoized = Duration.between(begin1, end1).getNano();
        long firstPure = Duration.between(begin2, end2).getNano();
        long secondPure = Duration.between(begin3, end3).getNano();

        long fasterPercent = 100 * secondMemoized/firstMemoized;
        long faster = firstMemoized - secondMemoized;

        long fasterPercent2 = 100 * secondPure/firstPure;
        long faster2 = firstPure - secondPure;

        System.out.println("the second run of the pure version     is " + fasterPercent2 + "% (" + faster2  + " nanos = " + firstPure     + " - " + secondPure     + ")   faster than the first run");
        System.out.println("the second run of the memoized version is "     + fasterPercent  + "% (" + faster   + " nanos = " + firstMemoized + " - " + secondMemoized + ") faster than the first run");
    }
}