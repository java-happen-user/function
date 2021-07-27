package de.ausy.bufs.javahappen;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest {

    @Test
    public void functionToAddOne_calledWithApply() {
        //Arrange
        Function<Integer, Integer> addOne = x -> x + 1;

        // Act
        int i = addOne.apply(5);

        // Assert
        assertEquals(6, i);
    }


    @Test
    public void functionToAddOne_calledForStream() {
        //Arrange
        Function<Integer, Integer> addOne = x -> x + 1;
        Stream<Integer> ints = Stream.iterate(0, n -> n + 1).limit(200000);

        // Act
       List<Integer> result = ints.map(addOne).collect(Collectors.toList());

        // Assert
        assertFalse(result.contains(0));
        assertTrue(result.contains(200001));
    }
}
