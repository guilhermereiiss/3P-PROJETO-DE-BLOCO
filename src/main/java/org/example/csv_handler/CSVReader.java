package org.example.csv_handler;

import org.example.enums.PermissionLevel;
import org.example.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public List<String[]> readFile(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }

    public List<User> readUsers(String filePath) throws IOException {
        List<User> users = new ArrayList<>();
        List<String[]> rawData = readFile(filePath);
        if (!rawData.isEmpty()) {

            for (int i = 1; i < rawData.size(); i++) {
                String[] values = rawData.get(i);
                if (values.length == 7) { // Ajuste para o número correto de campos em User
                    User user = new User();
                    try {
                        user.setId(Integer.parseInt(values[0].trim()));
                        user.setUsername(values[1].trim());
                        user.setPassword(values[2].trim());
                        user.setEmail(values[3].trim());
                        user.setPhone(values[4].trim());
                        user.setPermissionLevel(PermissionLevel.valueOf(values[5].trim().toUpperCase()));
                        user.setCPF(values[6].trim());
                        users.add(user);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Erro ao converter linha para User: " + String.join(",", values) + " - " + e.getMessage());
                    }
                } else {
                    System.err.println("Linha inválida para User: " + String.join(",", values));
                }
            }
        }
        return users;
    }

}