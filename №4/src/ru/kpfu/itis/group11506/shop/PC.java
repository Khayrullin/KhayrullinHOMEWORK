package ru.kpfu.itis.group11506.shop;


public class PC extends Computer implements Comparable {

    public int getEnergyConsumption() {
        return energyConsumption;
    }

    public int energyConsumption;

    public int compareTo(Object o) {
        int res;
        if (o instanceof PC) {
            PC pss = (PC) o;
            res = energyConsumption - pss.getEnergyConsumption();
            if (res == 0) {
                return super.compareTo(o);
            }
        } else {
            return super.compareTo(o);
        }
        return res;
    }


    public void setEnergyConsumption(int energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
