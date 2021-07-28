package de.ausy.bufs.javahappen;

import java.util.Optional;
import java.util.function.Function;

public class FahrenheitToCelsiusDefinedRange {

    public void x(){
        Function<Double, Optional<Double>> ftc = f -> ftc(f);
    }

    private Optional<Double> ftc(double f){
        if(f < -271){
            return Optional.empty();
        }

        return Optional.of((f - 32) * 5/9);
    }
}
