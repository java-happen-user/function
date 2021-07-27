package de.ausy.bufs.javahappen;

import java.util.Optional;
import java.util.function.Function;

public class Optionalizer<T, U> {

    public Function<T, Optional<U>> optionalize(Function<T, U> function){
        return new Optionalizer<T, U>().doOptionalize(function);
    }

    private Function<T, Optional<U>> doOptionalize(Function<T, U> function){
        Function<T, Optional<U>> result = t -> Optional.empty();

        try{
            result = t -> Optional.of(function.apply(t));
        }catch(Exception e){
        }

        return result;
    }
}
