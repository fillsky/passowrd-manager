package password.manager;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PasswordManager {

    private HashSet<PasswordEntry> passwordEntries;

    public PasswordManager() {
        passwordEntries = new HashSet<>();
    }

    public boolean addPassword(String password, String serviceName) {
        return passwordEntries.add(new PasswordEntry(password, serviceName));
    }

    public boolean removePassword(String serviceName) {
        for (PasswordEntry passwordEntry : passwordEntries) {
            if (passwordEntry.getServiceName().equalsIgnoreCase(serviceName)) {
                return passwordEntries.remove(passwordEntry);
            }
        }
        return false;

    }

    public boolean changePassword(String password, String serviceName) {
        boolean isDuplicate = passwordEntries.stream()
                .anyMatch(pe -> pe.getPassword().equals(password));
        if (!isDuplicate) {
            for (PasswordEntry passwordEntry : passwordEntries) {
                if (passwordEntry.getServiceName().equalsIgnoreCase(serviceName)) {
                    passwordEntry.setPassword(password);
                    return true;
                }
            }
        } else {
            System.out.println("This password does exist, choose different one.");
        }
        return false;

    }

    public HashSet<PasswordEntry> getPasswordEntries() {
        return passwordEntries;
    }

    public void savePasswords() throws IOException {
        FileManager.dumpPasswordEntryToFile(passwordEntries);
    }
    public void readPasswordEntries() throws IOException {

        passwordEntries = FileManager.readPasswordEntryFromFile();
    }



    //         Added lines in 23.08.2019

    public boolean displayPassword(String serviceName) {

        for (PasswordEntry passwordEntry : passwordEntries) {
            if (passwordEntry.getServiceName().equalsIgnoreCase(serviceName)) {
                System.out.println("Your password for: "
                        + passwordEntry.getServiceName()
                        + " is: "
                        + passwordEntry.getPassword());
                return true;
            }
        }
        System.out.println("No such service found.");
        return false;
    }
}
