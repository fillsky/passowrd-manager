package password.manager;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        PasswordManager passwordManager = new PasswordManager();

        passwordManager.addPassword("12345678", "dd1.com");
        passwordManager.addPassword("45486545", "dd2.com");
        passwordManager.addPassword("25565515", "dd3.com");
        passwordManager.addPassword("25645445", "dd4.com");
        passwordManager.addPassword("25545654", "dd5.com");
        passwordManager.addPassword("96546324", "dd6.com");
        passwordManager.addPassword("99556855", "dd4.com");
        passwordManager.addPassword("25596565", "dd7.com");
        passwordManager.addPassword("25689561", "dd8.com");

        passwordManager.getPasswordEntries().forEach(System.out::println);

        passwordManager.savePasswords();
    }

}
