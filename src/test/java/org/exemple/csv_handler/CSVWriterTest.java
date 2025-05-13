package org.exemple.csv_handler;

import org.example.csv_handler.CSVWriter;
import org.example.enums.PermissionLevel;
import org.example.model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVWriterTest {

    @Test
    void testWriteFile() throws IOException {
        Path tempFile = Files.createTempFile("output_data", ".csv");
        CSVWriter writer = new CSVWriter();
        List<String[]> dataToWrite = Arrays.asList(
                new String[]{"Nome", "Idade"},
                new String[]{"Charlie", "40"},
                new String[]{"Diana", "35"}
        );
        writer.writeFile(tempFile.toString(), dataToWrite);
        List<String> lines = Files.readAllLines(tempFile);
        assertEquals("Nome,Idade", lines.get(0));
        assertEquals("Charlie,40", lines.get(1));
        assertEquals("Diana,35", lines.get(2));
        Files.delete(tempFile);
    }

    @Test
    void testWriteUsers() throws IOException {
        Path tempFile = Files.createTempFile("output_users", ".csv");
        CSVWriter writer = new CSVWriter();
        List<User> usersToWrite = Arrays.asList(
                new User(3, "peter", "333.333.333-33", "pass3", "peter@example.com", "789", PermissionLevel.CLIENT),
                new User(4, "susan", "444.444.444-44", "pass4", "susan@example.com", "012", PermissionLevel.ADMIN)
        );
        writer.writeUsers(tempFile.toString(), usersToWrite);
        List<String> lines = Files.readAllLines(tempFile);
        assertEquals("ID,Username,Password,Email,Phone,PermissionLevel,CPF", lines.get(0));
        assertTrue(lines.contains("3,peter,pass3,peter@example.com,789,CLIENT,333.333.333-33"));
        assertTrue(lines.contains("4,susan,pass4,susan@example.com,012,ADMIN,444.444.444-44"));
        Files.delete(tempFile);
    }
}