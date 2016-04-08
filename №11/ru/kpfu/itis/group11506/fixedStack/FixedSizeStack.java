package ru.kpfu.itis.group11506.fixedStack;

import java.util.Iterator;


class FixedSizeStack<T> implements Stack<T> {

    FixedSizeStack(int size) {
        this.size = size;
        this.stack = new Object[size];
    }

    private Object[] stack;
    private int size;
    private int index = 0;

    @Override
    public Iterator<T> iterator() {
        return new FSSIterator(stack);
    }

    @Override
    public void push(T t) {
        stack[index] = t;
        index = index + 1;
    }

    @Override
    public T poll() {
        T helpObj = (T) stack[index - 1];
        stack[index - 1] = null;
        index = index -1;
        return helpObj;

    }

    @Override
    public T peek() {
        if (index == 0){
            return null;
        }
        return (T) stack[index-1];
    }
}
