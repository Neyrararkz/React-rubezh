
import java.util.List;
import model.User;
import repository.UserRepository;
import service.FileService;


public class Main {
  public static void main(String[] args) {
      UserRepository repo = new UserRepository();
      FileService fileService = new FileService();

      List<User> users = repo.getAllUsers();

      System.out.println("Users: ");
      if (users.isEmpty()) {
        System.out.println("Data base is empty.");
      } else {
        for (User u : users) {
          System.out.println(u);
        }
        fileService.saveUsersToFile(users, "user.txt");
      }
  }
}