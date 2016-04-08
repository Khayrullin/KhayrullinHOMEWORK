package ru.kpfu.itis.group11506.shop;

public class Sneakers extends SportWear {

    private int weight;

    public int getWeight() {
        return weight;
    }
    public int compareTo(Object o) {
        int res;
        if (o instanceof Sneakers) {
            Sneakers pss = (Sneakers) o;
            res = weight - pss.getWeight();
            if (res == 0) {
                return super.compareTo(o);
            }
        } else {
            return super.compareTo(o);
        }
        return res;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
