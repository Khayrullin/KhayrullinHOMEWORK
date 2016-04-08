package ru.kpfu.itis.group11506.shop;

public class Bicycle extends Simulator {

    public int getConvenienceDegree() {
        return convenienceDegree;
    }

    private int convenienceDegree;

    public int compareTo(Object o) {
        int res;
        if (o instanceof Bicycle) {
            Bicycle pss = (Bicycle) o;
            res = convenienceDegree - pss.getConvenienceDegree();
            if (res == 0) {
                return super.compareTo(o);
            }
        } else {
            return super.compareTo(o);
        }
        return res;
    }



    public void setConvenienceDegree(int convenienceDegree) {
        this.convenienceDegree = convenienceDegree;
    }
}
