package ru.job4j.design.srp;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarAdapterXml extends XmlAdapter<String, Calendar> {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public Calendar unmarshal(String s) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatter.parse(s));
        return calendar;
    }

    @Override
    public String marshal(Calendar calendar) throws Exception {
        return formatter.format(calendar.getTime());
    }
}

