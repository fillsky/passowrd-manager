package password.manager;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

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

    public static HashSet<PasswordEntry> readPasswordEntryFromFile() throws IOException {
        CSVParserBuilder parserBuilder = new CSVParserBuilder()
                .withEscapeChar('\\')
                .withIgnoreLeadingWhiteSpace(true)
                .withQuoteChar('"')
                .withSeparator(';');

        CSVReaderBuilder readerBuilder = new CSVReaderBuilder(new FileReader("passwords.csv")).withCSVParser(parserBuilder.build());
        CSVReader reader = readerBuilder.build();
        return reader.readAll().stream()
                .map(FileManager::arrayToPasswordEntry)
                .collect(Collectors.toCollection(HashSet::new));
    }

    private static PasswordEntry arrayToPasswordEntry(String[] row) {
        String password = row[0];
        String serviceName = row[1];
        String login = row[2];
        String description = row[3];
        return new PasswordEntry(password, serviceName, login, description);


    }




}
