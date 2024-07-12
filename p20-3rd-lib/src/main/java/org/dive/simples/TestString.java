package org.dive.simples;

public class TestString {
    public static void main(String[] args) {
        String longText = """
                这是一个非常长的字符串，
                它可以跨越多行。
                编译器会自动处理换行，
                而不需要额外的字符。
                """;

        String longText2 = """
                这是一个非常长的字符串，\
                它可以跨越多行，并且保持换行。\
                编译器会保留这些换行符。\
                """;
        System.out.println(longText);
        System.out.println(longText2);
    }
}
