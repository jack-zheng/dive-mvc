package defect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatList {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(3, 4, 5);

        List<Integer> l3 = Stream.concat(l1.stream(), l2.stream()).toList();
        System.out.println(l1);
        System.out.println("-----");
        System.out.println(l2);
        System.out.println("-----");
        System.out.println(l3);

    }
}
