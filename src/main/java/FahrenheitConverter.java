public class FahrenheitConverter {
    
    public double convert(double i) throws TemperatureOutOfRangeException {
        double result = (i - 32) * (Double.valueOf(5)/Double.valueOf(9));
        if (result < -272) {
            throw new TemperatureOutOfRangeException("temparature must not be under 0 Grad Kelvin");
        }
        return result;
        //return (i - 32) * (0.5556);
    }
}
