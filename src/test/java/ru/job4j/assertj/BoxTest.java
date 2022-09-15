package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
        .doesNotContain("Cube")
        .startsWith("Sp")
        .doesNotStartWith("blabla");
    }

    @Test
    void numberOfVertices() {
        Box box = new Box(8, 5);
        int num = box.getNumberOfVertices();
        assertThat(num)
                .isNotEqualTo(5)
                .isBetween(2, 9)
                .isGreaterThan(5);
    }

    @Test
    void existing() {
        Box box = new Box(4, 5);
        assertThat(box.isExist())
                .isTrue();
    }

    @Test
    void area() {
        Box box = new Box(0, 5);
        double area = box.getArea();
        assertThat(area)
                .isCloseTo(314.159d, withPrecision(0.001d))
        .isGreaterThan(150.0d);
    }
}