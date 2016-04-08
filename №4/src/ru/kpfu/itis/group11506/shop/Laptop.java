package ru.kpfu.itis.group11506.shop;


public class Laptop extends Computer {

    private int workingTime;

    public int compareTo(Object o) {
        int res;
        if (o instanceof Laptop){
            Laptop pss = (Laptop) o;
            res = getWorkingTime() - pss.getWorkingTime();
            if (res == 0) {
                return super.compareTo(o);
            }
        }else {
            return super.compareTo(o);
        }
        return res;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }
}
