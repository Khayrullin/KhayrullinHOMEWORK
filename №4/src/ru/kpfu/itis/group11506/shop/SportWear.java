package ru.kpfu.itis.group11506.shop;


public class SportWear extends Sport{

    protected int breathabilityPercent;

    public int compareTo(Object o) {
        int res;
        if (o instanceof SportWear) {
            SportWear pss = (SportWear) o;
            res = breathabilityPercent - pss.getBreathabilityPercent();
        } else {
            return super.compareTo(o);
        }
        return res;
    }

    public int getBreathabilityPercent() {
        return breathabilityPercent;
    }

    public void setBreathabilityPercent(int breathabilityPercent) {
        this.breathabilityPercent = breathabilityPercent;
    }
}
