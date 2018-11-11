package ru.hc128.util.IO;

import java.io.FileWriter;
import java.io.IOException;

public class Output {


    public void rewriteEncryptFile(String pathToFile,byte[][] b) {
        //каждый новый массив с новой строки
        try (FileWriter fileWriter = new FileWriter(pathToFile)) {
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0; i < b.length; i++) {
                for(int j = 0; j < b[i].length; j++) {
                    stringBuffer.append(b[i][j] + ",");
                }
                stringBuffer.append("\r\n");
            }
            System.out.println(stringBuffer);
            fileWriter.write(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rewriteDecryptFile(String pathToFile, byte[][] outputByte) {
        String str = "";
        System.out.println(new String(outputByte[0]));
        for(int i = 0; i < outputByte.length; i++) {
                str = str + new String(outputByte[i]) + "\r\n";
        }
        try (FileWriter fileWriter = new FileWriter(pathToFile)) {
            fileWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
