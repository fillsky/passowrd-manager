package encoding;

import java.util.Base64;
import java.util.Scanner;
import java.util.UUID;

public class OneTimePad {


    private int positionOfLetter = 0;
    private String key;

    public OneTimePad() {
    }


    public String keyGenerator(String message) {
        StringBuilder sb = new StringBuilder();

        int desiredLength = message.length();
        while (sb.length() < desiredLength) {
            sb.append(UUID.randomUUID().toString().replace("-",""));
        }
        String key = sb.substring(0, desiredLength);
        System.out.println("Generated key for coding is: " + key);
        this.key = key;
        return key;
    }

    public String encryptDecrypt(String message) {
        StringBuilder sb = new StringBuilder();
        int a, b, c = 0;

        for (int i = 0; i < message.length(); i++)  {
            a = message.charAt(i);
            b = key.charAt(i);
            c = a^b;
            char d = (char)c;
            sb.append(d);
        }
        String encrypted = sb.toString();
        System.out.println(encrypted);
        return encrypted;
    }

    public static String toBase64(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String fromBase64(String s) {
        return new String(Base64.getDecoder().decode(s));
    }


}
