package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MyHashTable<K,V> {
    public int getNumElementsInBucket(int i) {
        return 0;
    }

    public List<List<HashNode<K,V>>> getBuckets() {
        return null;
    }

    private static class HashNode<K,V>{
        private final K key;
        private V value;
        private HashNode<K,V>  next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private final List<List<HashNode<K,V>>> buckets;
    private int numElements;

    public MyHashTable(){
        buckets = new ArrayList<>();
        for (int i = 0; i < 16; i++) { // Initialize with 16 buckets
            buckets.add(new LinkedList<>());
        }
        numElements = 0;
    }

    public MyHashTable(int M){
        buckets = new ArrayList<>();
        for (int i = 0; i < M; i++) { // Initialize with M buckets
            buckets.add(new LinkedList<>());
        }
        numElements = 0;
    }

    private int hash(K key){
        int h = 0;
        for (int i = 0; i < key.toString().length(); i++) {
            h = 31 * h + key.toString().charAt(i);
        }
        return h;
    }

    public void put(K key, V value){
        int bucketIndex = hash(key) % buckets.size();
        List<HashNode<K,V>> bucket = buckets.get(bucketIndex);
        for (HashNode<K,V> node : bucket) {
            if (node.key.equals(key)) { // If key already exists, update value and return
                node.value = value;
                return;
            }
        }
        // Key not found, add new node
        HashNode<K,V> newNode = new HashNode<>(key, value);
        bucket.add(newNode);
        numElements++;
    }

    public V get(K key){
        int bucketIndex = hash(key) % buckets.size();
        List<HashNode<K,V>> bucket = buckets.get(bucketIndex);
        for (HashNode<K,V> node : bucket) {
            if (node.key.equals(key)) { // If key found, return value
                return node.value;
            }
        }
        // Key not found
        return null;
    }

    public int getNumBuckets() {
        return buckets.size();
    }

    public boolean contains(V value){
        for (List<HashNode<K,V>> bucket : buckets) {
            for (HashNode<K,V> node : bucket) {
                if (node.value.equals(value)) { // If value found, return true
                    return true;
                }
            }
        }
        // Value not found
        return false;
    }

    public K getKey(V value){
        for (List<HashNode<K,V>> bucket : buckets) {
            for (HashNode<K,V> node : bucket) {
                if (node.value.equals(value)) { // If value found, return key
                    return node.key;
                }
            }
        }
        // Value not found
        return null;
    }

    public int getBucketSize(int index) {
        List<HashNode<K,V>> bucket = buckets.get(index);
        return bucket.size();
    }

    public void printBucketSizes() {
        for (int i = 0; i < buckets.size(); i++) {
            System.out.println("Bucket " + i + ": " + getBucketSize(i));
        }
    }
}
