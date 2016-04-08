package ru.kpfu.itis.group11506.linkedList;

class Node<T> {

    private Node<T> nextNode;

    private T value;

    void setNode(Node nextNode) {
        this.nextNode =  nextNode;
    }

     Node<T> getNextNode() {
        return nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
