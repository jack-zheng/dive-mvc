package org.dive;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TestOffsetDate {
    public static void main(String[] args) {
        OffsetDateTime now = OffsetDateTime.now();
        System.out.println("Origin Formatted DateTime: " + now);

        // 输出带时区偏移的时间
        DateTimeFormatter beforeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ");
        String beforeFormattedDateTime = now.format(beforeFormatter);
        System.out.println("Before Formatted DateTime: " + beforeFormattedDateTime);

        // 转换为 UTC 时间并格式化
        OffsetDateTime utcDateTime = now.withOffsetSameInstant(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String formattedDateTime = utcDateTime.format(formatter);
        System.out.println("After  Formatted DateTime: " + formattedDateTime);

        System.out.println(OffsetDateTime.now().minusDays(2).withOffsetSameInstant(ZoneOffset.UTC));
    }
}
