package ru.job4j.template;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GeneratorTest  {

    @Ignore
    @Test
    public void whenGenerate() {
        Map<String, String> map = new HashMap<>();
        map.put("Name", "Ivan");
        map.put("Surname", "Ivanov");
        map.put("Middle name", "Ivanovich");
        Generator generator = new GeneratorFullName();
        assertThat("Ivanov Ivan Ivanovich",
                is(generator.produce("${Surname} ${name} ${Middle name}", map)));
    }

    @Ignore
    @Test
    public void whenExcessSample() throws IllegalArgumentException {
        Map<String, String> map = new HashMap<>();
        map.put("Name", "Ivan");
        map.put("Middle name", "Ivanovich");
        Generator generator = new GeneratorFullName();
        assertThat("Ivanov Ivan Ivanovich",
                is(generator.produce("${Surname} ${name} ${Middle name}", map)));
    }

    @Ignore
    @Test
    public void key() throws IllegalArgumentException {
        Map<String, String> map = new HashMap<>();
        map.put("Name", "Ivan");
        map.put("Surname", "Ivanov");
        map.put("Middle name", "Ivanovich");
        Generator generator = new GeneratorFullName();
        assertThat("Ivanov Ivan Ivanovich",
                is(generator.produce("${name} ${Middle name}", map)));
    }
}