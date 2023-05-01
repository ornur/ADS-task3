package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        Random rand = new Random();

        // Add random 10000 elements
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(rand.nextInt(100));
            String value = "value" + i;
            table.put(key, value);
        }

        // Print number of elements in each bucket
        for (int i = 0; i < 16; i++) {
            System.out.println("Bucket " + i + ": " + table.getNumElementsInBucket(i));
        }
    }
}