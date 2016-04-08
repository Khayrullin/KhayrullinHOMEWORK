package ru.kpfu.itis.group11506.shop;

public class Consoles extends Electronics{
  protected   int memory;

    public int compareTo(Object o) {
        int res;
        if (o instanceof Consoles) {
            Consoles pss = (Consoles) o;
            res = memory - pss.getMemory();
        } else {
            return super.compareTo(o);
        }
        return res;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
