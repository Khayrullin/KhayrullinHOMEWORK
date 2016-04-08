package ru.kpfu.itis.group11506.one;

import java.util.Scanner;

public class Player extends AbsPlayer {
    private boolean wantOrNot;


    Scanner scanner = new Scanner(System.in);


    public boolean wantOrNot() {
        String humanAnswer;
        do {
            System.out.println("True or False:");
            humanAnswer = scanner.nextLine();
            if (humanAnswer.equals("True") || humanAnswer.equals("False") ||
                    humanAnswer.equals("true") || humanAnswer.equals("false")) {
                if (humanAnswer.equals("True") || humanAnswer.equals("true")) {
                    wantOrNot = true;
                    break;
                } else {
                    wantOrNot = false;
                    break;
                }
            }
        } while (!humanAnswer.equals("True") || !humanAnswer.equals("False"));

        return wantOrNot;
    }
}


