package org.dive.simples.commonscsv;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TestJoin {
    @Test
    public void test() {
        String errDetailTemplate = """
                {index}. {emailErrMsg}
                {errNames}
                """;
//        List<String> test = List.of("A", "B", "C");
        List<String> test = List.of(errDetailTemplate, errDetailTemplate,errDetailTemplate);
        System.out.println("[" + String.join(", ", test) + "]");
    }

    @Test
    public void test2() {
        String errDetailTemplate = """
                {index}. {emailErrMsg}
                {errNames}
                """;
        List<String> test = List.of(errDetailTemplate, errDetailTemplate,errDetailTemplate);
        System.out.println("[" + String.join("\n", test) + "]");
    }
}
