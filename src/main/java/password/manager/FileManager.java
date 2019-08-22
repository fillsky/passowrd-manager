package password.manager;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.stream.Collectors;

public class FileManager {

    public static void dumpPasswordEntryToFile(HashSet<PasswordEntry> passwordEntries) throws IOException {
        CSVWriter writer = new CSVWriter(
                new FileWriter("passwords.csv"),
                ';',
                '"',
                '\\',
                "\n");

        writer.writeAll(passwordEntries.stream()
                .map(FileManager::passwordEntriesToArray)
                .collect(Collectors.toList()));

        writer.close();
    }

    private static String[] passwordEntriesToArray(PasswordEntry passwordEntry) {
        return new String[]{
                passwordEntry.getPassword(),
                passwordEntry.getServiceName(),
                passwordEntry.getLogin(),
                passwordEntry.getDescription()
        };
    }

}
