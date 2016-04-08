package ru.kpfu.itis.group11506.set;

 interface SortedSetIterator<T> {

    boolean hasNext();

    T next();

    void add(T t);

    void set(T t);

    void remove();

    T checkNext();

}
