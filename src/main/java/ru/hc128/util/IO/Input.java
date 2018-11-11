package ru.hc128.util.IO;

import java.io.*;
import java.util.*;

public class Input {

    private Scanner x;

    public void openFile(String pathToFile) {
        try {
            x = new Scanner(new File(pathToFile));
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

    public String[] readForEncryptFile(String pathToFile) {
        String[] strInFile = new String[countStrings()];
        openFile(pathToFile);
        int i = 0;
        while (x.hasNext()) {
            strInFile[i] = x.next();
            i++;
        }
        return strInFile;
    }

    public byte[][] readForDecryptFile(String pathToFile) throws IOException {
        String[] strInFile = new String[countStrings() + 1];
        openFile(pathToFile);
        File file = new File(pathToFile);
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
        return res;
    }

    public void closeFile() {
        x.close();
    }
}
