package ru.job4j.assertj;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ModelTest {

    @Test
    void checkBoolean() {
        Model model = new Model(1, 5.255d, "name", true);
        boolean result = model.isCondition();
        assertThat(result).isTrue();
    }

    @Test
    void checkStringChain() {
        Model model = new Model(1, 5.255d, "I am learning Java", true);
        String result = model.getLine();
        assertThat(result).isNotNull()
                .isNotEmpty()
                .containsIgnoringCase("java")
                .contains("am", "Java")
                .doesNotContain("javascript")
                .startsWith("I am")
                .endsWith("Java")
                .isEqualTo("I am learning Java");
    }

    @Test
    void checkDoubleChain() {
        Model model = new Model(1, 5.255d, "name", true);
        double result = model.getNum();
        assertThat(result).isEqualTo(5.26d, withPrecision(0.006d))
                .isCloseTo(5.25d, withPrecision(0.01d))
                .isCloseTo(5.25d, Percentage.withPercentage(1.0d))
                .isGreaterThan(5.25d)
                .isLessThan(5.26d);
    }
}