package ru.hc128.crypto;

import ru.hc128.crypto.params.KeyParameter;
import ru.hc128.crypto.params.ParametersWithIV;
import ru.hc128.util.IO.InputOutput;
import ru.hc128.util.encoders.Hex;

import java.io.UnsupportedEncodingException;


public class Main {

    private static final byte[] MSG = new byte[64];

    private static String[][] HC128_VerifiedTest =
            {
                    {
                            "Set 6, vector#  0",
                            "0053A6F94C9FF24598EB3E91E4378ADD",
                            "0D74DB42A91077DE45AC137AE148AF16",
                            "2E1ED12A8551C05AF41FF39D8F9DF933" +
                                    "122B5235D48FC2A6F20037E69BDBBCE8" +
                                    "05782EFC16C455A4B3FF06142317535E" +
                                    "F876104C32445138CB26EBC2F88A684C"
                    },
                    {
                            "Set 6, vector#  1",
                            "0558ABFE51A4F74A9DF04396E93C8FE2",
                            "167DE44BB21980E74EB51C83EA51B81F",
                            "4F864BF3C96D0363B1903F0739189138" +
                                    "F6ED2BC0AF583FEEA0CEA66BA7E06E63" +
                                    "FB28BF8B3CA0031D24ABB511C57DD17B" +
                                    "FC2861C32400072CB680DF2E58A5CECC"
                    },
                    {
                            "Set 6, vector#  2",
                            "0A5DB00356A9FC4FA2F5489BEE4194E7",
                            "1F86ED54BB2289F057BE258CF35AC128",
                            "82168AB0023B79AAF1E6B4D823855E14" +
                                    "A7084378036A951B1CFEF35173875ED8" +
                                    "6CB66AB8410491A08582BE40080C3102" +
                                    "193BA567F9E95D096C3CC60927DD7901"
                    },
                    {
                            "Set 6, vector#  3",
                            "0F62B5085BAE0154A7FA4DA0F34699EC",
                            "288FF65DC42B92F960C72E95FC63CA31",
                            "1CD8AEDDFE52E217E835D0B7E84E2922" +
                                    "D04B1ADBCA53C4522B1AA604C42856A9" +
                                    "0AF83E2614BCE65C0AECABDD8975B557" +
                                    "00D6A26D52FFF0888DA38F1DE20B77B7"
                    }
            };

    public static void main(String[] args) {
        System.out.println("Start program");

        InputOutput inputOutput = new InputOutput();
        inputOutput.openFile();
        inputOutput.readFile();
        String[] strFromFile = inputOutput.partitionStringFromFile();
        inputOutput.closeFile();

        StreamCipher hc = new HC128Engine();

        byte[][] encodeAnswer = new byte[HC128_VerifiedTest.length][];
        for (int i = 0; i != HC128_VerifiedTest.length; i++)
        {
            String[] test = HC128_VerifiedTest[i];
            encodeAnswer[i] = go(hc, "HC-128 - " + test[0], Hex.decode(test[1]), Hex.decode(test[2]), Hex.decode(test[3]), true);
            System.out.println( Hex.toHexString(encodeAnswer[i]));
        }



        byte[][] decodeAnswer = new byte[HC128_VerifiedTest.length][];

        for (int i = 0; i != HC128_VerifiedTest.length; i++)
        {
            String[] test = HC128_VerifiedTest[i];
            decodeAnswer[i] = go(hc, "HC-128 - " + encodeAnswer[0], Hex.decode(test[1]), Hex.decode(test[2]), Hex.encode(encodeAnswer[3]), false);
                //System.out.println( Hex.toHexString(decodeAnswer[i]));
        }

    }

    public static byte[] go(StreamCipher hc, String test, byte[] key, byte[] IV, byte[] expected, boolean encrypt) {
        KeyParameter kp = new KeyParameter(key);
        ParametersWithIV ivp = new ParametersWithIV(kp, IV);

        byte[] answer = new byte[64];
        hc.init(encrypt, ivp);
        for (int i = 0; i < 64; i++)
        {
            answer[i] = hc.returnByte(MSG[i]);
            /**
            if (hc.returnByte(MSG[i]) != expected[i])
            {
                System.out.println(test + " failure at byte " + i);
            }
             */
        }
        System.out.println("Success");
        return answer;
    }
}
