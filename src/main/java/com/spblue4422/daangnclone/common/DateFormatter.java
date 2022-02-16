package com.spblue4422.daangnclone.common;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static String dtFormat(Date dt) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return parser.format(dt);
    }
}
