package com.lunch.test;

import java.util.Arrays;
import java.util.List;

public class TestUtil {
    public static List<String> asList(String... strings) {
        return Arrays.asList(strings);
    }

    public static <T> List<T> asList(Class<T> clazz, T... objects) { return Arrays.asList(objects);};

}
