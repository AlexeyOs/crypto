package ru.hc128.crypto;

import ru.hc128.util.IO.Input;
import ru.hc128.util.IO.Output;
import ru.hc128.util.test.TestResult;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Start program");
        String iv_srt = "@#$$54214AEFDCAE";
        String key_srt = "AAAAAAAAqweAAAAT";

        boolean encrypt = false;
//        32 -18 17 5 60 -64 107 80 -14 56 57 84
//                -82 51 -3 32 30 -14 89
//        asdsadfasd123
//                ASDADSA
        if (encrypt) {
            Input inputOutput = new Input();
            inputOutput.openFile();
            String[] arrStr = inputOutput.readForEncryptFile();
            inputOutput.closeFile();
            byte[][] ed = new byte[arrStr.length][];
            for (int i = 0; i < arrStr.length; i++) {
                HC128Engine hc_enc = new HC128Engine(iv_srt.getBytes(), key_srt.getBytes());
                ed[i] = encrypt(hc_enc, arrStr[i].getBytes());

            }
            new Output().rewriteEncryptFile(ed);

        } else {
            Input inputOutput = new Input();
            inputOutput.openFile();
            byte[][] inputed = inputOutput.readForDecryptFile();
            inputOutput.closeFile();
            byte[][] outputed33 = new byte[inputed.length][];
            for(int i = 0; i < inputed.length; i++) {
                HC128Engine hc_enc = new HC128Engine(iv_srt.getBytes(), key_srt.getBytes());
                hc_enc.reset();

                outputed33[i] = encrypt(hc_enc, inputed[i]);
            }
            new Output().rewriteDecryptFile(outputed33);
            //System.out.println(new String(ed33));

        }

    }

    public static byte[] encrypt(HC128Engine hc, byte[] data) {

        for (int i = 0; i < data.length; i++) {
            data[i] = hc.returnByte(data[i]);
        }
        return data;
    }
}
