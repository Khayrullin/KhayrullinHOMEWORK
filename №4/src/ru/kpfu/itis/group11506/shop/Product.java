package ru.kpfu.itis.group11506.shop;

public class Product implements Comparable {

    protected double price;
    protected String name;
    protected int rating;

    @Override
    public int compareTo(Object o) {
        int result;
        if (o instanceof Product) {
            Product prod = (Product) o;
            result = (int) ((price - rating) - (prod.getPrice() - prod.getRating()));
            if (result == 0){
                result = getName().compareTo(prod.getName());
            }
        } else return -1;
        return result;
    }

    public String toString() {
        return name + " -  rating: " + rating + "; price: " + price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
