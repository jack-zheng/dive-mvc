package org.dive.simples.commonscsv;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TestSplit {
    @Test
    public void test() {
//        System.out.println(addLineBreakEvery5Items("A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10"));
        System.out.println(addLineBreakEvery5ItemsListVersion(List.of("A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10")));
    }

    private static String addLineBreakEvery5Items(String str) {
        String[] names = str.split(", ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            sb.append(names[i]);
            if (i % 5 == 4) {
                sb.append(",\n");
            } else {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * Formats a list of names such that they are separated by ", " and a new line is started
     * every 5 names. A comma is added after the last name on each line except for the very last line.
     *
     * @param list The list of names to format.
     * @return A string containing the formatted names.
     */
    private static String addLineBreakEvery5ItemsListVersion(List<String> list) {
        StringBuilder sb = new StringBuilder();
        final int lineWidth = 5;
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            // If this is not the last item and there's no remainder when dividing by lineWidth, append a comma and a line break.
            if (i < list.size() - 1 && (i + 1) % lineWidth == 0) {
                sb.append(",\n");
            } else if (i < list.size() - 1) { // If this is not the last item, append a comma and a space.
                sb.append(", ");
            }
        }
        return sb.toString();
    }


}
