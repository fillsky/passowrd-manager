package encoding;

import java.util.Base64;
import java.util.Scanner;

public class Application {

    public static String toBase64(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String fromBase64(String s) {
        final String s1 = new String(Base64.getDecoder().decode(s));
        return s1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Put text to encrypt");
        String message = scanner.nextLine();
        System.out.println(message);

        OneTimePad oneTimePad = new OneTimePad();
        oneTimePad.keyGenerator(message);

        String encrypted = oneTimePad.encryptDecrypt(message);

        String decrypted = oneTimePad.encryptDecrypt(encrypted);
        System.out.println(decrypted);

        System.out.println("______________________________");

        String encryptedMessageInBase64 = toBase64(oneTimePad.encryptDecrypt(message));
        System.out.println(encryptedMessageInBase64);

        String decryptedMessageFromBase64 = oneTimePad.encryptDecrypt(fromBase64(encryptedMessageInBase64));
        System.out.println(decryptedMessageFromBase64);

    }
}
