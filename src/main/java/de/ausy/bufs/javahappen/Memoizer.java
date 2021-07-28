package de.ausy.bufs.javahappen;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/*

 Functional Programming in Java
 HOW FUNCTIONAL TECHNIQUES IMPROVE YOUR JAVA PROGRAMS

 PIERRE-YVES SAUMONT

 */
public class Memoizer <T, U> {
    private final Map<T, U> cache = new ConcurrentHashMap<>();

    public Function<T, U> memoize(Function<T, U> function){
        return new Memoizer<T, U>().doMemoize(function);
    }

    private Function<T, U> doMemoize(Function<T, U> function){
        return input -> cache.computeIfAbsent(input, function::apply);
    }
}