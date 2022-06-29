package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportDate implements DateFormatter {

    private String format = "dd:MM:yyyy HH:mm";

    @Override
    public String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}
