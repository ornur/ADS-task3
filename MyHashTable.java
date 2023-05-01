package org.example;
public class MyHashTable<K,V> {
    private static class HashNode<K,V>{
        private final K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode[] chainArray;
    private int M = 11;
    private int size = 0;
    
    public MyHashTable(){
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
    }
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void put(K key, V value){
        int index = hash(key);
        HashNode<K,V> node = chainArray[index];
        while(node != null){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode<K,V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }
    
    public V get(K key){
        int index = hash(key);
        HashNode<K,V> node = chainArray[index];
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key){
        int index = hash(key);
        HashNode<K,V> node = chainArray[index];
        HashNode<K,V> prev = null;
        while(node != null){
            if(node.key.equals(key)){
                if(prev == null){
                    chainArray[index] = node.next;
                }else{
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    public boolean contains(K key){
        return get(key) != null;
    }

    public K getKey(V value){
        for(int i = 0; i < M; i++){
            HashNode<K,V> node = chainArray[i];
            while(node != null){
                if(node.value.equals(value)){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            HashNode<K,V> node = chainArray[i];
            if(node != null){
                sb.append("[").append(i).append("]");
                while(node != null){
                    sb.append(node).append(" ");
                    node = node.next;
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
