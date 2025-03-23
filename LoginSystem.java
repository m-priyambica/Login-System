import java.io.*;
import java.util.*;

public class LoginSystem {
    static final String FILE_NAME = "users.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOptions: [1] Register  [2] Login  [3] Exit");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                registerUser(scanner);
            } else if (choice.equals("2")) {
                loginUser(scanner);
            } else if (choice.equals("3")) {
                System.out.println("👋 Exiting... Bye!");
                break;
            } else {
                System.out.println("❌ Invalid choice!");
            }
        }
        scanner.close();
    }

    public static void registerUser(Scanner scanner) throws IOException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + "," + password + "\n");
        }
        System.out.println("✅ Registered successfully!");
    }

    public static void loginUser(Scanner scanner) throws IOException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] user = line.split(",");
                if (user[0].equals(username) && user[1].equals(password)) {
                    System.out.println("🔓 Login successful!");
                    return;
                }
            }
        }
        System.out.println("❌ Invalid username or password!");
    }
}
