package pers.hx.basicknowledge.java8;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description:
 * @create: 2021-12-17 13:33
 */

public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "def", "gkh", "abc");
        Stream<String> stringStream = strings.stream().filter(s -> "abc".equals(s));
        long count = stringStream.count();
    }
}
