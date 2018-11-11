package ru.hc128;

import ru.hc128.crypto.HC128Engine;
import ru.hc128.util.IO.Input;
import ru.hc128.util.IO.Output;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Start program");
        String iv_srt = "@#$$54214AEFDCAE";
        String key_srt = "AAAAAAAAqweAAAAT";
        String pathToFile = "D:/tmp/test.txt";
        boolean encrypt = false;
        if (encrypt) {
            Input inputOutput = new Input();
            inputOutput.openFile(pathToFile);
            String[] arrStr = inputOutput.readForEncryptFile(pathToFile);
            inputOutput.closeFile();
            byte[][] ed = new byte[arrStr.length][];
            for (int i = 0; i < arrStr.length; i++) {
                HC128Engine hc_enc = new HC128Engine(iv_srt.getBytes(), key_srt.getBytes());
                ed[i] = encrypt(hc_enc, arrStr[i].getBytes());

            }
            new Output().rewriteEncryptFile(pathToFile, ed);

        } else {
            Input inputOutput = new Input();
            inputOutput.openFile(pathToFile);
            byte[][] inputed = inputOutput.readForDecryptFile(pathToFile);
            inputOutput.closeFile();
            byte[][] outputed33 = new byte[inputed.length][];
            for(int i = 0; i < inputed.length; i++) {
                HC128Engine hc_enc = new HC128Engine(iv_srt.getBytes(), key_srt.getBytes());
                hc_enc.reset();

                outputed33[i] = encrypt(hc_enc, inputed[i]);
            }
            new Output().rewriteDecryptFile(pathToFile, outputed33);
        }

    }

    public static byte[] encrypt(HC128Engine hc, byte[] data) {

        for (int i = 0; i < data.length; i++) {
            data[i] = hc.returnByte(data[i]);
        }
        return data;
    }
}
