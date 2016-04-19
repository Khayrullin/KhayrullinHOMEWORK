package ru.kpfu.itis.group11506.binaryTree;


import java.util.ArrayList;
import java.util.Iterator;

public class Mrx {
    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();

        Student st = new Student(56);
        Student st10 = new Student(74);

        for (int i = 0; i < 4; i++) {
            arrayList.add(new Student((int) (Math.random() * 100)));
        }
        arrayList.add(st);
        arrayList.add(st10);
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Student((int) (Math.random() * 100)));
        }

        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            System.out.println(((Student) it3.next()).getRating());

        }
        System.out.println();


        Iterator it = arrayList.iterator();
        BynaryTree<Student> bynaryTree = new BynaryTree<>();
        while (it.hasNext()) {
            bynaryTree.addThing((Student) it.next());
        }

        Iterator<Node<Student>> it11 = bynaryTree.iterator();
        while (it11.hasNext()) {
            System.out.println(it11.next().getThing().getRating());
        }

        System.out.println(bynaryTree.contains(st));

        bynaryTree.remove(st);
        bynaryTree.remove(st10);

        Iterator<Node<Student>> it112 = bynaryTree.iterator();
        while (it112.hasNext()) {
            System.out.println(it112.next().getThing().getRating());
        }


    }
}
