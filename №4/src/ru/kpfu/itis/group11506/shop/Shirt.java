package ru.kpfu.itis.group11506.shop;


public class Shirt extends SportWear {

    private int cottonPercent;

    public int compareTo(Object o) {
        int res;
        if (o instanceof Shirt) {
            Shirt pss = (Shirt) o;
            res = cottonPercent - pss.getCottonPercent();
            if (res == 0) {
                return super.compareTo(o);
            }
        } else {
            return super.compareTo(o);
        }
        return res;
    }

    public int getCottonPercent() {
        return cottonPercent;
    }

    public void setCottonPercent(int cottonPercent) {
        this.cottonPercent = cottonPercent;
    }
}
