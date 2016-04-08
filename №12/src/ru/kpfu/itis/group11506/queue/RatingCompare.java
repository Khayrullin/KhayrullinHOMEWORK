package ru.kpfu.itis.group11506.queue;

import java.util.Comparator;

class RatingCompare<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {


        if (((Client)o1).getRating() > ((Client)o2).getRating()) {
            return 1;
        } else if (((Client)o1).getRating() < ((Client)o2).getRating()) {
            return -1;
        } else return 0;
    }
}

