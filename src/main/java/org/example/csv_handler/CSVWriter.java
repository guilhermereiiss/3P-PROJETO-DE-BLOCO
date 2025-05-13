package org.example.csv_handler;

import org.example.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    public void writeFile(String filePath, List<String[]> data) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] row : data) {
                writer.append(String.join(",", row));
                writer.append("\n");
            }
        }
    }

    public void writeUsers(String filePath, List<User> users) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Username,Password,Email,Phone,PermissionLevel,CPF\n");
            for (User user : users) {
                writer.append(String.format("%d,%s,%s,%s,%s,%s,%s\n",
                        user.getId(), user.getUsername(), user.getPassword(), user.getEmail(),
                        user.getPhone(), user.getPermissionLevel(), user.getCPF()));
            }
        }
    }

}