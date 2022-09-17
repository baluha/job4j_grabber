package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void toArrayTest() {
        String[] st = new String[]{"1", "2", "3", "4", "5"};
        SimpleConvert simpleConvert = new SimpleConvert();
        assertThat(simpleConvert.toArray(st))
                .hasSize(5)
                .doesNotContain("10", "150")
                .endsWith("4", "5");
    }

    @Test
    void toListTest() {
        String[] st = new String[]{"1", "2", "3", "4", "5"};
        SimpleConvert simpleConvert = new SimpleConvert();
        assertThat(simpleConvert.toList(st))
                .hasSize(5)
                .doesNotContain("10", "150")
                .endsWith("4", "5")
                .startsWith("1", "2")
                .containsExactlyInAnyOrder("5", "3", "1", "2", "4");
    }

    @Test
    void toSetTest() {
        String[] st = new String[]{"1", "2", "2", "3", "4", "5", "5"};
        SimpleConvert simpleConvert = new SimpleConvert();
        assertThat(simpleConvert.toSet(st))
                .hasSize(5)
                .doesNotContain("10", "150")
                .endsWith("4", "5")
                .startsWith("1", "2")
                .containsExactlyInAnyOrder("5", "3", "1", "2", "4");
    }

    @Test
    void toMapTest() {
        String[] st = new String[]{"1", "2", "2", "3", "4", "5", "5"};
        SimpleConvert simpleConvert = new SimpleConvert();
        assertThat(simpleConvert.toMap(st))
                .hasSize(5)
                .containsKey("1")
                .doesNotContainEntry("4", 5)
                .containsEntry("3", 3);
    }
}