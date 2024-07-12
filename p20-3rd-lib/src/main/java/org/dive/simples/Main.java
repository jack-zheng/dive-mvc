package org.dive.simples;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.dive.simples.commonscsv.Headers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = Main.class.getClassLoader().getResource("test.csv").getFile();
        File test = new File(path);
//        System.out.println(test.isFile());

        Reader in = new FileReader(test);
//        Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.builder()
                .setHeader(Headers.class)
                .build().parse(in);
        for (CSVRecord record : records) {
            // record stream transfer to list
            record.toMap().forEach((k, v) -> System.out.println(k + " : " + v));
        }
    }
}

