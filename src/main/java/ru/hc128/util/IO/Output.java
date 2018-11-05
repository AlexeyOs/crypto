package ru.hc128.util.IO;

import java.io.FileWriter;
import java.io.IOException;

public class Output {


    public void rewriteEncryptFile(byte[] b) {
        try (FileWriter fileWriter = new FileWriter("/run/media/alex/ktom/tmp/test.txt")) {
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0; i < b.length; i++) {
                stringBuffer.append(b[i] + " ");
            }
            fileWriter.write(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rewriteDecryptFile(String s) {
        try (FileWriter fileWriter = new FileWriter("/run/media/alex/ktom/tmp/test.txt")) {
            fileWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
