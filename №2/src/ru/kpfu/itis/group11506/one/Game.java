package ru.kpfu.itis.group11506.one;


public class Game {
    Player Player1 = new Player();
    Computer Player2 = new Computer();
    private int j;
    private int t = 1, p = 1;

    public void starsGame() {
//Раздается по 2 карты:
        CardStack cardStack = new CardStack();
        for (int i = 0; i < 2; i++) {
            Player1.takeCard(cardStack.giveRandomCard());
            Player2.takeCard(cardStack.giveRandomCard());
        }
//Показываем карты первого игрока(человека):
        System.out.print("Player_1 : ");
        Player1.showCards();
//Проверяем, попались ли кому то 21 или 22 очка:
        if (Player1.haveOchko()) {
            if (Player1.getCardSum() > Player2.getCardSum()) {
                Player1.sayWhoWin("Player_1 WIN!");
                System.out.print("Player_2:");
                Player2.showCards();
//если у обоих игроков выйгрышные очки, они сравниваются:
            } else if (Player1.getCardSum() == Player2.getCardSum()) {
                System.out.println("||||||||||||||||||||||||");
                System.out.println(" DRAW ");
                System.out.println(" Player_1 CARDS : ");
                Player1.showCards();
                System.out.println(" Player_2 CARDS : ");
                Player2.showCards();
            } else {
                Player2.sayWhoWin("Player_2 WIN!");
            }
        } else if (Player2.haveOchko()) {
            Player2.sayWhoWin("Player_2 WIN!");
        } else {
//Если ни у кого нет нужного Количества очков, Последовательно спрашиваем у игроков, нужна ли еще карта.
// Максимальное количество карт у одного игрока не должно превышать 5. 2 карты у каждого уже есть.
// цикл повторяется 3 раза максимум.
//Для удобства Пользователя начинаем с 2 игрока(компьютера):
            do {
                if (t == 1) {
                    System.out.println("Want to add cards? Answer (True or False) :");
                    System.out.print("Player_2 : ");
                    if (Player2.wantOrNot()) {
                        Player2.takeCard(cardStack.giveRandomCard());
                        Player2.showCards();
                        t = 1;
                    } else {
                        t = 0;
                    }
                }
//Проверяем у игрока №2 сумму очков, если выше 21 то автоматичеки проигрыш:
                if (Player2.haveOverPoint()) {
                    Player1.sayWhoWin("Player_1 WIN!");
                    System.out.print("Player_2:");
                    Player2.showCards();
                    j = 3;
                } else {
//Спрашиваем у 1 игрока о добавлении карты:
                    if (p == 1) {
                        System.out.println("Want to add cards? Answer (True or False) :");
                        System.out.print("Player_1 : ");
                        if (Player1.wantOrNot()) {
                            Player1.takeCard(cardStack.giveRandomCard());
                            Player1.showCards();
                            p = 1;
                        } else {
                            p = 0;
                        }
                        j = j + 1;
                    }
//Проверяем  игрока №1 на превышение очков:
                    if (Player1.haveOverPoint()) {
                        Player2.sayWhoWin("Player_2 WIN!");
                        j = 3;
                    }

                }
            } while (j < 3 && (t + p) > 0);
//Если цикл закончен, автоматически идет проверка очков:
            if (j < 2 || ((t + p) == 0)) {
                if (Player1.getCardSum() > Player2.getCardSum()) {
                    Player1.sayWhoWin("Player_1 WIN!");
                    System.out.print("Player_2:");
                    Player2.showCards();
                } else if (Player1.getCardSum() == Player2.getCardSum()) {
                    System.out.println("||||||||||||||||||||||||");
                    System.out.println(" DRAW ");
                    System.out.println("||||||||||||||||||||||||");
                    System.out.println(" Player_1 CARDS : ");
                    Player1.showCards();
                    System.out.println(" Player_2 CARDS : ");
                    Player2.showCards();
                } else {
                    Player2.sayWhoWin("Player_2 WIN!");
                }
            }
        }
    }
}