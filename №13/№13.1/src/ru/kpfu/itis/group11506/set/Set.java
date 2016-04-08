package ru.kpfu.itis.group11506.set;

public interface Set<T> extends Iterable<T> {
    boolean add(T t);

    boolean remove(T t);

    void union(Set<T> set);

    void intersect(Set<T> set);

    void remove(Set<T> set);

    boolean contains(T t);
}