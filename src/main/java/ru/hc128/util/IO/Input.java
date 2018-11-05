package ru.hc128.util.IO;

import java.io.*;
import java.util.*;

public class Input {

    private Scanner x;

    public void openFile() {
        try {
            x = new Scanner(new File("/run/media/alex/ktom/tmp/test.txt"));
        } catch (Exception e) {
            System.out.println("file not open \n");
        }
    }

    private int countStrings() {
        int i = 0;
        while (x.hasNext()) {
            x.next();
            i++;
        }
        return i;
    }

    public String[] readForEncryptFile() {
        String[] strInFile = new String[countStrings()];
        openFile();
        int i = 0;
        while (x.hasNext()) {
            strInFile[i] = x.next();
            i++;
        }
        return strInFile;
    }

    public byte[] readForDecryptFile() {
        String[] strInFile = new String[countStrings() + 1];
        openFile();
        List<Byte> bytes = new ArrayList<>();
        int i = 0;
        while (x.hasNext()) {
            strInFile[i] = x.next();
            while (strInFile[i].length() > 0){
                if (strInFile[i].indexOf(" ") > 0) {
                    bytes.add(Byte.parseByte(strInFile[i].substring(0, strInFile[i].indexOf(" "))));
                    strInFile[i] = strInFile[i].substring(strInFile[i].indexOf(" "), strInFile[i].length());
                } else {
                    bytes.add(Byte.parseByte(strInFile[i]));
                    strInFile[i] = "";
                }
            }
            i++;
        }
        byte[] result = new byte[bytes.size()];
        for (int l = 0; l < bytes.size(); l++){
            result[l] = bytes.get(l);
        }
        return result;
    }

    public void closeFile() {
        x.close();
    }
}
