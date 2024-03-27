package org.dive.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        List<Locale> locales = new ArrayList<>();
        locales.add(Locale.US);
        locales.add(Locale.CHINA);


        List<Locale> ret = Arrays.asList(Locale.US, Locale.CHINA);
        System.out.println(ret);
        System.out.println(ret.getClass());
        ret.add(Locale.JAPANESE);
    }
}
