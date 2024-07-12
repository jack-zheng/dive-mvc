package defect;

import java.util.ArrayList;
import java.util.List;

public class IssueClass implements Runnable {
    private static final List<Integer> PROJECTION_FIND_BY_ID = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Current list: " + PROJECTION_FIND_BY_ID);
            PROJECTION_FIND_BY_ID.add(i);
        }

        for (Integer i : PROJECTION_FIND_BY_ID) {
            System.out.println(i);
        }
    }
}
