package ru.kpfu.itis.group11506.exceptions;

enum Menu {

    Doshirak(20), Burger(50), Pizza(150);

    private int price;

    Menu(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
