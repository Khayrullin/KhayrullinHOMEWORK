package ru.kpfu.itis.group11506.queue;


import java.util.Iterator;

class QIterator<T> implements Iterator<T> {

    private T lastClient;

     QIterator(T t ) {
        lastClient = t;
    }

    @Override
    public boolean hasNext() {
        return ((Client)lastClient).getNextClient() != null;
    }

    @Override
    public T next() {
        lastClient = (T)((Client)lastClient).getNextClient();
        return lastClient;
    }

    @Override
    public void remove() {

    }
}
