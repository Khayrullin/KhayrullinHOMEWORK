package ru.kpfu.itis.group11506.stupidSort;

/*
*Задание "Stupid Sort".
*Creator : Хайруллин Булат 11-506.
*/

public class Mrx {

    public static void main(String[] args) {
        int[] numbers = {2, 1, 4, 3, 6, 5, 8, 9, 10, 7};
        int j;
        System.out.println(System.nanoTime());
        do {
            for (int i = 0; i < numbers.length; i++) {
                int numOfField = (int) (Math.random() * 10);
                int num2 = (int) (Math.random() * 10);
                j = numbers[numOfField];
                numbers[numOfField] = numbers[num2];
                numbers[num2] = j;
            }
            System.out.println();
        } while (((numbers[0] != 1) || (numbers[1] != 2)
                || (numbers[2] != 3) || (numbers[3] != 4) ||
                (numbers[4] != 5) || (numbers[5] != 6) ||
                (numbers[6] != 7) || (numbers[7] != 8) ||
                (numbers[8] != 9) || (numbers[9] != 10)));
        System.out.println(System.nanoTime());
        for (int nums : numbers) {
            System.out.print(nums + " ");
        }
    }
}
