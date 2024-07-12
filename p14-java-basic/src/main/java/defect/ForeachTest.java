package defect;

import java.util.Arrays;
import java.util.List;

public class ForeachTest {
    private List<Integer> list = Arrays.asList(1, 2, 3);

    public void testLoop() {
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
