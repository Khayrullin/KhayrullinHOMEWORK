package ru.kpfu.itis.group11506.one;


public class Card {

    private int cardLevel;
    private String cardName;

    public Card(int cardLevel, String cardName) {
        this.cardLevel = cardLevel;
        this.cardName = cardName;
    }

    public int getCardLevel() {
        return cardLevel;
    }

    public String getCardName() {
        return cardName;
    }
}
