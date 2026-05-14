package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserRepository {
  private final String url = "jdbc&postgresql://localhost:5432/java_rubezh";
  private final String user = "postgres";
  private final String password = "123";

  public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    String query = "SELECT * FROM users";

    try (Connection conn = DriverManager.getConnection(url, user, password);
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
          users.add(new User(
            rs.getInt("id"), 
            rs.getString("name"), 
            rs.getString("email")
          ));
        }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return users;
  }
}

