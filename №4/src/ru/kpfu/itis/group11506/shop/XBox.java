package ru.kpfu.itis.group11506.shop;


public class XBox extends Consoles {

    private int gameNumber;

    public int getGameNumber() {
        return gameNumber;
    }

    public int compareTo(Object o) {
        int res;
        if (o instanceof XBox) {
            XBox pss = (XBox) o;
            res = gameNumber - pss.getGameNumber();
            if (res == 0) {
                return super.compareTo(o);
            }
        } else {
            return super.compareTo(o);
        }
        return res;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }
}
