package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PointTest {

    @Test
    void distance() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        double result = a.distance(b);
        double expected = 4;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 2);
        double result = a.distance(b);
        double expected = 4;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }
}