package aatwi.dev;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static aatwi.dev.FizzBuzz.*;
import static org.fest.assertions.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    public void
    it_should_return_1_for_1() {
        assertThat(compute(1)).isEqualTo("1");
    }

    @Test
    public void
    it_should_return_FIZZ_for_3() {
        assertThat(compute(3)).isEqualTo(FIZZ);
    }

    @Test
    public void
    it_should_return_FIZZ_for_a_multiple_of_3() {
        assertThat(compute(9)).isEqualTo(FIZZ);
    }

    @Test
    public void
    it_should_return_BUZZ_for_5() {
        assertThat(compute(5)).isEqualTo(BUZZ);
    }

    @Test
    public void
    it_should_return_BUZZ_for_a_multiple_of_5() {
        assertThat(compute(10)).isEqualTo(BUZZ);
    }

    @Test
    public void
    it_should_return_FIZZBUZZ_for_a_multiple_of_3_and_5() {
        assertThat(compute(15)).isEqualTo(FIZZ_BUZZ);
    }


    @Test
    public void
    it_should_do_the_correct_computation_up_to_100() {
        Map<String, Integer> results = new HashMap<>();
        for (int number = 1; number <= 100; number++) {
            String fizzBuzzResult = compute(number);
            results.putIfAbsent(fizzBuzzResult, 0);
            results.replace(fizzBuzzResult, Integer.sum(results.get(fizzBuzzResult), 1));
        }

        assertThat(results.get(BUZZ)).isEqualTo(14);
        assertThat(results.get(FIZZ)).isEqualTo(27);
        assertThat(results.get(FIZZ_BUZZ)).isEqualTo(6);
    }

    @Test(expected = NumberFormatException.class)
    public void
    it_should_throw_exception_when_number_is_less_than_1() {
        compute(0);
    }
}