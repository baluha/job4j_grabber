package ru.job4j.design.srp;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarAdapterJson implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public Calendar deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(simpleDateFormat.parse(jsonElement.getAsJsonPrimitive().getAsString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }

    @Override
    public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(simpleDateFormat.format(calendar.getTime()));
    }
}
