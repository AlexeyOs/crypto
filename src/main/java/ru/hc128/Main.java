package ru.hc128;

import ru.hc128.crypto.HC128Engine;
import ru.hc128.util.IO.Input;
import ru.hc128.util.IO.Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Main {

    public static int count(String pathToFile) {
        int i = 0;
        try(FileInputStream fin=new FileInputStream(pathToFile))
        {
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            i++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;

    }

    public static void main(String[] args) throws IOException {
        //Path path = Paths.get("/run/media/alex/ktom/tmp/test.xls");
        //byte[] zipFileBytes= Files.readAllBytes(path);

        /**
        try(FileInputStream fin=new FileInputStream("/run/media/alex/ktom/tmp/test.xls");
            FileOutputStream fos=new FileOutputStream("/run/media/alex/ktom/tmp/test1.xls"))
        {
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            // записываем из буфера в файл
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
         */

        System.out.println("Start program");
        String iv_srt = "@#$$54214AEFDCAE";
        String key_srt = "AAAAAAAAqweAAAAT";
        String pathToFile = "/run/media/alex/ktom/tmp/test.xls";
        boolean encrypt = false;
        if (encrypt) {
            int i =0;
            byte[][] input  = new byte[count(pathToFile)][];
            byte[][] ed  = new byte[count(pathToFile)][];
            try(FileInputStream fin=new FileInputStream("/run/media/alex/ktom/tmp/test.xls"))
            {
                input [i] = new byte[fin.available()];
                // считываем буфер
                fin.read(input [i], 0, input [i].length);
                HC128Engine hc_enc = new HC128Engine(iv_srt.getBytes(), key_srt.getBytes());
                ed[i] = encrypt(hc_enc, input[i]);
                i++;
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
            new Output().rewriteEncryptFileZip(pathToFile, ed);

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
            new Output().rewriteDecryptFileZip(pathToFile, outputed33);
            /**
            int i =0;
            byte[][] ed= new byte[count(pathToFile)][];
            byte[][] ed33  = new byte[count(pathToFile)][];
            try(FileInputStream fin=new FileInputStream("/run/media/alex/ktom/tmp/test.xls"))
            {
                ed [i]  = new byte[fin.available()];
                // считываем буфер
                fin.read(ed[i] , 0, ed[i].length);

                HC128Engine hc_enc = new HC128Engine(iv_srt.getBytes(), key_srt.getBytes());
                hc_enc.reset();
                ed33[i] = encrypt(hc_enc, ed[i]);
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
            new Output().rewriteDecryptFileZip(pathToFile, ed33);
             */
        }

        /**
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
         */

    }

    public static byte[] encrypt(HC128Engine hc, byte[] data) {

        for (int i = 0; i < data.length; i++) {
            data[i] = hc.returnByte(data[i]);
        }
        return data;
    }
}
