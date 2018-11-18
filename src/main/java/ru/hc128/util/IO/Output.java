package ru.hc128.util.IO;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Output {

    public void rewriteEncryptFileZip(String pathToFile,byte[][] b) {
        try (FileWriter fileWriter = new FileWriter(pathToFile)) {
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0; i < b.length; i++) {
                for(int j = 0; j < b[i].length; j++) {
                    stringBuffer.append(b[i][j]);
                    if (j + 1 < b[i].length){
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append("\r\n");
            }
            System.out.println(stringBuffer);
            fileWriter.write(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rewriteDecryptFileZip(String pathToFile,byte[][] b) {
        int i = 0;
        try(FileOutputStream fos=new FileOutputStream(pathToFile))
        {
            // записываем из буфера в файл
            fos.write(b[i], 0, b[i].length);
            i++;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}
