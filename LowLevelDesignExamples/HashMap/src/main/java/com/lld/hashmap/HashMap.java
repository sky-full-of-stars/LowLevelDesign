package com.lld.hashmap;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HashMap<K,V>  implements Map<K,V>{

    private static int size = 16;

    private List<Entry<K,V>>[] hashMap;

    public HashMap() {
        this.hashMap =(List<Entry<K,V>>[]) new List[size];
    }

    @Override
    public void put(K key, V value) {
        int bucket = getBucketForAKey(key);
        Optional<Entry<K, V>> kvEntry = getKeyValueFromBucket(key, bucket);
        if(kvEntry.isPresent()) {
            kvEntry.get().setValue(value);
        }
        else {
            hashMap[bucket] = new ArrayList<>();
            hashMap[bucket].add(new Entry<>(key, value));
        }
    }

    @Override
    public V get(K key) {
        int bucket = getBucketForAKey(key);
        Optional<Entry<K, V>> kvEntry = getKeyValueFromBucket(key, bucket);
        return kvEntry.map(Entry::getValue).orElse(null);
    }

    @Override
    public void remove(K key) {
        int bucket = getBucketForAKey(key);
        Optional<Entry<K, V>> kvEntry = getKeyValueFromBucket(key, bucket);
        kvEntry.ifPresent(entry -> hashMap[bucket].remove(entry));
    }

    private Optional<Entry<K, V>> getKeyValueFromBucket(K key, int bucket) {
        return CollectionUtils.emptyIfNull(hashMap[bucket]).stream().filter(v -> v.getKey().equals(key)).findFirst();
    }

    private int getBucketForAKey(K key) {
        return (key.hashCode() % size);
    }
}
