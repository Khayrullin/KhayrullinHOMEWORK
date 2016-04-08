package ru.kpfu.itis.group11506.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

 class LinkedSortedSet<T> implements Set<T> {
    private Comparator<T> comparator;
    private Node<T> first;
    private Node<T> last;
    private int size;

     LinkedSortedSet(Comparator<T> comparator) {
        this.comparator = comparator;
        size = 0;
        first = last = null;
    }

    public boolean contains(T t) {
        return indexOf(t) != -1;
    }

    private int indexOf(T t) {
        int i = 0;
        if (t == null) {
            for (Node<T> x = first; x != null; x = x.next, i++) {
                if (x.item == null) {
                    return i;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next, i++) {
                if (t.equals(x.item)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean add(T t) {
        if (first == null) {
            addLast(t);
        } else {
            SortedSetIterator<T> it = sortedSetIterator();
            if (contains(t)) {
                while (it.hasNext()) {
                    if (it.next() == t) {
                        it.set(t);
                        return true;
                    }
                }
            } else {
                while (it.hasNext()) {
                    if (comparator.compare(it.checkNext(), t) <= 0) {
                        it.add(t);
                        it.next();
                        return false;
                    } else {
                        it.next();
                    }
                }
                it.add(t);
            }
        }
        return false;
    }


    @Override
    public boolean remove(T t) {
        if (t == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    cut(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (t.equals(x.item)) {
                    cut(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void union(Set<T> set) {
        for (T t : set) {
            this.add(t);
        }
    }

    @Override
    public void intersect(Set<T> set) {
        SortedSetIterator<T> it = sortedSetIterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                it.remove();
            }
        }
    }

    @Override
    public void remove(Set<T> set) {
        for (T t : set) {
            this.remove(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        @Override
        public void remove() {

        }

        SortedSetItr listIterator = new SortedSetItr();

        @Override
        public boolean hasNext() {
            return listIterator.hasNext();
        }

        @Override
        public T next() {
            return listIterator.next();
        }
    }

     private SortedSetIterator<T> sortedSetIterator() {
        return new SortedSetItr();
    }


    private class SortedSetItr implements SortedSetIterator<T> {
        private Node<T> next;
        private Node<T> lastRet;
        private int nextIndex;

         SortedSetItr() {
            next = first;
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastRet = next;
            next = next.next;
            nextIndex++;
            return lastRet.item;
        }

        @Override
        public void remove() {
            if (lastRet == null)
                throw new IllegalStateException();

            cut(lastRet);
            nextIndex--;
            lastRet = null;
        }

        @Override
        public T checkNext() {
            return next.item;
        }

        @Override
        public void set(T t) {
            if (lastRet == null)
                throw new IllegalStateException();

            lastRet.item = t;
        }

        @Override
        public void add(T t) {
            lastRet = null;
            if (next == null) {
                addLast(t);
            } else {
                addBefore(next, t);
            }
            nextIndex++;
        }
    }

    private void addLast(T t) {
        Node<T> newNode = new Node<>(t);
        newNode.next = null;
        if (last == null) {
            newNode.prev = null;
            first = last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    private void addBefore(Node<T> node, T t) {
        Node<T> newNode = new Node<>(t);
        newNode.prev = node.prev;
        newNode.next = node;
        if (node.prev == null) {
            first = newNode;
            node.prev = newNode;
        } else {
            node.prev.next = newNode;
            node.prev = newNode;
        }
        size++;
    }

    private T cut(Node<T> node) {
        T item = node.item;
        Node<T> next = node.next;
        Node<T> prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
        return item;
    }


    private static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

         Node(T item) {
            this.item = item;
        }
    }
}