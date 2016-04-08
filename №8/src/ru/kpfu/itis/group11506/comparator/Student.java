package ru.kpfu.itis.group11506.comparator;


public class Student {

    private int d, m, y, localDate, studPoints;
    private String name;


    public int getD() {
        return d;
    }

    public int getY() {
        return y;
    }

    public int getM() {
        return m;
    }

    public String getName() {

        return name;
    }

    public int getStudPoints() {

        return studPoints;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Student(int d, int m, int y, int studPoints) {
        localDate = d + m * 100 + y * 10000;
        this.studPoints = studPoints;
        this.d = d;
        this.m = m;
        this.y = y;
    }

    public int getLocalDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return "Student name: " + name
                + "; Students points: " + studPoints + "; Birthday: " + d + "." + m + "." + y + ".";
    }

}
