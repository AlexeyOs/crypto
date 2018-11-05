package ru.hc128.util.IO;

import java.io.*;
import java.util.*;

public class InputOutput {

    private Scanner x;
    private static String space = "00000000000000000000000000000000000000000000000000" +
            "00000000000000000000000000000000000000000000000000" +
            "0000000000000000000000000000";
    private String strInFile;

    public void openFile() {
        try {
            x = new Scanner(new File("/run/media/alex/ktom/tmp/test.txt"));
        } catch (Exception e) {
            System.out.println("file not open \n");
        }
    }


    public void readFile() {
        while (x.hasNext()) {
            strInFile = x.next();
        }
    }

    public String[] partitionStringFromFile() {
        String strCopy = null;
        int i = 0;
        String[] result = new String[strInFile.length()/128 + 1];
        while (strInFile.length() > 0) {
            if (strInFile.length() < 128){
                strCopy = strInFile;
                int sizeSpace = (128 - strInFile.length());
                strCopy = strCopy + space.substring(0,sizeSpace);
                strInFile = "";
            } else {
                strCopy = strInFile.substring(0,127);
                strInFile = strInFile.substring(128,strInFile.length());
            }
            result[i] = strCopy;
            i++;
            System.out.println("---------LENGTH STRING---------" + strCopy.length());
        }
        return result;
    }

    public void closeFile() {
        x.close();
    }
}
