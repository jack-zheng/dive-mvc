package org.dive.string;

public class Test {
    public static void main(String[] args) {
        String expectedContent = """
            "ACCOUNT_UUID","LOGIN_NAME","LOGIN_METHOD","LOCALE","TIME_ZONE","PERSON_ID","ACCOUNT_STATUS","ACCOUNT_TYPE"
            "Account ID","Login Name","Login Method","Locale","Time Zone","Person ID (Read-Only)","Status (Read-Only)","Account Type (Read-Only)"
            """;

        String s2 = "\"ACCOUNT_UUID\",\"LOGIN_NAME\",\"LOGIN_METHOD\",\"LOCALE\",\"TIME_ZONE\",\"PERSON_ID\",\"ACCOUNT_STATUS\",\"ACCOUNT_TYPE\"\n" +
                "\"Account ID\",\"Login Name\",\"Login Method\",\"Locale\",\"Time Zone\",\"Person ID (Read-Only)\",\"Status (Read-Only)\",\"Account Type (Read-Only)\"\n";

        System.out.println(expectedContent.equals(s2));

        System.out.println("---" + expectedContent + "---");
        System.out.println("---" + s2 + "---");
    }
}
