package ru.kpfu.itis.group11506.shop;

public class Computer extends Electronics {

    protected int videoCardPower;

    public int compareTo(Object o) {
        int res;
        if (o instanceof Computer){
            Computer pss = (Computer) o;
            res = videoCardPower - pss.getVideoCardPower();
        }else {
            return super.compareTo(o);
        }
        return res;
    }

    public int getVideoCardPower() {
        return videoCardPower;
    }

    public void setVideoCardPower(int videoCardPower) {
        this.videoCardPower = videoCardPower;
    }
}
