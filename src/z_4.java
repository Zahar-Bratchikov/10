import java.io.*;

public class z_4 {
    public static boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static boolean MoreVowelsThanConsonants(String word) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (char ch : word.toLowerCase().toCharArray()) {
            if (isLetter(ch)) {
                if (isVowel(ch)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        return vowelCount > consonantCount;
    }

    public static void main(String[] args) {
        String inputFilePath = "text4in.txt";
        String outputFilePath = "text4out.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[_.,;:\\n\\t!?\\s]+");
                for (String word : words) {
                    if (MoreVowelsThanConsonants(word)) {
                        writer.write(word);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
