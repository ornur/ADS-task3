package org.example;


public class Main {
    public static void main(String[] args) {
        // Create a new MyHashTable instance with MyTestingClass as key and Student as value
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        // Add random 10000 elements to the table
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass();
            Student value = new Student("John Doe", i);
            table.put(key, value);
        }

        // Print the number of elements in each bucket
        for (int i = 0; i < table.getNumBuckets(); i++) {
            System.out.println("Bucket " + i + ": " + table.getNumElementsInBucket(i));
        }

        // Tune the hashCode method in MyTestingClass
        // ...

    }
}