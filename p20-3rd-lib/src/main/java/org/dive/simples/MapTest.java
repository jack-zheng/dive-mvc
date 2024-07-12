package org.dive.simples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");

        Map tmp = Collections.singletonMap("a", "1");
        Map<String, String> map1 = new HashMap<>(tmp);
        System.out.println(map1);

        Map<String, String> map1_2 = new HashMap<>();
        map1_2.putAll(tmp);
        System.out.println(map1_2);

        Map<String, String> map2 = new HashMap<>();
        map2.putAll(map);

        System.out.println(map2);
    }
}
