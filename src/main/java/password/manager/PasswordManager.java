package password.manager;

import java.util.HashSet;
import java.util.List;

public class PasswordManager {

    private static HashSet<PasswordEntry> passwordEntries;

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
        passwordEntry.setPassword(password);
        return true;
    }
}
