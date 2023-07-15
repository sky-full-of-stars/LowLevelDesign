package com.lld.hashmap;

public class HashMapApplication {

    public static void main(String[] args) {

        HashMap<Integer,Integer> myMap= new HashMap<>();

        myMap.put(2,3);
        myMap.put(2,4);
        myMap.put(3,9);
        myMap.put(4,16);

        myMap.remove(4);

        Integer valueFor3 = myMap.get(3);
        Integer valueFor2 = myMap.get(2);

        System.out.println("Value for Key 2 "+ valueFor2);
        System.out.println("Value for Key 3 "+ valueFor3);
        System.out.println("Value for Key 4 "+ myMap.get(4));

    }
}
