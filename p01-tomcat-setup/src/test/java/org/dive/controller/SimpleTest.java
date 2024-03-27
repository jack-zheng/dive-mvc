package org.dive.controller;


import org.apache.logging.log4j.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class SimpleTest {

    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger("");
//        logger.info("Hello World");
        // create a string with 3 placeholder {a}...{b}...{c}
        String text = "Hello {a}...{b}...{c}";
        String ret = text.replace("{a}", "World").replace("{b}", "Java").replace("{c}", "!");
        System.out.println(ret);
    }
}
