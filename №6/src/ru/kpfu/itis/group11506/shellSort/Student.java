package ru.kpfu.itis.group11506.shellSort;


public class Student{

    private int d, m, y, studNumber,localDate;


    public Student(int studNumber, int d, int m, int y) {
        localDate = d + m*100 + y*10000;
        this.studNumber = studNumber;
        this.d = d;
        this.m = m;
        this.y = y;
    }

    public int getLocalDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return "Student number: "
                + studNumber + "; Birthday: " + d + "." + m + "." + y + ".";
    }

}
