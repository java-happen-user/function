package de.ausy.bufs.javahappen;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Memoizer <T, U> {
    private final Map<T, U> cache = new ConcurrentHashMap<>();

    public U perform(T t, Function<T,U> function){
        return function.apply(t);
    }

    public Function<T, U> memoize(Function<T, U> function){
        return new Memoizer<T, U>().doMemoize(function);
    }

    private Function<T, U> doMemoize(Function<T, U> function){
        return input -> cache.computeIfAbsent(input, function::apply);
    }

    private Map<T, U> getCache(){
        return this.cache;
    }
}