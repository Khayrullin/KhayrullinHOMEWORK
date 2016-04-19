package ru.kpfu.itis.group11506.binaryTree;

class Node<T extends Comparable> {


    private T thing;
    private Node<T> r, l, parent;


    Node(T thing) {
        this.thing = thing;
    }

    T getThing() {
        return thing;
    }

    Node<T> getL() {
        return l;
    }

    void setL(Node<T> l) {
        this.l = l;
    }

    Node<T> getR() {
        return r;
    }

    void setR(Node<T> r) {
        this.r = r;
    }

    Node<T> getParent() {
        return parent;
    }

    void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void setThing(T thing) {
        this.thing = thing;
    }}