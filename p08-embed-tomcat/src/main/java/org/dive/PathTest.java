package org.dive;

public class PathTest {
    public static void main(String[] args) {
        String baseDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("path: " + baseDir);

        String docPath = PathTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("docPath: " + docPath);

    }
}
