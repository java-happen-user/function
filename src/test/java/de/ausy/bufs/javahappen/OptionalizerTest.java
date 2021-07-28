package de.ausy.bufs.javahappen;

import org.junit.jupiter.api.Test;


public class OptionalizerTest {

    @Test
    public void x() throws TemperatureOutOfRangeException{
        // Arrange
        Optionalizer<Double, Double> optionalizer = new Optionalizer<>();
        FahrenheitConverter fahrenheitConverter = new FahrenheitConverter();
        Double d = fahrenheitConverter.convert(32);
        // Function<Double, Double> fTC = x -> fahrenheitConverter.convert(x);
    }
}
