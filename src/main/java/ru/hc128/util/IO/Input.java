package ru.hc128.util.IO;

import java.io.*;
import java.util.*;

public class Input {

    private Scanner x;

    public void openFile() {
        try {
            x = new Scanner(new File("D:/tmp/test.txt"));
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

    public byte[][] readForDecryptFile() throws IOException {
        String[] strInFile = new String[countStrings() + 1];
        openFile();
        File file = new File("D:/tmp/test.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String tempString = null;
        byte[][] res =  new byte[countStrings()][];
        int i = 0;
        while ((tempString = bufferedReader.readLine()) != null) {
            List<Byte> bytes = new ArrayList<>();
            System.out.println(tempString);
            while (tempString.length() > 0) {
                if (tempString.indexOf(",") > 0) {
                    System.out.println();
                    bytes.add(Byte.parseByte(tempString.substring(0, tempString.indexOf(","))));
                    tempString = tempString.substring(tempString.indexOf(",") + 1);
                } else {
                    bytes.add(Byte.parseByte(tempString));
                    tempString = "";
                }
            }
            // СДЕЛАТЬ обработку в матричный массив
            byte[] result = new byte[bytes.size()];
            for (int l = 0; l < bytes.size(); l++){
                result[l] = bytes.get(l);
            }
            res[i] = result;
            i++;
        }
//        List<Byte> bytes = new ArrayList<>();
//        int i = 0;
//        while (x.hasNext()) {
//            strInFile[i] = x.next();
//            while (strInFile[i].length() > 0){
//                if (strInFile[i].indexOf(" ") > 0) {
//                    bytes.add(Byte.parseByte(strInFile[i].substring(0, strInFile[i].indexOf(" "))));
//                    strInFile[i] = strInFile[i].substring(strInFile[i].indexOf(" "));
//                } else {
//                    bytes.add(Byte.parseByte(strInFile[i]));
//                    strInFile[i] = "";
//                }
//            }
//            i++;
//        }
//        byte[] result = new byte[bytes.size()];
//        for (int l = 0; l < bytes.size(); l++){
//            result[l] = bytes.get(l);
//        }
//        return result;
//        byte[] result = new byte[bytes.size()];
//        for (int l = 0; l < bytes.size(); l++){
//            result[l] = bytes.get(l);
//        }
        return res;
    }

    public void closeFile() {
        x.close();
    }
}
