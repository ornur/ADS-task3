package org.example;

import java.util.Random;

public class MyTestingClass {
    private int id;
    private String name;
    private double value;

    // constructors, getters, setters, etc.

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        long temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    // other methods
}

class myTestingClass {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        // Add 10000 random elements to the hashtable
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass();
            Student value = new Student("John Doe", random.nextInt(100));
            table.put(key, value);
        }

        // Print the number of elements in each bucket
        for (int i = 0; i < table.getBuckets().size(); i++) {
            System.out.println("Bucket " + i + ": " + table.getBuckets().get(i).size() + " elements");
        }

        // Tune the hashCode method to avoid clustering of hash codes
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass();
            sum += key.hashCode();
        }
        System.out.println("Average hash code: " + (sum / 10000.0));
    }
}
