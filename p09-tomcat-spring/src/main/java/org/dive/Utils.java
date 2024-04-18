package org.dive;

public class Utils {
    public static String getProjectName() {
        String prefix = System.getProperty("user.dir") + "/";
        String suffix = "/target/classes/";

        String path = Utils.class.getClassLoader().getResource(".").getPath();
        return path.replace(prefix, "").replace(suffix, "");
    }
}
