import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        String proceed;

        do {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter ID Number (6 digits): ");
            String idNumber = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Year of Birth: ");
            String yearOfBirth = scanner.nextLine();

            records.add(firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + yearOfBirth);

            System.out.print("Do you want to add another record? (yes/no): ");
            proceed = scanner.nextLine();
        } while (proceed.equalsIgnoreCase("yes"));

        System.out.print("Enter filename to save (with .csv extension): ");
        String filename = scanner.nextLine();

        try (FileWriter writer = new FileWriter("src/" + filename)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Data saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
