package org.dive.proxy;

import java.util.Locale;

public class TestLocale {
    public static void main(String[] args) {
        System.out.println(Locale.CHINESE.getLanguage());
        System.out.println(Locale.CHINESE.getCountry());
        System.out.println(Locale.CHINA.getLanguage());
        System.out.println(Locale.CHINA.getCountry());
    }
}
