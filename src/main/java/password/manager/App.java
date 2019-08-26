package password.manager;

import java.io.IOException;
import java.util.Scanner;

public class App {

    static String mainPassword = "1234qwer";
    static int numberOfTrials = 4;
    static PasswordManager passwordManager = new PasswordManager();

    public static void main(String[] args) throws IOException {


//        passwordManager.addPassword("12345678", "dd1.com");
//        passwordManager.addPassword("45486545", "dd2.com");
//        passwordManager.addPassword("25565515", "dd3.com");
//        passwordManager.addPassword("25645445", "dd4.com");
//        passwordManager.addPassword("25545654", "dd5.com");
//        passwordManager.addPassword("96546324", "dd6.com");
//        passwordManager.addPassword("99556855", "dd4.com");
//        passwordManager.addPassword("25596565", "dd7.com");
//        passwordManager.addPassword("25689561", "dd8.com");


        //passwordManager.savePasswords();

        passwordManager.readPasswordEntries();
        passwordManager.getPasswordEntries().forEach(System.out::println);

//         Added lines in 23.08.2019

        Scanner sc = new Scanner(System.in);

        /*for (int i = 0; i < numberOfTrials; i++) {
            System.out.println("MENU 1 : Provide password to open the file");
            String fromKeyboard = sc.nextLine();
            if (fromKeyboard.equals(mainPassword)) {
                i = numberOfTrials;
                openMenu2();
            }
        }*/

        openMenu2();
        passwordManager.savePasswords();
        System.out.println("Application closed");


    }

    public static void openMenu2() {

        Scanner sc = new Scanner(System.in);

        System.out.println("MENU 2 : Choose option you want to do:  ");
        System.out.println("\t\t1. - Display password for specified entry");
        System.out.println("\t\t2. - Add new entry and set password.");
        System.out.println("\t\t3. - Remove entry");
        System.out.println("\t\t4. - Change password for existing entry");
        System.out.println("\t\t5. - Save and close");

        int fromKeyboard = Integer.parseInt(sc.nextLine());


        switch (fromKeyboard) {
            case 1: {
                System.out.println("Put service name: ");
                String serviceName = sc.nextLine();
                System.out.println(serviceName);
                passwordManager.displayPassword(serviceName);
                break;
            }
            case 2: {
                System.out.println("Put service name you want to add: ");
                String serviceName = sc.nextLine();
                System.out.println("Put password for :" + serviceName);
                String password = sc.nextLine();
                passwordManager.addPassword(password, serviceName);
                break;
            }

//                Added lines in 26.08.2019
            case 3: {
                System.out.println("Put service name you want to remove: ");
                String serviceName = sc.nextLine();
                passwordManager.removePassword(serviceName);
                break;
            }
            case 4: {
                System.out.println("Put service name you want to change: ");
                String serviceName = sc.nextLine();
                System.out.println("Put password for :" + serviceName);
                String password = sc.nextLine();
                passwordManager.changePassword(password, serviceName);
                break;
            }
            case 5: {
                try {
                    passwordManager.savePasswords();
                } catch (IOException e) {
                    System.out.println("Error while saving file");
                    e.printStackTrace();
                }
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Choose correct option.");
                openMenu2();
                break;
            }


//    wyswietl, dodaj, skopiuj, aktualizuj,
//    zablokuj save,
//    plik ani przez chwilę nie powinien miec odszyfrowanego pliku


        }
    }
}