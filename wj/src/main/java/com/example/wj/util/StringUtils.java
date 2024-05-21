package com.example.wj.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;

public class StringUtils {
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return format.format(date) + sb.toString();
    }
}
