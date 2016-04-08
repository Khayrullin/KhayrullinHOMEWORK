package ru.kpfu.itis.group11506.shop;


public class Simulator extends Sport{

    protected int modes;

    public int compareTo(Object o) {
        int res;
        if (o instanceof Simulator) {
            Simulator pss = (Simulator) o;
            res = modes - pss.getModes();
        } else {
            return super.compareTo(o);
        }
        return res;
    }

    public int getModes() {
        return modes;
    }

    public void setModes(int modes) {
        this.modes = modes;
    }
}


