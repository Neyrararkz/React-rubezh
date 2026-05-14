package service;

import model.User;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileService {
  public void saveUsersToFile(List<User> users, String fileName) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      for (User user : users) {
        writer.write(user.toString());
        writer.newLine();
      }
      System.out.println("Users are written into the file: " + fileName);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
