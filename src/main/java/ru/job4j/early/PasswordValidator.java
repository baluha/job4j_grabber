package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null || "".equals(password)) {
            throw new IllegalArgumentException("Password is empty");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Wrong password length,"
                    + " it must be more than 8 and"
                    + "less then 32");
        }

        if (!upperCaseValidator(password) || !lowerCaseValidator(password)) {
           throw new IllegalArgumentException("Must be at least one upper case symbol"
                   + "and one upper case symbol");
        }

        if (!characterIsDigit(password)) {
            throw new IllegalArgumentException("Must be at least one number");
        }

        if (!specialChars(password)) {
            throw new IllegalArgumentException("Must be at least one special symbol");
        }

        if (subStrings(password)) {
            throw new IllegalArgumentException("Wrong password!");
        }

        return "password correct";

    }

    private static boolean upperCaseValidator(String password) {
        char[] array = password.toCharArray();
        for (char x : array) {
            if (Character.isUpperCase(x) && !Character.isDigit(x)) {
                return true;
            }
        }
        return false;
    }

    private static boolean lowerCaseValidator(String password) {
        char[] array = password.toCharArray();
        for (char x : array) {
            if (Character.isLowerCase(x) && !Character.isDigit(x)) {
                return true;
            }
        }
        return false;
    }

    private static boolean characterIsDigit(String password) {
        char[] array = password.toCharArray();
        for (char x : array) {
            if (Character.isDigit(x)) {
                return true;
            }
        }
        return false;
    }

    private static boolean specialChars(String password) {
        String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
        for (int i = 0; i < password.length(); i++) {
            String[] st = password.split("");
            if (specialChars.contains(st[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean subStrings(String password) {
        String[] subS = new String[] {"qwerty", "12345", "password", "user", "admin"};
        for (String st: subS) {
            if (password.toLowerCase().contains(st)) {
                return true;
            }
        }
        return false;
    }
}
