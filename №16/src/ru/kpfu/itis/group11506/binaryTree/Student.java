package ru.kpfu.itis.group11506.binaryTree;


class Student implements Comparable {
    private int rating;

    Student(int rating) {
        this.rating = rating;
    }

    int getRating() {
        return rating;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student) {
            Student st = (Student) o;
            if (rating > st.getRating()) {
                return 1;
            } else if (rating == st.getRating()) {
                return 0;
            }
        }
        return -1;
    }
}
