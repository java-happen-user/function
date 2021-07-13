import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemoizerTest {

    private final Memoizer<BigDecimal, BigDecimal> underTest = new Memoizer<>();

    @Test
    public void test() {
        // Arrange
        // Fahrenheit ->  Celsius
        Function<BigDecimal, BigDecimal> fahrenheitToCelsius
                = x -> (x.subtract(BigDecimal.valueOf(32))
                .multiply((BigDecimal.valueOf(5).divide(BigDecimal.valueOf(9), 2))));

        // Act
        Function<BigDecimal, BigDecimal> fahrenHeitToCelsiusMemoized
                = underTest.memoize(fahrenheitToCelsius);

        Stream<BigDecimal> fahrenheits
                = Stream.of(BigDecimal.valueOf(212), BigDecimal.valueOf(32));

        List<BigDecimal> celsiuss = fahrenheits.map(fahrenheitToCelsius).collect(Collectors.toList());
        List<BigDecimal> celsiuss2 = fahrenheits.map(fahrenheitToCelsius).collect(Collectors.toList());

        List<BigDecimal> celsiussMemoized = fahrenheits.map(fahrenHeitToCelsiusMemoized).collect(Collectors.toList());
        List<BigDecimal> celsiussMemoized2 = fahrenheits.map(fahrenHeitToCelsiusMemoized).collect(Collectors.toList());

        // Assert
        Assertions.assertTrue(celsiuss.contains(BigDecimal.ZERO));
        Assertions.assertTrue(celsiuss.contains(BigDecimal.valueOf(100)));
    }

    void x (){

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
