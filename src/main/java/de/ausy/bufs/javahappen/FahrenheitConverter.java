package de.ausy.bufs.javahappen;

public class FahrenheitConverter {
    
    public double convert(double i) throws TemperatureOutOfRangeException {
        double result = (i - 32) * 5/9;
        if (result < -272) {
            throw new TemperatureOutOfRangeException("temperature must not be under 0 Grad Kelvin");
        }
        return result;
        //return (i - 32) * (0.5556);
    }
}
