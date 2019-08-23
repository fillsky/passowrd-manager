package password.manager;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;


public class PasswordManager {

    private HashSet<PasswordEntry> passwordEntries;

    public PasswordManager() {
        passwordEntries = new HashSet<>();
    }

    public boolean addPassword(String password, String serviceName) {
        return passwordEntries.add(new PasswordEntry(password, serviceName));
    }

    public boolean removePassword(PasswordEntry passwordEntry) {
        return passwordEntries.remove(passwordEntry);
    }

    public boolean changePassword(PasswordEntry passwordEntry, String password) {

        boolean isDuplicate = passwordEntries.stream()
                .anyMatch(pe -> pe.getPassword().equals(password));
        if (!isDuplicate) {
            passwordEntry.setPassword(password);
        }

        return isDuplicate;
    }

    public HashSet<PasswordEntry> getPasswordEntries() {
        return passwordEntries;
    }

    public void savePasswords() throws IOException {
        FileManager.dumpPasswordEntryToFile(passwordEntries);
    }

    //         Added lines in 23.08.2019

    public void displayPassword(PasswordEntry passwordEntry) {
        passwordEntry.getPassword();
        System.out.println("Your password for: " + passwordEntry + " is: ");
        System.out.println(password);
    }
}
