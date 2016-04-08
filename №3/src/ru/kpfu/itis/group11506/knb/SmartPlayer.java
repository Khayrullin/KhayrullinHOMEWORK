package ru.kpfu.itis.group11506.knb;

public class SmartPlayer extends Player {

    public Figure showFigure() {
        int a = (int) (Math.random() * 3);
        if (a == 0) {
            return Figure.STONE;
        } else if (a == 1) {
            return Figure.PAPER;
        } else {
            return Figure.SCISSORS;
        }
    }
}
