package ru.kpfu.itis.group11506.set;

import java.util.Comparator;

 class ClientRatingComparator implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return o1.getRating() - o2.getRating();
    }
}
