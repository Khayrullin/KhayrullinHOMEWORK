package ru.kpfu.itis.group11506.one;

public class CardStack {
    Card[] cards = new Card[]{
            new Card(2, "Joker"),
            new Card(3, "Queen"),
            new Card(4, "King"),
            new Card(6, "Six"),
            new Card(7, "Seven"),
            new Card(8, "Eight"),
            new Card(9, "Nine"),
            new Card(10, "Ten"),
            new Card(11, "Ace"),
    };

    public Card giveRandomCard() {
        return cards[(int) (Math.random() * cards.length)];
    }

}
