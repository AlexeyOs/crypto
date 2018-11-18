package ru.hc128.crypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.hc128.crypto.util.IO.Input;
import ru.hc128.crypto.util.IO.Output;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class CryptoApplication {

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
		SpringApplication.run(CryptoApplication.class, args);

		System.out.println("Start program");
		String iv_srt = "@#$$54214AEFDCAE";
		String key_srt = "AAAAAAAAqweAAAAT";
		Scanner in = new Scanner(System.in);
		System.out.println("Input path to file: ");
		System.out.println("example:");
		System.out.println("/run/media/alex/ktom/tmp/test.txt");
		String pathToFile = in.next();
		System.out.println("Input true(encrypt) or false(decrypt)");
		boolean encrypt = in.nextBoolean();
		if (encrypt) {
			int i =0;
			byte[][] input  = new byte[count(pathToFile)][];
			byte[][] ed  = new byte[count(pathToFile)][];
			try(FileInputStream fin=new FileInputStream(pathToFile))
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
		}
	}

	public static byte[] encrypt(HC128Engine hc, byte[] data) {

		for (int i = 0; i < data.length; i++) {
			data[i] = hc.returnByte(data[i]);
		}
		return data;
	}
}
