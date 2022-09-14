package ru.job4j.early;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenLengthWrong() {
     PasswordValidator.validate("bla");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEmpty() {
        PasswordValidator.validate("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenLower() {
        PasswordValidator.validate("asdfas8afsd**");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenUpper() {
        PasswordValidator.validate("ASFDG7SERTS(*");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSpecialSymbol() {
        PasswordValidator.validate("ASF7DGSERTSasdfa");
    }

}