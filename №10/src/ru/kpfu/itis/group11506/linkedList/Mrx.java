package ru.kpfu.itis.group11506.linkedList;


public class Mrx {
    public static void main(String[] args) {
        LinkedList<Boolean> array = new LinkedList<>();
        LinkedList<Boolean> array2 = new LinkedList<>();
        Node<Boolean> nodeed = new Node<>();
        Node<Boolean> nodeed2 = new Node<>();
        try {
            System.out.println(nodeed2);
            System.out.println();

            array.add(new Node<Boolean>());
            array.add(new Node<Boolean>());
            array.add(new Node<Boolean>());
            array.add(nodeed);
            array.add(new Node<Boolean>());
            array.add(new Node<Boolean>());
            for (Object anArray : array) {
                System.out.println(anArray);
            }




        } catch (Exception e) {
            System.out.println("EXEPTION!");
            e.printStackTrace();
        }


    }
}
