package org.example;

import org.example.csv_handler.CSVReader;
import org.example.csv_handler.CSVWriter;
import org.example.enums.PermissionLevel;
import org.example.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String usersFilePath = "users.csv";

        CSVWriter writer = new CSVWriter();
        List<User> usersToWrite = new ArrayList<>();
        usersToWrite.add(new User(1, "joao", "123.456.789-01", "senha123", "joao@email.com", "11111111", PermissionLevel.ADMIN));
        usersToWrite.add(new User(2, "maria", "987.654.321-02", "senha456", "maria@email.com", "22222222", PermissionLevel.CLIENT));

        try {
            writer.writeUsers(usersFilePath, usersToWrite);
            System.out.println("Usuários escritos para " + usersFilePath);
        } catch (IOException e) {
            System.err.println("Erro ao escrever arquivo CSV: " + e.getMessage());
        }

        CSVReader reader = new CSVReader();
        try {
            List<User> readUsers = reader.readUsers(usersFilePath);
            System.out.println("\nUsuários lidos de " + usersFilePath + ":");
            for (User user : readUsers) {
                System.out.println("ID: " + user.getId() + ", Username: " + user.getUsername() + ", CPF: " + user.getCPF() + ", Email: " + user.getEmail() + ", Nível: " + user.getPermissionLevel());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo CSV: " + e.getMessage());
        }

        String genericFilePath = "data.csv";
        try (java.io.FileWriter fw = new java.io.FileWriter(genericFilePath)) {
            fw.write("Nome,Idade,Cidade\n");
            fw.write("Carlos,30,Araguaína\n");
            fw.write("Ana,25,Palmas\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<String[]> genericData = reader.readFile(genericFilePath);
            System.out.println("\nDados genéricos lidos de " + genericFilePath + ":");
            for (String[] row : genericData) {
                System.out.println(String.join(" | ", row));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo CSV genérico: " + e.getMessage());
        }
    }
}