package ru.kpfu.itis.group11506.hashMap;
/*
*Задание № 13.1 "SortedSet".
*Creators : Хайруллин Булат 11-506 и Филиппенко Тарас 11-506.
* В основном Хайруллин Булат реализовывал HashMap.
* Филиппенко Тарас в основном реализовывал SortedSet.
*/

import java.util.HashSet;


public class Mrx {
    public static void main(String[] args) {


        try {
            MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
            myHashMap.put(1, "Bulat");
            myHashMap.put(2, "Taras");
            myHashMap.put(21, "Java");

            for (int i = 3; i < 150; i++) {
                myHashMap.put(i, "check");
                System.out.println(myHashMap.get(i));
                System.out.println(i);
            }

            MyHashMap<Integer, String> myHashMap2 = new MyHashMap<>();
            myHashMap2.put(23, "blablabla");
            myHashMap.putAll(myHashMap2);
            HashSet set = (HashSet) myHashMap.keySet();
            System.out.println(set);


            System.out.println(myHashMap.get(23));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
