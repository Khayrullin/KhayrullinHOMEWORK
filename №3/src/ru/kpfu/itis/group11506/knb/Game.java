package ru.kpfu.itis.group11506.knb;


public class Game {

    Player Player1 = new StupidPlayer();
    Player Player2 = new SmartPlayer();

    public void startGame(int tryCount) {
        int first = 0, second = 0;

        do {
            Figure player1Move = Player1.showFigure();
            Figure player2Move = Player2.showFigure();
            if (player1Move == player2Move) {
            } else if (player1Move == Figure.STONE && player2Move == Figure.PAPER) {
                second += 1;
                tryCount -= 1;
            } else if (player1Move == Figure.PAPER && player2Move == Figure.STONE) {
                first += 1;
                tryCount -= 1;
            } else if (player1Move == Figure.SCISSORS && player2Move == Figure.PAPER) {
                first += 1;
                tryCount -= 1;
            } else if (player1Move == Figure.PAPER && player2Move == Figure.SCISSORS) {
                second += 1;
                tryCount -= 1;
            } else if (player1Move == Figure.SCISSORS && player2Move == Figure.STONE) {
                second += 1;
                tryCount -= 1;
            } else if (player1Move == Figure.STONE && player2Move == Figure.SCISSORS) {
                first += 1;
                tryCount -= 1;
            }
        } while (tryCount > 0);
        System.out.println("First player wins " +first+ " times.");
        System.out.println("Second player wins " +second+ " times.");

    }


}
