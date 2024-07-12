package org.dive.simples.commonscsv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.dive.simples.Main;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class HeadersTest {
    @Test
    public void test_parse() throws IOException {
        String path = Main.class.getClassLoader().getResource("test.csv").getFile();
        File test = new File(path);

        Reader in = new FileReader(test);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.builder()
                .setHeader(Headers.class)
                .build().parse(in);

        for (CSVRecord record : records) {
            // record stream transfer to list
            record.toMap().forEach((k, v) -> System.out.println(k + " : " + v));
        }
    }

    @Test
    public void test_extra_column() throws Exception {
        Reader in = new FileReader(Main.class.getClassLoader().getResource("extra.csv").getFile());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder()
                .setHeader(Headers.class)
                .build().parse(in);

        for (CSVRecord record : records) {
            List<String> ret = record.toMap().values().stream().toList();
            // print all columns
            System.out.println(ret);
        }
    }

    @Test
    public void test_iterator() throws Exception {
        Reader in = new FileReader(Main.class.getClassLoader().getResource("extra.csv").getFile());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder()
                .setHeader(Headers.class)
                .build().parse(in);

        CSVRecord head = records.iterator().next();
        System.out.println(head.toMap().containsKey(Headers.ACCOUNT_UUID.name()));

        records.iterator().next();
        for (CSVRecord record : records) {
            List<String> ret = record.toMap().values().stream().toList();
            // print all columns
            System.out.println(ret);
        }
    }

    @Test
    public void test_only_part_config() throws Exception {
        Reader in = new FileReader(Main.class.getClassLoader().getResource("some.csv").getFile());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder()
                .setHeader(Headers.class)
                .build().parse(in);

        Iterator<CSVRecord> iterator = records.iterator();
        iterator.next();
        iterator.next();

        List<Headers> configurableColumns = Arrays
                .stream(Headers.values())
                .filter(column -> !column.isReadOnly())
                .toList();

        System.out.println(configurableColumns);

        while(iterator.hasNext()) {
            CSVRecord record = iterator.next();
            for (Headers column : configurableColumns) {
                if (record.toMap().keySet().contains(column.name())) {
                    String value = record.get(column);
                        System.out.println(column + " : " + value);
                }
            }
        }
    }

    @Test
    public void test_enum() {
        System.out.println(Arrays.toString(Headers.class.getEnumConstants()));
    }
}