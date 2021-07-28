package de.ausy.bufs.javahappen;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XY {

    @Test
    public void x(){
        // y    = (x - 32) * 5/9
        // f(x) = (x - 32) * 5/9
        Function<Double, Double> fahrenheitToCelsius = x -> (x - 32) * 5/9;

        Double result = fahrenheitToCelsius.apply(Double.valueOf(32));

        assertEquals(0.0, result);
    }

    @Test
    public void y(){
        Memoizer<Double, Double> m = new Memoizer<>();
        Function<Double, Double> fahrenheitToCelsius = x -> (x - 32.0) * 5.0/9.0;
        Function<Double, Double> fahrenheitToCelsiusMemoized = m.memoize(fahrenheitToCelsius);

        Stream<Double> fahrenheits0 = Stream.iterate(0, n -> n + 1).limit(200000).map(x -> x.doubleValue()/1000);
        List<Double>  r = fahrenheits0.map(fahrenheitToCelsius).collect(Collectors.toList());




    }
}
