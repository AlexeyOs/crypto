package ru.hc128.crypto;

import ru.hc128.util.IO.Input;
import ru.hc128.util.IO.Output;


public class Main {

    public static void main(String[] args) {
        System.out.println("Start program");
        String iv_srt = "@#$$54214AEFDCAE";
        String key_srt = "AAAAAAAAqweAAAAT";

        boolean encrypt = false;

        if (encrypt) {
            Input inputOutput = new Input();
            inputOutput.openFile();
            String[] arrStr = inputOutput.readForEncryptFile();
            inputOutput.closeFile();
            for (int i = 0; i < arrStr.length; i++) {
                HC128Engine hc_enc = new HC128Engine(iv_srt.getBytes(), key_srt.getBytes());
                String s = arrStr[i];
                byte[] ed = encrypt(hc_enc, s.getBytes());
                new Output().rewriteEncryptFile(ed);
                hc_enc.reset();

                byte[] ed33 = encrypt(hc_enc, ed);
                System.out.println(new String(ed33));
            }
        } else {
            Input inputOutput = new Input();
            inputOutput.openFile();
            byte[] ed = inputOutput.readForDecryptFile();
            inputOutput.closeFile();
            for (int i = 0; i < ed.length; i++) {
                HC128Engine hc_enc = new HC128Engine(iv_srt.getBytes(), key_srt.getBytes());
                hc_enc.reset();

                byte[] ed33 = encrypt(hc_enc, ed);
                new Output().rewriteDecryptFile(new String(ed33));
                System.out.println(new String(ed33));
            }
        }

    }

    public static byte[] encrypt(HC128Engine hc, byte[] data) {

        for (int i = 0; i < data.length; i++) {
            data[i] = hc.returnByte(data[i]);
        }
        return data;
    }
}
