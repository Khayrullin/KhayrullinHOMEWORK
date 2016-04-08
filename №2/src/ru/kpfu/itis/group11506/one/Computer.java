package ru.kpfu.itis.group11506.one;


public class Computer extends AbsPlayer {
    public boolean wantOrNot() {
        System.out.println("False");
        return wantCard(false);
    }

    private boolean wantCard(boolean solution) {
        return solution;
    }
}
