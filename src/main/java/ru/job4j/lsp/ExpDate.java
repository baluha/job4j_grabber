package ru.job4j.lsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpDate {
    public static float percent(String created, String exp) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date dateS = format.parse(created);
        Date dateE = format.parse(exp);

        long diff = dateE.getTime() - dateS.getTime();
        long now = dateE.getTime() - System.currentTimeMillis();
        float nowF = (float) now / 84600000;
        float difF = (float) diff / 84600000;
        return 100 - ((nowF / difF) * 100);
    }
}
