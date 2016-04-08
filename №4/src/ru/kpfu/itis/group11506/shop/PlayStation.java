package ru.kpfu.itis.group11506.shop;


public class PlayStation extends Consoles {

    private int processorPower;

    public int compareTo(Object o) {
        int res;
        if (o instanceof PlayStation) {
            PlayStation pss = (PlayStation) o;
            res = processorPower - pss.getProcessorPower();
            if (res == 0) {
                return super.compareTo(o);
            }
        } else {
            return super.compareTo(o);
        }
        return res;
    }

    public int getProcessorPower() {
        return processorPower;
    }

    public void setProcessorPower(int processorPower) {
        this.processorPower = processorPower;
    }
}
