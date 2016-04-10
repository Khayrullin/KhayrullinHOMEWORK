package ru.kpfu.itis.group11506.fileFinder;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class FileFinder {
    private boolean check, r;
    private String c, n;
    private File[] ourFiles = new File[10];
    private int j = 0;
    private String string = "";

    FileFinder(String p, String c, String n) {
        this(p, false, c, n);

    }
    FileFinder(String p, boolean r, String n) {
        this(p, r, "", n);

    }

    FileFinder(String p, String n) {
        this(p, false, null, n);

    }

    FileFinder(String p, boolean r, String c, String n) {
        this.r = r;
        this.n = n;
        this.c = c;
        try {
            findSomething(p);
            if (ourFiles[0] != null && c != null) {
                checker();
            }
            for (File ourFile : ourFiles) {
                if (ourFile != null) {
                    System.out.println(ourFile);
                    check = true;
                }
            }
            if (!check) {
                System.out.println("File Not Found");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("WRONG ADDRESS!!!!!!!!!!!!!!!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void findSomething(String path) {
        File[] files;
        File F = new File(path);
        files = F.listFiles();
        for (File file : files) {
            if (file.isDirectory() && r) {
                findSomething(file.getPath());
            } else if (file.getName().equals(n) && file.isFile()) {
                ourFiles[j] = file;
                j += 1;
            }
        }
    }

    private void checker() throws IOException {
        for (int i = 0; i < ourFiles.length && ourFiles[i] != null; i++) {
            FileReader fileReader = new FileReader(ourFiles[i]);
            while ((j = fileReader.read()) != -1) {
                string += (char) j;
            }
            if (!string.contains(c)) {
                ourFiles[i] = null;
            }
        }
    }


}
