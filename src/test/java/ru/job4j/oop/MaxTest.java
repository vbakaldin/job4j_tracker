package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MaxTest {

    @Test
    void whenOneTwoThreeThenThree() {
        int result = Max.findMax(1, 2, 3);
        int expected = 3;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenOneTwoThreeFourThenFour() {
        int result = Max.findMax(1, 2, 3, 4);
        int expected = 4;
        assertThat(result).isEqualTo(expected);
    }
}