package org.dive.simples;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.dive.simples.commonscsv.Headers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CSVWithExtraHeader {
    public static void main(String[] args) throws IOException {
        String path = CSVWithExtraHeader.class.getClassLoader().getResource("extra.csv").getFile();
        File test = new File(path);
//        System.out.println(test.isFile());

        Reader in = new FileReader(test);
//        Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);
        CSVParser parser = CSVFormat.RFC4180.builder()
                .setHeader().setSkipHeaderRecord(true)
                .build().parse(in);

        Iterator<CSVRecord> iterator = parser.iterator();
        iterator.next();
        System.out.println("---------------------------------");
        iterator.forEachRemaining(System.out::println);

//        System.out.println(Headers.valueOf("abc"));

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // 向集合1中添加元素
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        // 向集合2中添加元素
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        // 打印原始集合
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // 计算交集
        set2.retainAll(set1);

        // 打印交集
        System.out.println("Intersection: " + set2);
    }
}

