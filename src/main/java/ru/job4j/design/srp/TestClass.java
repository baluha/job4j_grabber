package ru.job4j.design.srp;

import org.json.JSONObject;

import java.util.Calendar;

public class TestClass {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bla", 14);
        jsonObject.put("bla", 14);
        jsonObject.put("bla", 14);
        jsonObject.put("bla", 14);
        System.out.println(jsonObject.toString());
    }
}
