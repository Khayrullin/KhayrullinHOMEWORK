package ru.kpfu.itis.group11506.binaryTree;

import java.util.Iterator;

class TreeIterator<T extends Comparable> implements Iterator<Node<T>> {

    private Node<T> min;
    private Node<T> max;
    private int b = 0;

    TreeIterator(Node<T> head) {
        setMax(head);
        setMin(head);
    }

    @Override
    public boolean hasNext() {
        if (min != max && b == 0) {
            return true;
        } else if (min == max && b < 1) {
            b += 1;
            return true;
        }
        return false;
    }


    @Override
    public Node<T> next() {
        Node<T> middle = min;
        if (min.getParent() != null &&
                min.getThing().compareTo(min.getParent().getThing()) == -1 && min.getR() == null) {
            min = min.getParent();
        } else if (min.getR() != null) {
            setMin(min.getR());
        } else if (min.getParent() != null && min.getR() == null) {
            while (min.getParent() != null && (min.getThing().compareTo(min.getParent().getThing()) == 1
                    || min.getThing().compareTo(min.getParent().getThing()) == 0)) {
                min = min.getParent();
            }
            min = min.getParent();
        }
        return middle;
    }

    private void setMin(Node<T> min) {
        this.min = min;
        while (this.min.getL() != null) {
            this.min = this.min.getL();
        }
    }

    private void setMax(Node<T> max) {
        this.max = max;
        while (this.max.getR() != null) {
            this.max = this.max.getR();
        }
    }
    public void remove(){};
}
