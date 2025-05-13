package org.exemple.csv_handler;

import org.example.csv_handler.CSVReader;
import org.example.enums.PermissionLevel;
import org.example.model.User;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {

    @Test
    void testReadFile() throws IOException {
        Path tempFile = Files.createTempFile("test_data", ".csv");
        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("Nome,Idade\n");
            writer.write("Bob,25\n");
            writer.write("Alice,30\n");
        }
        CSVReader reader = new CSVReader();
        List<String[]> data = reader.readFile(tempFile.toString());
        assertEquals(3, data.size());
        assertArrayEquals(new String[]{"Nome", "Idade"}, data.get(0));
        assertArrayEquals(new String[]{"Bob", "25"}, data.get(1));
        assertArrayEquals(new String[]{"Alice", "30"}, data.get(2));
        Files.delete(tempFile);
    }

    @Test
    void testReadUsers() throws IOException {
        Path tempFile = Files.createTempFile("test_users", ".csv");
        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("ID,Username,Password,Email,Phone,PermissionLevel,CPF\n");
            writer.write("1,john,pass1,john@example.com,123,CLIENT,111.111.111-11\n");
            writer.write("2,jane,pass2,jane@example.com,456,ADMIN,222.222.222-22\n");
        }
        CSVReader reader = new CSVReader();
        List<User> users = reader.readUsers(tempFile.toString());
        assertEquals(2, users.size());

        User user1 = users.get(0);
        assertEquals(1, user1.getId());
        assertEquals("john", user1.getUsername());
        assertEquals("john@example.com", user1.getEmail());
        assertEquals(PermissionLevel.CLIENT, user1.getPermissionLevel());
        assertEquals("111.111.111-11", user1.getCPF());

        User user2 = users.get(1);
        assertEquals(2, user2.getId());
        assertEquals("jane", user2.getUsername());
        assertEquals("jane@example.com", user2.getEmail());
        assertEquals(PermissionLevel.ADMIN, user2.getPermissionLevel());
        assertEquals("222.222.222-22", user2.getCPF());

        Files.delete(tempFile);
    }
}