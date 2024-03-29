package org.dive;

import java.time.LocalDateTime;

public class DefaultTimer implements Timer {
    @Override
    public void logTime() {
        // print Date now
        System.out.println("Time: " + LocalDateTime.now());
    }
}
