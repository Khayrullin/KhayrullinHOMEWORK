package ru.kpfu.itis.group11506.shellSort;

/*
*Задание 6.1: "Shell Sort".
*Creator : Хайруллин Булат 11-506.
*/
public class Mrx {
    public static void main(String[] args) {

        Student[] group = new Student[10];
        for (int i = 0; i < group.length; i++) {
            group[i] = new Student(i, (int) (Math.random() * 31 + 1),
                    (int) (Math.random() * 12 + 1),
                    (int) (Math.random() * 3 + 1996));
        }

        for (Student aGroup : group) {
            System.out.println(aGroup.toString());
        }
        System.out.println();

        ShellSort shellSort = new ShellSort();
        group = shellSort.Sort(group);
        for (Student aGroup : group) {
            System.out.println(aGroup.toString());
        }
    }
}
