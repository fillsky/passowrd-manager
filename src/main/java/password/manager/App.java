package password.manager;

import java.io.IOException;
import java.util.Scanner;

public class App {

    static String mainPassword = "1234qwer";
    static int numberOfTrials = 4;

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


//         Added lines in 23.08.2019

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < numberOfTrials; i++) {
            System.out.println("MENU 1 : Provide password to open the file");
            String fromKeyboard = sc.nextLine();
            if (fromKeyboard.equals(mainPassword)) {
                passwordManager.openMenu2();
            }
        }
        System.out.println("Application closed");


        public void openMenu2 () {

            Scanner sc = new Scanner(System.in);

            System.out.println("MENU 2 : Choose option you want to do:  ");
            System.out.println("\t\t1. - Display password for specified entry");
            System.out.println("\t\t2. - Add new entry and set password.");
            System.out.println("\t\t3. - Remove entry");
            System.out.println("\t\t4. - Change password for existing entry");
            System.out.println("\t\t5. - Safe and close");

            String fromKeyboard = sc.nextLine();


            switch (fromKeyboard) {
                case 1: {
                    passwordManager.displayPassword();
                }
                case 2: {
                    passwordManager.addPassword(String password);
                }

//                Added lines in 26.08.2019
                case 3: {
                    passwordManager.removePassword(PasswordEntry passwordEntry, String password);
                }
                case 4. {
                    passwordManager.changePassword(PasswordEntry passwordEntry, String password);
                }
                case 5. {
                    passwordManager.savePasswords();
                }

            }


//    wyswietl, dodaj, skopiuj, aktualizuj,
//    zablokuj save,
//    plik ani przez chwilę nie powinien miec odszyfrowanego pliku


        }
    }
}