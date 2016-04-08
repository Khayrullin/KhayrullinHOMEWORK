package ru.kpfu.itis.group11506.linkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class LinkedList<T> implements List<T> {

    private int size = 0;
    private Node firstNode = null;
    private Node lastNode = null;
    private Node helping;
    private Node help;
    private Node getHelp;
    private boolean checkerOfMethods;


    @Override
    public int size() {
        if (size < Integer.MAX_VALUE) {
            return size;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;

    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<>(firstNode);
    }

    @Override
    public Object[] toArray() {
        System.out.println(size);
        Node middleNode = firstNode;
        Node[] array = new Node[size];
        for (int i = 0; i < size; i++) {
            array[i] = middleNode;
            middleNode = middleNode.getNextNode();
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (firstNode == null) {
            firstNode = (Node) o;
            lastNode = (Node) o;
        } else {
            Node node1 = (Node) o;
            node1.setNode(null);
            lastNode.setNode((Node) o);
            lastNode = (Node) o;
        }
        size = size + 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        checkerOfMethods = false;
        boolean checker = false;
        if (firstNode.equals(o)) {
            helping = firstNode.getNextNode();
            firstNode.setNode(null);
            firstNode = helping;
            size = size - 1;
            checkerOfMethods = true;
        } else if (lastNode.equals(o)) {
            for (Node x = firstNode; x != lastNode; x = x.getNextNode()) {
                helping = x;
            }
            helping.setNode(null);
            lastNode = helping;
            size = size - 1;
            checkerOfMethods = true;

        } else {
            for (Node x = firstNode; x.getNextNode() != null && !checker; x = x.getNextNode()) {
                if (x.getNextNode().equals(o)) {
                    x.setNode(x.getNextNode().getNextNode());
                    size = size - 1;
                    checker = true;
                    checkerOfMethods = true;

                }
            }
        }
        return checkerOfMethods;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object objC : c) {
            if (!contains(objC)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object objC : c) {
            this.add(objC);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        boolean j = false;
        if (index == 0) {
            for (Object obj : c) {
                if (!j) {
                    getHelp = (Node) obj;
                    j = true;
                }
                help = (Node) obj;
                size = size + 1;
            }
            help.setNode(firstNode);
            firstNode = getHelp;
        } else {
            Iterator it = this.iterator();
            for (int i = 0; i < index; i++) {
                help = (Node) it.next();
            }
            getHelp = help;
            help = help.getNextNode();
            getHelp.setNode(null);
            lastNode = getHelp;
            this.addAll(c);
            lastNode.setNode(help);
            while (it.hasNext()) {
                lastNode = (Node) it.next();
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        checkerOfMethods = false;
        for (Object obj : c) {
            remove(obj);
            checkerOfMethods = true;
        }
        return checkerOfMethods;
    }

    @Override
    public boolean retainAll(Collection c) {
        checkerOfMethods = false;
        Iterator it = this.iterator();
        boolean killHim = true;
        while (it.hasNext()) {
            help = (Node) it.next();
            for (Object obj : c) {
                if (obj.equals(help)) {
                    killHim = false;
                }
            }
            if (killHim) {
                this.remove(help);
                checkerOfMethods = true;
            }
            killHim = true;

        }
        return checkerOfMethods;
    }

    @Override
    public void clear() {
        for (Object o : this) {
            remove(o);
        }
    }

    @Override
    public T get(int index) {
        Iterator iterator = this.iterator();
        for (int i = 0; i < index + 1; i++) {
            help = (Node) iterator.next();
        }
        return (T) help;
    }

    @Override
    public T set(int index, Object element) {
        Iterator iterator = this.iterator();
        for (int i = 0; i < index; i++) {
            help = (Node) iterator.next();
        }
        helping = help.getNextNode();
        help.setNode((Node) element);
        help.getNextNode().setNode(helping);
        size = size + 1;
        return (T) element;
    }

    @Override
    public void add(int index, Object element) {
        Iterator iterator = this.iterator();
        for (int i = 0; i < index; i++) {
            help = (Node) iterator.next();
        }
        helping = help.getNextNode().getNextNode();
        help.setNode((Node) element);
        help.getNextNode().setNode(helping);

    }

    @Override
    public T remove(int index) {
        Iterator iterator = this.iterator();
        for (int i = 0; i < index + 1; i++) {
            help = (Node) iterator.next();
        }
        helping = help;
        remove(help);
        size = size - 1;
        return (T) helping;
    }

    @Override
    public int indexOf(Object o) {
        int checker = -1;
        int index = -1;
        for (Node x = firstNode; x != null; x = x.getNextNode()) {
            checker = checker + 1;
            if (x.equals(o)) {
                if (checker > index) {
                    index = checker;
                }
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int checker = -1;
        int index = -1;
        for (Node x = firstNode; x != null; x = x.getNextNode()) {
            checker = checker + 1;
            if (x.equals(o)) {
                index = checker;

            }
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

}


class LinkedIterator<T> implements Iterator<T> {


    private Node firstNode;

    LinkedIterator(Node firstNode) {
        this.firstNode = firstNode;
    }

    @Override
    public boolean hasNext() {
        return firstNode != null;
    }

    @Override
    public T next() {
        Node helpNode = firstNode;
        firstNode = firstNode.getNextNode();
        return (T) helpNode;

    }

    @Override
    public void remove() {
    }
}