package ru.kpfu.itis.group11506.horses;


public class Mrx {

    private enum HorseNames {

        TOR, LOKI, STARK, HULK, ANTMAN, SPIDERMAN, CAPTAIN, ODIN
    }

    private HorseNames horseName;

    private int num = 1;

    private Mrx(HorseNames horseNames) {
        this.horseName = horseNames;
    }

    public static void main(String[] args) {
        HorseNames[] horse = HorseNames.values();
        System.out.println("Победитель на следующей строчке, остальные ниже: ");


        for (int index = 0; index < 8; index++) {
            final HorseNames horse2 = horse[index];
            new Thread(() -> new Mrx(horse2).run(10)).start();
        }


    }

    private void run(int n) {
        int j = 1;
        while (j != n +1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (j == 10){
                System.out.println(horseName);
            }
            j += 1;
        }

    }


}
