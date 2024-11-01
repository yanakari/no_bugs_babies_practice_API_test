package org.example.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    public static String randomString() {
        return "test_" + RandomStringUtils.randomAlphabetic(10);
    }
}
