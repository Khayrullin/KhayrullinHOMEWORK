package ru.kpfu.itis.group11506.shop;


public class RunRoad extends Simulator {

    private int compactnessDegree;

    public int compareTo(Object o) {
        int res;
        if (o instanceof RunRoad) {
            RunRoad pss = (RunRoad) o;
            res = compactnessDegree - pss.getCompactnessDegree();
            if (res == 0) {
                return super.compareTo(o);
            }
        } else {
            return super.compareTo(o);
        }
        return res;
    }

    public int getCompactnessDegree() {
        return compactnessDegree;
    }

    public void setCompactnessDegree(int compactnessDegree) {
        this.compactnessDegree = compactnessDegree;
    }
}
