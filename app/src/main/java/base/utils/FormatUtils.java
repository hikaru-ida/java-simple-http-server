package base.utils;

import java.time.format.DateTimeFormatter;

public final class FormatUtils {
    private FormatUtils() {}

    public static DateTimeFormatter rfc1123() {
        return DateTimeFormatter.RFC_1123_DATE_TIME;
    }

    public static String crlf() {
        return "\r\n";
    }
}
