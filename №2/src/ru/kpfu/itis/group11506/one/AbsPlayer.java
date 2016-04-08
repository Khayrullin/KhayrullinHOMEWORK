package ru.kpfu.itis.group11506.one;

public class AbsPlayer {
    protected int cardSum;
    protected String allCards = "TAKED CARDS:";
    protected boolean ochko, overPoint;

    protected void takeCard(Card card) {
        cardSum = card.getCardLevel() + cardSum;
        setAllCards(card.getCardName());
    }

    protected int getCardSum() {
        return cardSum;
    }

    protected void setAllCards(String cardName) {
        allCards = allCards + " " + cardName;
    }


    protected boolean haveOchko() {
        if (getCardSum() == 21 || getCardSum() == 22) {
            ochko = true;
        }
        return ochko;
    }

    protected boolean haveOverPoint() {
        if (getCardSum() > 21) {
            overPoint = true;
        }
        return overPoint;
    }

    protected void showCards() {

        System.out.println(allCards);
        System.out.println(cardSum);
        System.out.println();
    }

    protected void sayWhoWin(String gamer) {
        System.out.println("||||||||||||||||");
        System.out.println();
        System.out.println(gamer);
        showCards();
        System.out.println("||||||||||||||||");
    }


}



