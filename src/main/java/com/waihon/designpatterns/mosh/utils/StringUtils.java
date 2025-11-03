package com.waihon.designpatterns.mosh.utils;

import java.util.regex.Pattern;

public class StringUtils {
    public static int countOfSubstring(String string, String substring) {
        return string.split(Pattern.quote(substring), -1).length - 1;
    }
}
