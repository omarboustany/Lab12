import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser("src"); // Opens in src directory
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                System.out.println("File contents:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }

                System.out.println("\nSummary Report:");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of lines: " + lineCount);
                System.out.println("Number of words: " + wordCount);
                System.out.println("Number of characters: " + charCount);

            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
