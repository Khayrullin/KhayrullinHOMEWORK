package ru.kpfu.itis.group11506.shellSort;


public class ShellSort {

    public Student[] Sort(Student[] students) {
        int d = students.length / 2;
//        long start = System.nanoTime();
        while (d > 0) {
            for (int i = 0; i < (students.length - d); i++) {
                int j = i;
                while (j >= 0 && students[j].getLocalDate() > students[j + d].getLocalDate()) {
                    Student m = students[j];
                    students[j] = students[j + d];
                    students[j + d] = m;
                    j--;
                }
            }
            d = d / 2;
        }
//        long  finish = System.nanoTime();
//        System.out.println(finish - start);
        return students;
    }
}
