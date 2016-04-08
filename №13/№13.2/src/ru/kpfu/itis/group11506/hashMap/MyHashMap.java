package ru.kpfu.itis.group11506.hashMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MyHashMap<K, V> implements Map<K, V> {

    private int size;
    private int n = 100;
    private LinkedList<Node>[] map = new LinkedList[n];
    private V value;


    MyHashMap() {
        for (int i = 0; i < n; i++) {
            map[i] = new LinkedList<>();
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        for (Object aLinkedList : map[key.hashCode() % n]) {
            if (((Node) aLinkedList).getKey() == key) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (int i = 0; i < n; i++) {
            if (map[i] != null) {
                for (Object aLinkedList : map[i]) {
                    if (((Node) aLinkedList).getValue() == value) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public V get(Object key) {
        for (Object aLinkedList : map[key.hashCode() % n]) {
            if (((Node) aLinkedList).getKey().equals(key)) {
                return (V) ((Node) aLinkedList).getValue();
            }
        }
        return null;
    }


    public V put(K key, V value) {
        if ((map[key.hashCode() % n]).size() == 0) {
            Node node = new Node<>(key, value);
            map[key.hashCode() % n].add(node);
            size += 1;
        } else if (this.containsKey(key)) {
            for (Object aLinkedList : map[key.hashCode() % n]) {
                if (((Node) aLinkedList).getKey() == key) {
                    this.value = (V) ((Node) aLinkedList).getValue();
                    ((Node) aLinkedList).setValue(value);
                    break;
                }
            }
        } else {
            Node node = new Node<>(key, value);
            map[key.hashCode() % n].add(node);
            size += 1;
        }
        return this.value;
    }

    public V remove(Object key) {
        if (this.containsKey(key)) {
            for (Object aLinkedList : map[key.hashCode() % n]) {
                if (((Node) aLinkedList).getKey() == key) {
                    value = (V) ((Node) aLinkedList).getValue();
                    map[key.hashCode() % n].remove(aLinkedList);
                    size -= 1;
                }
            }
        } else {
            return null;
        }
        return value;
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        Set set = m.entrySet();
        for (Object sets : set) {
            this.put((K) ((Node) sets).getKey(), (V) ((Node) sets).getValue());

        }
    }

    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            map[i] = null;
        }

    }

    public Collection<V> values() {
        LinkedList<Node> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (map[i] != null) {
                for (Object aLinkedList : map[i]) {
                    Node node = new Node<>(0, ((Node<K, V>) aLinkedList).getValue());
                    linkedList.add(node);
                }
            }
        }
        return (Collection) linkedList;
    }

    public Set<Entry<K, V>> entrySet() {
        HashSet<Node<K, V>> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (map[i] != null) {
                for (Object o : ((LinkedList<Node>) map[i])) {
                    hashSet.add((Node<K, V>) o);
                }
            }
        }
        return (Set) hashSet;
    }

    public Set<K> keySet() {
        HashSet<K> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (map[i] != null) {
                for (Object o : ((LinkedList<Node>) map[i])) {
                    hashSet.add((K) (((Node) o).getKey()));
                }
            }
        }
        return (Set) hashSet;
    }
}
