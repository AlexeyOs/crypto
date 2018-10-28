package ru.hc128.crypto.test;

import ru.hc128.crypto.HC128Engine;
import ru.hc128.crypto.StreamCipher;
import ru.hc128.crypto.params.KeyParameter;
import ru.hc128.crypto.params.ParametersWithIV;
import ru.hc128.util.encoders.Hex;
import ru.hc128.util.test.SimpleTest;

/**
 * HC-128 and HC-256 Tests. Based on the test vectors in the official reference
 * papers, respectively:
 * <pre>
 * http://www.ecrypt.eu.org/stream/p3ciphers/hc/hc128_p3.pdf
 * http://www.ecrypt.eu.org/stream/p3ciphers/hc/hc256_p3.pdf
 * </pre>
 * See HCFamilyVecTest for a more exhaustive test based on the ecrypt vectors.
 */
public class HCFamilyTest
    extends SimpleTest
{
    private static final byte[] MSG = new byte[64];

    private static String[][] HC128_VerifiedTest =
        {
            {
                "Set 2, vector#  0",
                "00000000000000000000000000000000",
                "00000000000000000000000000000000",
                "82001573A003FD3B7FD72FFB0EAF63AA" +
                "C62F12DEB629DCA72785A66268EC758B" +
                "1EDB36900560898178E0AD009ABF1F49" +
                "1330DC1C246E3D6CB264F6900271D59C"
            },
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

    public String getName()
    {
        return "HC-128 and HC-256";
    }

    public void performTest()
    {
        StreamCipher hc = new HC128Engine();

        for (int i = 0; i != HC128_VerifiedTest.length; i++)
        {
            String[] test = HC128_VerifiedTest[i];
            HCTest(hc, "HC-128 - " + test[0], Hex.decode(test[1]), Hex.decode(test[2]), Hex.decode(test[3]));
        }
    }

    private void HCTest(StreamCipher hc, String test, byte[] key, byte[] IV, byte[] expected)
    {
        KeyParameter kp = new KeyParameter(key);
        ParametersWithIV ivp = new ParametersWithIV(kp, IV);

        hc.init(true, ivp);
        for (int i = 0; i < 64; i++)
        {
            if (hc.returnByte(MSG[i]) != expected[i])
            {
                fail(test + " failure at byte " + i);
            }
        }
    }

    public static void main(String[] args)
    {
        runTest(new HCFamilyTest());
    }
}
