package ru.job4j.assertj;

import com.puppycrawl.tools.checkstyle.checks.naming.IllegalIdentifierNameCheck;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void whenParseError() {
        NameLoad nd = new NameLoad();
        assertThatThrownBy(() -> nd.parse(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenNameNotContainsEquals() {
        NameLoad nd = new NameLoad();
        String st = "blabla";
        assertThatThrownBy(() -> nd.parse(st))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain")
                .hasMessageContaining(st);
    }

    @Test
    void whenStartWithEquals() {
        NameLoad nd = new NameLoad();
        String st = "=blabla";
        assertThatThrownBy(() -> nd.parse(st))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a key");
    }

    @Test
    void whenEndWithEquals() {
        NameLoad nd = new NameLoad();
        String st = "blabla=";
        assertThatThrownBy(() -> nd.parse(st))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a value");
    }
}