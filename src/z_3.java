import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class z_3 {
    public static boolean UL(String text) {
        for (char arr : text.toCharArray()) {
            if (Character.isUpperCase(arr)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String filePath = "text3.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (UL(word)) {
                        System.out.println(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}