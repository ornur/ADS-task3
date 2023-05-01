package org.example;

import java.util.Random;

public class Main {
    static Student randomStudent(){
        Random random = new Random();
        StringBuilder name = new StringBuilder();
        for(int i = 0; i < 10; i++){
            name.append((char)(random.nextInt(26) + 'a'));
        }
        return new Student(name.toString());
    }
    static MyTestingClass randomMyTestingClass(){
        Random random = new Random();
        return new MyTestingClass(random.nextInt(100));
    }
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> myHashTable = new MyHashTable<>(200);
        for(int i = 0; i < 50; i++){
            myHashTable.put(randomMyTestingClass(), randomStudent());
        }
        System.out.println(myHashTable);
    }
}