package ru.kpfu.itis.group11506.fixedStack;

import java.util.Iterator;

class FSSIterator<T> implements Iterator<T> {
    private Object[] stack;
    private int index = -1, index2;

    FSSIterator(Object[] stack) {
        this.stack = stack;

        for (Object obj : stack) {
            if (obj != null) {
                index = index + 1;
            }
        }
        index2 = index;
    }

    @Override
    public boolean hasNext() {
        return ((stack[index2] != null) && (index>-1));
    }

    @Override
    public T next() {
        index2 = index;
        index = index - 1;
        return (T) stack[index2];
    }

    @Override
    public void remove() {

    }
}
