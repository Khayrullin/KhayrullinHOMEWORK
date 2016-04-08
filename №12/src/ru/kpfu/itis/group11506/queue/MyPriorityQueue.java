package ru.kpfu.itis.group11506.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

class MyPriorityQueue<T> implements PriorityQueue<T> {

    private int size;
    private int limitSize;
    private T firstClient;
    private T lastClient;
    private Client helpClient;
    private Client helpClient2;

    MyPriorityQueue(int limitSize) {
        this.limitSize = limitSize;
    }

    @Override
    public Comparator<T> getComparator() {
        return new RatingCompare<>();

    }
    @Override
    public void push(T t) throws QueuOutOfBoundException {
        if (!(size > limitSize)) {
            if (firstClient == null) {
                firstClient = t;
                lastClient = t;
            } else {
                Comparator<T> comparator = getComparator();
                Iterator iterator = iterator();
                helpClient = (Client) lastClient;
                if (comparator.compare(t, lastClient) == 1) {
                    while (iterator.hasNext() && (comparator.compare(t, (T) (helpClient).getNextClient()) == 1)) {
                        helpClient = helpClient.getNextClient();
                        iterator.next();
                    }
                    if(helpClient == firstClient){
                        helpClient.setNextClient((Client) t);
                        firstClient = (T)helpClient.getNextClient();
                    }else {
                        helpClient2 = helpClient.getNextClient();
                        helpClient.setNextClient((Client) t);
                        helpClient.getNextClient().setNextClient(helpClient2);
                    }
                } else{
                    helpClient =(Client) lastClient;
                    lastClient =  t;
                    helpClient2 = (Client) lastClient;
                    helpClient2.setNextClient(helpClient);
                }
            }

            size += 1;
        } else {
            throw new QueuOutOfBoundException("Очередь заполнена!");
        }
    }

    @Override
    public T poll() throws NoSuchElementException {
        boolean b = false;
        if (size > 0){
            Iterator iterator = iterator();
            helpClient  = (Client) firstClient;
            helpClient2 = (Client)lastClient;
            while (iterator.hasNext() && (helpClient2.getNextClient()!= firstClient)){
                helpClient2 = (Client)iterator.next();

            }
            if(firstClient != lastClient){
                helpClient2.setNextClient(null);
                firstClient = (T)helpClient2;
            }else {
                firstClient = null;
                lastClient = null;
            }
            size -= 1;
            return (T)helpClient;
        }else {
            throw new NoSuchElementException("Очередь пуста!");
        }
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (size > 0) {
            return firstClient;
        } else {
            throw new NoSuchElementException("Очередь пуста!");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator<>(lastClient);
    }
}

