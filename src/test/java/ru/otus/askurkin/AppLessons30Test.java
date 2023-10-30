package ru.otus.askurkin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.askurkin.lens30.AppLesson30;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AppLessons30Test {
    private AppLesson30 app;

    @ParameterizedTest
    @MethodSource("testTransform")
    public void testTransformArray(List<Integer> array, List<Integer> result) {
        List<Integer> trans = app.transformArray(array);
        int[] transInt = new int[trans.size()];
        for (int i = 0; i < trans.size(); i++) {
            transInt[i] = trans.get(i);
        }

        int[] resInt = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resInt[i] = result.get(i);
        }

        Assertions.assertArrayEquals(transInt, resInt);
    }

    public static Stream<Arguments> testTransform() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(List.of(1, 2, 1, 2, 2), List.of(2, 2)));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("testTransformThrow")
    public void testTransformArrayThrow(List<Integer> array) {
        Assertions.assertThrows(RuntimeException.class, () -> app.transformArray(array), "Test2");
    }

    public static Stream<Arguments> testTransformThrow() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(List.of(2, 2, 2, 2)));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataCheckArray")
    public void testCheckArray(List<Integer> array, boolean result) {
        Assertions.assertEquals(app.checkArray(array), result);
    }

    public static Stream<Arguments> dataCheckArray() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(List.of(1, 2), true));
        out.add(Arguments.arguments(List.of(1, 1), false));
        out.add(Arguments.arguments(List.of(1, 3), false));
        out.add(Arguments.arguments(List.of(1, 2, 2, 1), true));
        return out.stream();
    }

}
