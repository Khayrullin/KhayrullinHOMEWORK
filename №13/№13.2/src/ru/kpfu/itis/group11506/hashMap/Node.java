package ru.kpfu.itis.group11506.hashMap;

class Node<K, V> {

    private K key;
    private V value;
    private Node nextNode;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    void setNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    Node getNextNode() {
        return nextNode;
    }


    void setValue(V value) {
        this.value = value;
    }

    V getValue() {
        return value;
    }

    K getKey() {
        return key;
    }
}
