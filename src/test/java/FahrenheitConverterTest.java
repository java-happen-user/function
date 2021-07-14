import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class FahrenheitConverterTest {
    
    FahrenheitConverter fc = new FahrenheitConverter();
    
    @Test
    public void testConversionToCelsius() throws TemperatureOutOfRangeException{
        Assertions.assertEquals(42, 42);
        Assertions.assertEquals(0, fc.convert(32));
        Assertions.assertEquals(100, Math.round(fc.convert(212)));
        Assertions.assertThrows(TemperatureOutOfRangeException.class, () -> {fc.convert(-800);});
    }
    
    
}
