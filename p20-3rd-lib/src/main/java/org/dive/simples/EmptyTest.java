package org.dive.simples;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.dive.simples.commonscsv.Headers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class EmptyTest {
    public static void main(String[] args) throws IOException {
        String path = EmptyTest.class.getClassLoader().getResource("empty.csv").getFile();
        File test = new File(path);
//        System.out.println(test.isFile());

        Reader in = new FileReader(test);
//        Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);
        CSVParser parser = CSVFormat.RFC4180.builder()
                .setHeader().setSkipHeaderRecord(true)
                .build().parse(in);

        System.out.println(parser.getHeaderMap().keySet());

        System.out.println(Arrays.toString(Headers.values()));
    }
}

