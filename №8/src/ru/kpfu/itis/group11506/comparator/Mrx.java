package ru.kpfu.itis.group11506.comparator;


import java.util.Comparator;

/*
*Задание 8.2: "Сортировка студентов с comparator".
*Creator : Хайруллин Булат 11-506.
*/
public class Mrx {
    public static void main(String[] args) {

        Student[] group = new Student[10];
        for (int i = 0; i < group.length; i++) {
            group[i] = new Student((int) (Math.random() * 31 + 1),
                    (int) (Math.random() * 12 + 1),
                    (int) (Math.random() * 3 + 1996),
                    (int) (Math.random() * 100 + 1));
        }
        group[0].setName("Noah");
        group[1].setName("Liam");
        group[2].setName("Mason");
        group[3].setName("William");
        group[4].setName("Ethan");
        group[5].setName("Michael");
        group[6].setName("Alexander");
        group[7].setName("James");
        group[8].setName("Daniel");
        group[9].setName("Jacob");
        for (Student aGroup : group) {
            System.out.println(aGroup.toString());
        }
        System.out.println();


        for (int i = 0; i < group.length - 1; i++) {
            int j = new BirthdaySorter().compare(group[i], group[i + 1]);
            if (j == 1) {
                Student aStud = group[i];
                group[i] = group[i + 1];
                group[i + 1] = aStud;
            }
        }
        int j = 0;
        int help = 0;
        for (int i = 0; i < group.length - 1; i++) {
            int m1 = group[group.length - 1].getLocalDate() - group[i].getLocalDate();
            if (m1 > j) {
                j = m1;
                help = i;
            }
        }
        int d = group[group.length - 1].getD() - group[help].getD();
        int m = group[group.length - 1].getM() - group[help].getM();
        int y = group[group.length - 1].getY() - group[help].getY();
        if (m < 0) {
            m = 12 + (group[group.length - 1].getM() - group[help].getM());
            y = y - 1;
        }
        if (d < 0) {
            d = 31 + (group[group.length - 1].getD() - group[help].getD());
            m = m - 1;
        }
        System.out.println("Максимальная разница в возрасте: "
                + y + " лет/год/года; "
                + m + " месяц/месяцев/месяца; "
                + d + " день/дней/дня; ");


        for (int i = 0; i < group.length - 1; i++) {
            j = new PointsSorter().compare(group[i], group[i + 1]);
            if (j == 1) {
                Student aStud = group[i];
                group[i] = group[i + 1];
                group[i + 1] = aStud;
            }
        }
        j = 0;
        for (int i = 0; i < group.length - 1; i++) {
            int m1 = group[group.length - 1].getStudPoints() - group[i].getStudPoints();
            if (m1 > j) {
                j = m1;
            }
        }
        System.out.println("Максимальная разница баллов: " + j);

        for (int i = 0; i < group.length - 1; i++) {
            j = new NameSorter().compare(group[i], group[i + 1]);
            if (j == 1) {
                Student aStud = group[i];
                group[i] = group[i + 1];
                group[i + 1] = aStud;
            }
        }
        j = 0;
        for (int i = 0; i < group.length - 1; i++) {
            int m1 = group[group.length - 1].getName().length() - group[i].getName().length();
            if (m1 > j) {
                j = m1;
            }
        }
        System.out.println("Максимальная разница длины имени: " + j);


    }

    private static class BirthdaySorter implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getLocalDate() > o2.getLocalDate()) {
                return 1;
            } else if (o1.getLocalDate() < o2.getLocalDate()) {
                return -1;
            } else return 0;
        }
    }

    private static class PointsSorter implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getStudPoints() > o2.getStudPoints()) {
                return 1;
            } else if (o1.getStudPoints() < o2.getStudPoints()) {
                return -1;
            } else return 0;
        }
    }

    private static class NameSorter implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getName().length() > o2.getName().length()) {
                return 1;
            } else if (o1.getName().length() < o2.getName().length()) {
                return -1;
            } else return 0;
        }
    }
}
