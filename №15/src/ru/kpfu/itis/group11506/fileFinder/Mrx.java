package ru.kpfu.itis.group11506.fileFinder;
/*
*Задание № 15.2 "Поиск файлов".
*Creator : Хайруллин Булат 11-506.
*/

public class Mrx {
    public static void main(String[] args) {
        new FileFinder("D:\\FINDME", true, "text", "File.txt");
        new FileFinder("D:\\FINDME", "File.txt");
        new FileFinder("D:\\FINDME", "text", "File.txt");
        new FileFinder("D:\\FINDME", true, "File.txt");


    }
}
