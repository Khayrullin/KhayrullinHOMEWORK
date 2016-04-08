package ru.kpfu.itis.group11506.io;

import java.io.*;

public class Mrx {

    public static void main(String[] args) {

        writeFile();
        readFile();
        readFile2();
    }


    private static void writeFile() {
        try (DataOutputStream bos = new DataOutputStream(
                new FileOutputStream(new File(
                        "src\\ru\\kpfu\\itis\\group11506\\io\\out.bin")))) {
            for (int i = 0; i < 10; i++) {
                int q = (int) (Math.random() * 1000);
                bos.writeInt(q);
                System.out.println(q);
            }
            System.out.println();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    private static void readFile() {
        int[] buffer = new int[10];
        int j = -1;
        try (DataInputStream fis
                     = new DataInputStream(
                new FileInputStream(
                        new File("src\\ru\\kpfu\\itis\\group11506\\io\\out.bin")))) {
            for (int i = 0; i < buffer.length; i++) {
                int c = fis.readInt();
                if (c % 2 == 0) {
                    j += 1;
                    buffer[j] = c;
                }
            }
            writeFile2(buffer, j);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void writeFile2(int[] a, int b) {
        try (DataOutputStream bos = new DataOutputStream(
                new FileOutputStream(new File(
                        "src\\ru\\kpfu\\itis\\group11506\\io\\in.bin")))) {
            for (int i = 0; i < b + 1; i++) {
                bos.writeInt(a[i]);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void readFile2() {
        try (DataInputStream fis
                     = new DataInputStream(
                new FileInputStream(
                        new File("src\\ru\\kpfu\\itis\\group11506\\io\\in.bin")))) {
            while (true) {
                System.out.println(fis.readInt());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}